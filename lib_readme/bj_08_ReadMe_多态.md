##### 8.2 转机

8.2.1 方法调用绑定

将一个 **方法调用** 同 一个 **方法主体** 关联起来被称作 **绑定**。

如果在程序执行前进行绑定(如果有的话，由编译器和连接程序实现)，叫做 **<u>前期绑定</u>**。

运行时根据对象的类型进行绑定叫做**<u>后期绑定</u>**也叫做**<u>动态绑定</u>**或**<u>运行时绑定</u>**。

Java中除了static方法和final方法(private方法属于final方法)之外，其他所有的方法都是后期绑定。这意味着通常情况下，不必判定是否应该进行后期绑定—它会自动发生。



##### 8.2.4 缺陷："覆盖"私有方法(禁止子类创建与父类私有方法名字一样的方法)

```java
public class PrivateOverride {
    // private 方法 子类是不能覆盖的
    private void f() {
        print("private f()");
    }

    public static void main(String[] args) {
        PrivateOverride po = new Derived();
        po.f();
    }
}

class Derived extends PrivateOverride {
    // 这个方法不覆盖父类的f()方法，它是新的方法
    public void f() {
        print("public f()");
    }
}
// 输出结果：private f()
```

##### 8.2.5 缺陷：域与静态方法(任何域访问操作都将由编译器解析，因此不是多态的，基类中的域和导出类中的域名字不要一样，容易混淆)

```java
class Super {
  	// field
    public int field = 0;

    public int getField() {
        return field;
    }
}

class Sub extends Super {
  	// field
    public int field = 1;

    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}

public class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub(); // Upcast
        System.out.println("sup.field = " + sup.field +
                ", sup.getField() = " + sup.getField());
        Sub sub = new Sub();
        System.out.println("sub.field = " +
                sub.field + ", sub.getField() = " +
                sub.getField() +
                ", sub.getSuperField() = " +
                sub.getSuperField());
    }
} /* Output:
sup.field = 0, sup.getField() = 1
sub.field = 1, sub.getField() = 1, sub.getSuperField() = 0
sup.field 与 sub.field 分配在不同的存储空间中。这样，Sub实际上包含两个名字为field的域。
*///:~

class StaticSuper {
    public static String staticGet() {
        return "Base staticGet()";
    }

    public String dynamicGet() {
        return "Base dynamicGet()";
    }
}

class StaticSub extends StaticSuper {
    public static String staticGet() {
        return "Derived staticGet()";
    }

    public String dynamicGet() {
        return "Derived dynamicGet()";
    }
}

public class StaticPolymorphism {
    public static void main(String[] args) {
        StaticSuper sup = new StaticSub(); // Upcast
        System.out.println(sup.staticGet());
        System.out.println(sup.dynamicGet());
    }
} /* Output:
Base staticGet()
Derived dynamicGet()
*///:~
```



##### 8.3 构造器和多态

构造器实际上是static方法，只不过该static声明是隐式的。、

8.3.1 构造器的调用顺序

基类的构造器总是在导出类的构造过程中被调用。

1. 调用基类构造器。
2. 按声明顺序调用成员的初始化方法。
3. 调用导出类构造器的主体。

8.3.2 继承与清理

导出的类的dispose()方法一定要调用基类的dispose()方法，否则，基类的清理动作就不会发生。

8.3.3 构造器内部的多态方法的行为(这样很危险)

```java
class Glyph {
    void draw() {
        print("Glyph.draw()");
    }

    Glyph() {
        /* 111 */
        print("Glyph() before draw()");
        draw();
        print("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    /* 333 */
    RoundGlyph(int r) {
        radius = r;
        print("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    void draw() {
        /* 222 */
        print("RoundGlyph.draw(), radius = " + radius);
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
} /* Output:
Glyph() before draw()
RoundGlyph.draw(), radius = 0
Glyph() after draw()
RoundGlyph.RoundGlyph(), radius = 5
*///:~
```

前一节江苏的初始化顺序不完整。初始化的实际过程是：

1. 在其他任何事物发生之前，将分配给对象的存储空间初始化成二进制的0；
2. 如前所述那样调用基类构造器。此时，调用覆盖后的draw()方法(要在调用RoundGlyph构造器之前调用)，由于步骤1的缘故，此时radius的值为0.
3. 按照声明的顺序调用成员的初始化方法。
4. 调用导出类的构造器主体。

**<u>编写构造器时有一条准则：用尽可能简单的方法使对象进入正常状态，如果可以的话，避免调用其他方法。在构造器内唯一能够安全调用的那些方法是基类中的final方法（也适用于private方法，它们自动属于final方法）。这些方法不能被覆盖，因此也不会出现上述令人惊讶的问题。你可能无法总是能够遵循这条准则，但是应该朝着它努力</u>**

##### 8.4 协变返回类型

在导出类中的被覆盖方法可以返回基类方法的返回类型的某种导出的类型

```java
class Grain {
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {
    public String toString() {
        return "Wheat";
    }
}

class Mill {
  	/* 返回Grain */
    Grain process() {
        return new Grain();
    }
}

class WheatMill extends Mill {
    /* 返回 Wheat extends Grain */
    @Override
    Wheat process() {
        return new Wheat();
    }
}

public class CovariantReturn {
    public static void main(String[] args) {
        Mill m = new Mill();
        Grain g = m.process();
        System.out.println(g);
        m = new WheatMill();
        g = m.process();
        System.out.println(g);
    }
} /* Output:
Grain
Wheat
*///:~
```

##### 8.5 用继承进行设计

优先考虑组合，其次考虑继承。组合不会强制我们的程序设计进入继承的层次结构中。而且，组合更加灵活，因为它可以动态选择类型；相反，继承在编译时就需要知道确切类型。

8.5.2 向下转型与运行时类型识别















