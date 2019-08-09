package com.zping.lib_thinking_in_java.t12_exceptions;//: exceptions/ExceptionMethods.java
// Demonstrating the Exception Methods.

import static com.zping.lib_thinking_in_java.net.mindview.util.Print.print;

public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            print("Caught Exception");
            print("getMessage():" + e.getMessage());
            print("getLocalizedMessage():" + e.getLocalizedMessage());
            print("toString():" + e);
            print("printStackTrace():");
            e.printStackTrace(System.out);
        }
    }
}
// 每个方法都比前一个提供了更多的信息--实际上他们每一个都是前一个的超集
/* Output:
Caught Exception
getMessage():My Exception
getLocalizedMessage():My Exception
toString():java.lang.Exception: My Exception
printStackTrace():
java.lang.Exception: My Exception
        at ExceptionMethods.main(ExceptionMethods.java:8)
*///:~
