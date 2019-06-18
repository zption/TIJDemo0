package com.zping.lib_thinking_in_java.t05_initialization;//: initialization/StaticInitialization.java
// Specifying initial values in a class definition.

import static com.zping.lib_thinking_in_java.net.mindview.util.Print.print;

class Bowl {
    Bowl(int marker) {
        print("Bowl(" + marker + ")");
    }

    void f1(int marker) {
        print("f1(" + marker + ")");
    }
}

class Table {
    static Bowl bowl1 = new Bowl(1);

    Table(String from) {
        print("Table()" + from);
        bowl2.f1(1);
    }

    void f2(int marker) {
        print("f2(" + marker + ")");
    }

    static Bowl bowl2 = new Bowl(2);
}

class Cupboard {
    Bowl bowl3 = new Bowl(5);
    static Bowl bowl4 = new Bowl(3);

    Cupboard(String from) {
        print("Cupboard()" + from);
        bowl4.f1(2);
    }

    void f3(int marker) {
        print("f3(" + marker + ")");
    }

    static Bowl bowl5 = new Bowl(4);
}

public class StaticInitialization {
    public static void main(String[] args) {
        print("==== first : Creating new Cupboard() in main");
        new Cupboard("222");
        print("==== second : Creating new Cupboard() in main");
        new Cupboard("333");
        print("new done!!");
        table.f2(1);
        cupboard.f3(1);
    }

    static Table table = new Table("111");
    static Cupboard cupboard = new Cupboard("111");
} /* Output:
Bowl(1)
Bowl(2)
Table()
f1(1)
Bowl(4)
Bowl(5)
Bowl(3)
Cupboard()
f1(2)
Creating new Cupboard() in main
Bowl(3)
Cupboard()
f1(2)
Creating new Cupboard() in main
Bowl(3)
Cupboard()
f1(2)
f2(1)
f3(1)
*///:~
