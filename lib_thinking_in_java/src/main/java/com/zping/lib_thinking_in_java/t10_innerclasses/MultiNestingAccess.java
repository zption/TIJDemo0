package com.zping.lib_thinking_in_java.t10_innerclasses;//: innerclasses/MultiNestingAccess.java
// Nested classes can access all members of all
// levels of the classes they are nested within.

class MNA {
    private void f() {
        System.out.println("f()");
    }

    class A {
        private void g() {
            System.out.println("g()");
        }

        public class B {
            void h() {
                System.out.println("h()");
                g();
                f();
            }
        }
    }
}

public class MultiNestingAccess {
    public static void main(String[] args) {
        MNA mna = new MNA();
        MNA.A mnaa = mna.new A();
        MNA.A.B mnaab = mnaa.new B();
        mnaab.h();
    }
} ///:~
/*
h()
g()
f()
*/
