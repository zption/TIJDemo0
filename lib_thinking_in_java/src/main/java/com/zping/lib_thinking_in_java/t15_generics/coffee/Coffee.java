//: generics/coffee/Coffee.java
package com.zping.lib_thinking_in_java.t15_generics.coffee;

public class Coffee {
  private static long counter = 0;
  private final long id = counter++;
  public String toString() {
    return getClass().getSimpleName() + " " + id;
  }
} ///:~
