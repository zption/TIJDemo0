package com.zping.lib_thinking_in_java.t07_reusing;//: reusing/Beetle.java
// The full process of initialization.

import static com.zping.lib_thinking_in_java.net.mindview.util.Print.print;

class Insect {
    private int i = 9;
    protected int j;

    /**  444   */
    Insect() {
        print("i = " + i + ", j = " + j);
        j = 39;
    }

    /**  111   */
    private static int x1 =
            printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        print(s);
        return 47;
    }
}

public class Beetle extends Insect {

    /**  555   */
    private int k = printInit("Beetle.k initialized");

    /**  666   */
    public Beetle() {
        print("k = " + k);
        print("j = " + j);
    }

    /**  222   */
    private static int x2 =
            printInit("static Beetle.x2 initialized");




    public static void main(String[] args) {
        /**  333   */
        print("Beetle constructor");
        Beetle b = new Beetle();
    }
} /* Output:
static Insect.x1 initialized
static Beetle.x2 initialized
Beetle constructor
i = 9, j = 0
Beetle.k initialized
k = 47
j = 39
*///:~
