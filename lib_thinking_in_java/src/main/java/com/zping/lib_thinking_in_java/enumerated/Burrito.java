//: enumerated/Burrito.java
package com.zping.lib_thinking_in_java.enumerated;
//import static enumerated.Spiciness.*;

import static com.zping.lib_thinking_in_java.enumerated.Spiciness.HOT;
import static com.zping.lib_thinking_in_java.enumerated.Spiciness.MEDIUM;
import static com.zping.lib_thinking_in_java.enumerated.Spiciness.NOT;

public class Burrito {
    Spiciness degree;

    public Burrito(Spiciness degree) {
        this.degree = degree;
    }

    public String toString() {
        return "Burrito is " + degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
    }
} /* Output:
Burrito is NOT
Burrito is MEDIUM
Burrito is HOT
*///:~
