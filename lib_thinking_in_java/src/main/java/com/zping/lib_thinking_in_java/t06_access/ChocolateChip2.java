package com.zping.lib_thinking_in_java.t06_access;//: access/ChocolateChip2.java
//import access.cookie2.*;

import com.zping.lib_thinking_in_java.t06_access.cookie2.Cookie;

public class ChocolateChip2 extends Cookie {
    public ChocolateChip2() {
        System.out.println("ChocolateChip2 constructor");
    }

    public void chomp() {
        bite();
    } // Protected method

    public static void main(String[] args) {
        ChocolateChip2 x = new ChocolateChip2();
        x.chomp();
    }
} /* Output:
Cookie constructor
ChocolateChip2 constructor
bite
*///:~
