# ArrayList

ArrayList 底层用 Array 实现的有序的数据集合。数据存储结构为 Object[] 。

## 一些注意的点

### ArrayList 的底层 Array 是如何扩容的？
```
private void grow(int minCapacity) {
    // overflow-conscious code
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);//每次扩容为原来的一半
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```
数组每次扩容的大小为原来的一半
### 为什么 ArrayList 的插入删除性能较差？
严格来说，上面这句话是不严谨的！只有当出现数组批量移动时才会出现这个问题，如add(0, obj)，remove(0)。而在 列表尾部操作时并没有发生数组批量移动。

```
public void add(int index, E element) {
    rangeCheckForAdd(index);

    ensureCapacityInternal(size + 1);  // Increments modCount!!
    System.arraycopy(elementData, index, elementData, index + 1,
                     size - index);//数组发生了批量移动
    elementData[index] = element;
    size++;
}

public E remove(int index) {
    rangeCheck(index);

    modCount++;
    E oldValue = elementData(index);

    int numMoved = size - index - 1;
    if (numMoved > 0)
        System.arraycopy(elementData, index+1, elementData, index,
                         numMoved);//数组发生了批量移动
    elementData[--size] = null; // clear to let GC do its work

    return oldValue;
}
```
因为数组发生了批量移动
### 为什么会抛出 ConcurrentModificationException?

下面这段代码会抛出这个异常
```
List<Integer> list = new ArrayList<>();
for (int i = 0; i < 100; i++) {
    list.add(i);
}

for(Integer i: list){
    list.remove(i);
}
```
编译后代码如下
```
List<Integer> list = new ArrayList();

for(int i = 0; i < 100; ++i) {
    list.add(i);
}

Iterator var7 = list.iterator();

while(var7.hasNext()) {
    Integer i = (Integer)var7.next();
    list.remove(i);
}
```
再查看 iterator.next()

```
//---------------------------------------------------Iterator----------------------------------------------

int expectedModCount = modCount;

public E next() {
    checkForComodification();//抛出异常的位置
    int i = cursor;
    if (i >= size)
        throw new NoSuchElementException();
    Object[] elementData = ArrayList.this.elementData;
    if (i >= elementData.length)
        throw new ConcurrentModificationException();
    cursor = i + 1;
    return (E) elementData[lastRet = i];
}

final void checkForComodification() {
    if (modCount != expectedModCount)
        throw new ConcurrentModificationException();
}

//---------------------------------------------------ArrayList----------------------------------------------
public E remove(int index) {
    rangeCheck(index);

    modCount++;
    E oldValue = elementData(index);

    int numMoved = size - index - 1;
    if (numMoved > 0)
        System.arraycopy(elementData, index+1, elementData, index,
                         numMoved);
    elementData[--size] = null; // clear to let GC do its work

    return oldValue;
}
```

得出结论，抛出异常是因为 remove 修改了 modCount 的值。解决这个异常只能通过 Iterator.remove() 来移除元素。为什么库设计者制定了这个规范？我觉得主要是安全性问题，在遍历的过程中再修改元素
会造成数据错乱，在两处代码同时修改同一事物会产生无法预料的后果。

### ListIterator 有什么作用?

ListIterator 提供双向遍历及遍历过程中修改数据的功能。

### SubList 的作用？

SubList 可以取样 List 中的片段数据，我觉得在大量数据分析时有用，把整个大的列表划分成若干个小片段，启动多线程分析。

### 为什么存储结构 transient Object[] elementData 是 transient？

elementData 中保存的是对象的地址，保存下来没有任何意义，反序列化的时候这些对象的地址可能已经改变。

## ArrayList 迭代效率比较

实验方式：对相同数据长度与内容的 ArrayList，进行遍历。为防止虚拟机进行"优化"，以及更好的模拟真实环境，进行数据累加操作。为防止数据的偶然行，
采用 loop 多次，取平均结果。实验代码如下，
```java
public class ListPerformance {

    private static final int LOOPS = 500;
    private static final boolean isArrayList = true;

    private static int[] params = !isArrayList ? new int[]{10, LOOPS, 100, LOOPS, 1000, LOOPS, 10000, LOOPS}: new int[]{10, LOOPS, 100, LOOPS, 1000, LOOPS, 10000, LOOPS, 100000, LOOPS, 1000000, LOOPS};

    public static void main(String[] args) {
        ListPerformance performance = new ListPerformance();
        for (int i = 0; i < params.length; i += 2) {
            performance.testForeach(isArrayList, params[i], params[i + 1]);

            performance.testFori(isArrayList, params[i], params[i + 1]);

            Printer.printDivider();
        }
    }

    private int testForeach(boolean isArrayList, int... params) {

        return test("ForEach", new Run() {
            @Override
            public int test(List<Integer> list) {
                int sum = 0;
                for (int n : list) {
                    sum += n;
                }
                return sum;
            }
        }, isArrayList, params);

    }


    private int testFori(boolean isArrayList, int... params) {
        return test("ForI", new Run() {
            @Override
            public int test(List<Integer> list) {
                int sum = 0;
                for (int i = 0; i < list.size(); i++) {
                    sum += list.get(i);
                }
                return sum;
            }
        }, isArrayList, params);
    }

    private int test(String taskName, Run run, boolean isArrayList, int... params) {
        List<Integer> list = isArrayList ? arrayList(params[0]) : linkedList(params[0]);
        long start = System.nanoTime();

        int times = 0;
        for (int j = 0; j < params[1]; j++) {
            times += run.test(list);
        }
        Printer.print(taskName + " " + params[0] + " : cost " + ((System.nanoTime() - start) / params[1]));

        return times;
    }

    public List<Integer> arrayList(int size) {
        List<Integer> res = new ArrayList<>(size);
        fillList(res, size);
        return res;
    }

    public List<Integer> linkedList(int size) {
        List<Integer> res = new LinkedList<>();
        fillList(res, size);
        return res;
    }

    private void fillList(List<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    interface Run {
        int test(List<Integer> list);
    }

}

```
--------
测试结果：时间单位 ns  

| Size | 10 | 100 | 1000 | 10000 | 100000 | 1000000 | 10000000 |
| :------ | :------ | :------ | :------ | :------ | :------ | :------ |:------ |
| ForI | 1475 | 2741 | 6746| 9019  | 104810 | 1603336|17469473|
| ForEach | 2442 | 2982 | 15386| 10942 | 135029 | 2118354|18575762|

数据量越大，for i 遍历的耗时更短。

## 为什么推荐使用 ForEach 遍历？
数据证明 ForEach 对于 ArrayList 而言并没任何优势。但是为什么还是推荐使用 Foreach 遍历呢？我个人理解是这样的，见如下代码：
```
walk(getData());

List getData(){
    return new ArrayList();
}

void walk(List list){
    for(int i=0; i < list.size(); i++){
        Object obj = list.get(i);
        //do something
    }
}
```

上面的伪代码，逻辑是这样，获取数据再遍历处理数据。这里暂时是没有问题的，甚至还有性能上的优势。但是现在考虑这样一个问题，数据源改变数据结构
使用链表存储

```
List getData(){
    return new LinkedList();
}
```

[LinkedList 的遍历数据点这里](./LinkedList.md)  

那么这里问题就来了，LinkedList 使用 ForI 遍历数据，及其的低效，会产生严重的性能问题。而且这种问题甚至很难被发现，复杂的项目中数据源
和数据处理可能跨跃多个"层次"。所以使用 ForEach 可以避免一些难以预料的问题，虽然 它对有些 数据集合有些低效（例如 ArrayList），但是性能相差并不是特别大。