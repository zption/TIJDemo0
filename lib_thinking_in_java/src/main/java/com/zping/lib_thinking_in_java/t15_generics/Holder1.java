package com.zping.lib_thinking_in_java.t15_generics;//: generics/Holder1.java

class Automobile {
}

public class Holder1 {
    private Automobile a;

    public Holder1(Automobile a) {
        this.a = a;
    }

    Automobile get() {
        return a;
    }
} ///:~
