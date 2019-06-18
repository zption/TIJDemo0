package com.zping.lib_thinking_in_java.t06_access;//: access/QualifiedMyClass.java

import com.zping.lib_thinking_in_java.t06_access.mypackage.MyClass;

public class QualifiedMyClass {
    public static void main(String[] args) {
        /*access.mypackage.*/MyClass m =
                new /*access.mypackage.*/MyClass();
    }
} ///:~
