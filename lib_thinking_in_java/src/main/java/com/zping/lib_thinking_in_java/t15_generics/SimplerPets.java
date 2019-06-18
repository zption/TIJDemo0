package com.zping.lib_thinking_in_java.t15_generics;//: generics/SimplerPets.java
import com.zping.lib_thinking_in_java.t14_typeinfo.pets.*;
import java.util.*;
import com.zping.lib_thinking_in_java.net.mindview.util.*;

public class SimplerPets {
  public static void main(String[] args) {
    Map<Person, List<? extends Pet>> petPeople = New.map();
    // Rest of the code is the same...
  }
} ///:~
