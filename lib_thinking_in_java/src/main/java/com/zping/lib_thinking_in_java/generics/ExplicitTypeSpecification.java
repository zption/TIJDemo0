package com.zping.lib_thinking_in_java.generics;//: generics/ExplicitTypeSpecification.java
import com.zping.lib_thinking_in_java.typeinfo.pets.*;
import java.util.*;
import com.zping.lib_thinking_in_java.net.mindview.util.*;

public class ExplicitTypeSpecification {
  static void f(Map<Person, List<Pet>> petPeople) {}
  public static void main(String[] args) {
    f(New.<Person, List<Pet>>map());
  }
} ///:~
