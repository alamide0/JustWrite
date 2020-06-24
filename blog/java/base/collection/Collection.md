### Collection 容器
#### 什么是容器？
撇开Java，容器是什么？装东西的器具叫容器。生活中容器随处可见，而且是我们生活不可或缺的一部分。水杯、水缸、湖泊、海洋……
容器为我们的存储和管理提供了便利。
在Java中容器是保存 "对象"的器具。用来存储和管理 Java 对象。官方的定义：*A collection
 represents a group of objects, known as its elements.*

**如果一个对象只包含固定数量的且生命周期都是已知的对象，那么这是一个非常简单的程序。---Thinking In Java**

#### 容器的类别
* Collection
* Map

Java 所有容器最终底层的存储结构都是数组或链表。

#### Collection集成结构
![pic](../../../../images/1010726-20170621004756882-1379253225.gif)

#### Collection
Java 的 Collection 是如何抽象的？

一个集合应该有以下几个基本行为
* 集合中元素的数量（size、isEmpty）
* 添加元素（add、addAll）
* 移除元素（remove、removeAll、clear）
* 遍历元素（iterator）
* 是否含有某元素（contains、containsAll、retainAll）

除了上面的基本行为外，还提供了返回集合中包含元素的数组
* toArray
* equals
* hasCode

#### AbstractCollection

AbstractCollection 实现了 Collection 的通用部分，包括:
* contains
* retainAll
* clear
* removeAll
* addAll
* containsAll
* remove
* isEmpty
* toArray

多数方法是利用 iterator 来实现，这里也体现的接口的优点，定义与实现分离，达到解耦的目的。



