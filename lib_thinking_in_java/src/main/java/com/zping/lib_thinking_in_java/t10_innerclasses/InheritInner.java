package com.zping.lib_thinking_in_java.t10_innerclasses;//: innerclasses/InheritInner.java
// Inheriting an inner class.

class WithInner {
    public WithInner() {
        System.out.println("WithInner()");
    }

    class Inner {
        public Inner() {
            System.out.println("Inner()");
        }

        public void comeOnBaby() {
            System.out.println("Inner comeOnBaby()");
        }
    }
}

public class InheritInner extends WithInner.Inner {
    //! InheritInner() {} // Won't compile
    InheritInner(WithInner wi) {
//        System.out.println("InheritInner()");
        wi.super();// 必须放在最前面 调用的是 Inner的构造方法
        System.out.println("InheritInner()");
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
        ii.comeOnBaby();
    }
} ///:~
/*
WithInner()
Inner()
InheritInner()
Inner comeOnBaby()
* */
