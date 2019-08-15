package com.zping.lib_thinking_in_java.t14_typeinfo;//: typeinfo/BoundedClassReferences.java

public class BoundedClassReferences {
  public static void main(String[] args) {
//    Class<Number> numberClass = int.class;
      Class<Integer> integerClass = int.class;
    Class<? extends Number> bounded = int.class;
    bounded = double.class;
    bounded = Number.class;
    // Or anything else derived from Number.
  }
} ///:~
