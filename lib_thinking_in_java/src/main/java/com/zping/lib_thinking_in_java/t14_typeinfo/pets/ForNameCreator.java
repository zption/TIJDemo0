//: typeinfo/pets/ForNameCreator.java
package com.zping.lib_thinking_in_java.t14_typeinfo.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types =
            new ArrayList<Class<? extends Pet>>();
    // Types that you want to be randomly created:
    private static String[] typeNames = {
            "t14_typeinfo.pets.Mutt",
            "t14_typeinfo.pets.Pug",
            "t14_typeinfo.pets.EgyptianMau",
            "t14_typeinfo.pets.Manx",
            "t14_typeinfo.pets.Cymric",
            "t14_typeinfo.pets.Rat",
            "t14_typeinfo.pets.Mouse",
            "t14_typeinfo.pets.Hamster"
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames)
                types.add((Class<? extends Pet>) Class.forName(name));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    public List<Class<? extends Pet>> getTypes() {
        return types;
    }
} ///:~
