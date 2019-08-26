package com.zping.lib_thinking_in_java.t15_generics;//: generics/ExplicitTypeSpecification.java

import com.zping.lib_thinking_in_java.net.mindview.util.New;
import com.zping.lib_thinking_in_java.t14_typeinfo.pets.Person;
import com.zping.lib_thinking_in_java.t14_typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {
    }

    public static void main(String[] args) {
        f(New.<Person, List<Pet>>map());
    }
} ///:~
