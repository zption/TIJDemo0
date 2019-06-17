package com.zping.lib_thinking_in_java.generics;//: generics/Manipulation.java
// {CompileTimeError} (Won't compile)

class Manipulator<T> {
    private T obj;

    public Manipulator(T x) {
        obj = x;
    }
    // Error: cannot find symbol: method f():
//  public void manipulate() { obj.f(); }
}

public class Manipulation {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator =
                new Manipulator<HasF>(hf);
        // TODO: 2019/6/17 有错误
//        manipulator.manipulate();
    }
} ///:~
