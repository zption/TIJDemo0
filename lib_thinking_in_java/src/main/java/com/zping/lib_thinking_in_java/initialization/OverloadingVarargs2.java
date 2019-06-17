package com.zping.lib_thinking_in_java.initialization;//: initialization/OverloadingVarargs2.java
// {CompileTimeError} (Won't compile)

public class OverloadingVarargs2 {
    static void f(float i, Character... args) {
        System.out.println("first");
    }

    static void f(Character... args) {
        System.out.print("second");
    }

    public static void main(String[] args) {
        f(1, 'a');
        // TODO: 2019/6/17 有错误
        //    f('a', 'b');
    }
} ///:~
