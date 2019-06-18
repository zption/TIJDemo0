package com.zping.lib_thinking_in_java.t15_generics;//: generics/LimitsOfInference.java
import com.zping.lib_thinking_in_java.t14_typeinfo.pets.*;
import java.util.*;

public class LimitsOfInference {
  static void
  f(Map<Person, List<? extends Pet>> petPeople) {}
  public static void main(String[] args) {
    // f(New.map()); // Does not compile
  }
} ///:~
