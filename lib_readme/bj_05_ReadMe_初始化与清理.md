

##### 5.2.方法重载

 区分重载的方法

- 参数是否一样，包括数量，类型和位置

  如果传入的数据类型(实际参数类型)小于方法中声明的形式参数类型，实际数据类型就会被提升。

  char型略有不同，如果无法找到恰好接收char参数的方法，就会把char直接提升至int型。

- 以返回值区分重载方法 是行不通的。

  void function(){};    int function(){};  代码  function(); 调用哪个方法是不确定的。

##### 5.4 this关键字

```java
class Banana {
    void peel(int i) { /* ... */ }
}

public class BananaPeel {
    public static void main(String[] args) {
        Banana a = new Banana(),
                b = new Banana();
        a.peel(1);
        b.peel(2);
    }
}
peel()怎么知道自己是被a调用的还是被b调用的呢，编译器会暗自把"所操作对象的引用"作为第一个参数传递给peel().所以上述两个方法的调用就变成了这样：
Banana.peel(a,1);
Banana.peel(b,2);
```

**this关键字只能在方法内部使用，表示对"调用方法的哪个对象"的引用。**

```java
Flower(String s, int petals) {
    this(petals);
    //!    this(s); // Can't call two!
    this.s = s; // Another use of "this"
    print("String & int args");
}
可以用this调用一个构造器，最多只能一个。并且必须在方法的最开始，否则编译器会报错
```

- static的含义

static方法就是没有this的方法。

##### 5.5 清理：终结处理和垃圾回收

finalize()工作原理"假定"是这样的：一旦垃圾回收器准备好释放对象占用的存储空间，
将首先调用其finalize()方法，并且在下一次垃圾回收动作发生时，
才会真正回收对象占用的内存。所以要是你打算用finalize()，
就能在垃圾回收时刻做一些重要的清理工作。
(和C++中的析构函数完全不是一回事)，析构函数肯定会销毁这个对象，
而Java里的对象却并非总是被垃圾回收。

1. 对象可能不被垃圾回收。
2. 垃圾回收并不等于"析构"
3. 垃圾回收只与内存有关

之所以要有finalize()，是由于在分配内存是可能采用了类似C语言中的做法，而非Java中的通常做法。这种情况主要发生在使用"本地方法"的情况下。在finalize()中用本地方法调用 free()。

5.5.4 垃圾回收器如何工作(文本介绍)

- 引用计数：简单但是速度很慢的垃圾回收技术。如果对象之间存在循环引用，可能回出现"对象应该被回收，但引用计数却不为零"的情况。似乎没有被应用于任何一种Java虚拟机实现中。
- 自适应垃圾回收技术：
  1. 停止-复制：暂停程序运行，将所有存活的对象从当前堆复制到另一个堆，没有被复制的都是垃圾。效率低：意识因为要两个堆来回倒腾。二是复制，当程序稳定，可能产生少量垃圾的情况下，来回复制就很浪费了。
  2. 标记-清扫：遍历所有引用，标记存活的对象，未标记的对象被释放。导致堆空间不连续。(也要在程序暂停的情况下进行)

##### 5.6 成员初始化

Java尽力保证：所有的变量在使用前都能得到恰当的初始化。对于方法的局部变量，Java以编译时错误的形式来贯彻这种保证。如下示例：

要是类的数据成员并且是基本类型，情况就会变得不一样，类的每个基本类型数据成员保证都会有一个初始值。

```java
void f(){
    String s;
    // 这行代码会报错，提示 s没有初始化
    String h = s + "hi";
}
```



##### 5.7 构造器初始化

```java
public class Counter {
    int i;

    Counter() {
        i = 7;
    }
}
// i首先被赋值为0，然后变成7；
```

1️⃣：初始化顺序

- 在类的内部，成员变量定义的先后顺序决定了其初始化的顺序。所有的成员变量都会在调任何方法(包括构造器方法)前得到初始化。

2️⃣：静态代码块只会执行一次。



##### 5.8.1 可变参数列表





##### 5.9 枚举类型

- 当你创建enum时，编译器会自动添加一些有用的特性。eg：会创建toString()方法，以便你可以很方便的显示某个enum实例的名字。还会创建ordinal()方法，用来表示某个特定enum常量的声明顺序，以及static values()方法，用来按照enum常量的声明顺序，产生由这些常量组成的数组：

```java
public class EnumOrder {
    public static void main(String[] args) {
        for (Spiciness s : Spiciness.values()) {
            System.out.println(s + ", ordinal " + s.ordinal());
        }
    }
} /* Output:
NOT, ordinal 0
MILD, ordinal 1
MEDIUM, ordinal 2
HOT, ordinal 3
FLAMING, ordinal 4
*///:~
```

- 近况enum看起来像是一种新的数据类型，但是这个关键字是为enum生成对应的类时，产生了某些编译器的行为，因此很大程度上，你可以将enum当做其他任何类来处理。

  事实上，enum确实是类，并且有自己的方法。

- enum有一个特别适用的特性，它可以在switch语句中使用。