package com.zping.lib_thinking_in_java.t12_exceptions;//: exceptions/FullConstructors.java

class MyException extends Exception {
    public MyException() {
    }

    public MyException(String msg) {
        super(msg);
    }
}

public class FullConstructors {
    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            e.printStackTrace();
            // 输出到控制台
            e.printStackTrace(System.out);
            /*
            * packagename.MyException
	at packagename.FullConstructors.f(FullConstructors.java:15)
	at packagename.FullConstructors.main(FullConstructors.java:25)
	*/
        }
        try {
            g();
        } catch (MyException e) {
            e.printStackTrace();
            e.printStackTrace(System.out);
            /*
            * packagename.MyException: Originated in g()
	at packagename.FullConstructors.g(FullConstructors.java:20)
	at packagename.FullConstructors.main(FullConstructors.java:30)*/
        }
    }
} /* Output:
Throwing MyException from f()
MyException
        at FullConstructors.f(FullConstructors.java:11)
        at FullConstructors.main(FullConstructors.java:19)
Throwing MyException from g()
MyException: Originated in g()
        at FullConstructors.g(FullConstructors.java:15)
        at FullConstructors.main(FullConstructors.java:24)
*///:~
