# List

* An ordered collection (also known as a <i>sequence</i>).  The user of this
interface has precise control over where in the list each element is inserted. 
The user can access elements by their integer index (position in the list), and search for elements in the list.

* Unlike sets, lists typically allow duplicate elements.

实现 List 接口的实体类有 ArrayList、LinkedList、Vector。Vector 中的每一个操作都实现了同步，这在单线程访问时会付出额外的开销，
所以 Vector 基本上被弃用了，当需要同步时，可以使用 Collections 来实现。

## ArrayList 和 LinkedList 性能对比




