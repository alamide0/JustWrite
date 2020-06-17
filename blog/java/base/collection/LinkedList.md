# LinkedList
LinkedList 的底层数据结构是**双向链表**。它实现了 List 和 Deque 接口。LinkedList 的功能很强大，可以作为一个线性表、一个队列、一个栈。
LinkedList 的优势在于插入和删除速度快，由于底层数据结构使用的是链表，插入和删除的时候不需要批量移动底层数据，只需要几个简单的指针操作。
它的劣势在于**随机**访问速度慢，需要从头开始遍历计数。由于底层数据结构为链表，所以也就不存在什么扩容的问题。

## LinkedList 遍历

对于 LinkedList 的遍历，这里禁止使用 ForI 遍历，要使用 ForEach。光说没有说服力，数据说话，

```
public class ListPerformance {


    private static final int LOOPS = 500;
    private static final boolean isArrayList = false;

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

| Size | 10 | 100 | 1000 | 10000 |
| :------ | :------ | :------ | :------ | :------ |
| ForI | 1905 | 5572 | 417866| 58427516  | 
| ForEach | 2465 | 2991 | 13605| 56025 |

可以看到随着 size 的增长 ForI 遍历变成了灾难。那么为什么会产生这个原因呢？看一下源码，
```
//for i
public E get(int index) {
     checkElementIndex(index);
     return node(index).item;
}

Node<E> node(int index) {
    // assert isElementIndex(index);

    if (index < (size >> 1)) {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    } else {
        Node<E> x = last;
        for (int i = size - 1; i > index; i--)
            x = x.prev;
        return x;
    }
}

//foreach
private class ListItr implements ListIterator<E> {
    private Node<E> lastReturned;
    private Node<E> next;
    private int nextIndex;
    private int expectedModCount = modCount;

    ListItr(int index) {
        // assert isPositionIndex(index);
        next = (index == size) ? null : node(index);
        nextIndex = index;
    }

    public boolean hasNext() {
        return nextIndex < size;
    }

    public E next() {
        checkForComodification();
        if (!hasNext())
            throw new NoSuchElementException();

        lastReturned = next;
        next = next.next;
        nextIndex++;
        return lastReturned.item;
    }
    .......
}


```

可以看到 get(int index) 是从表头开始，向后读取 index 个数，ForI 遍历整个 List 需要 walk (0 + size) * size / 2 次。
再来看 iterator 即 ForEach，只需要 walk size 次。所以可以看出性能的差距的原因在哪了。 