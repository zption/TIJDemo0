package com.zping.lib_thinking_in_java.t11_holding;//: holding/PetMap.java
//import com.zping.lib_thinking_in_java.typeinfo.pets.*;
//import java.util.*;

import com.zping.lib_thinking_in_java.t14_typeinfo.pets.Cat;
import com.zping.lib_thinking_in_java.t14_typeinfo.pets.Dog;
import com.zping.lib_thinking_in_java.t14_typeinfo.pets.Hamster;
import com.zping.lib_thinking_in_java.t14_typeinfo.pets.Pet;

import java.util.HashMap;
import java.util.Map;

import static com.zping.lib_thinking_in_java.net.mindview.util.Print.print;

public class PetMap {
    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<String, Pet>();
        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        petMap.put("My Hamster", new Hamster("Bosco"));
        print(petMap);
        Pet dog = petMap.get("My Dog");
        print(dog);
        print(petMap.containsKey("My Dog"));
        print(petMap.containsValue(dog));
    }
} /* Output:
{My Cat=Cat Molly, My Hamster=Hamster Bosco, My Dog=Dog Ginger}
Dog Ginger
true
true
*///:~
