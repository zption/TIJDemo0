package com.zping.lib_thinking_in_java.t14_typeinfo;//: typeinfo/ClassCasts.java

class Building {
}

class House extends Building {
}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        // 两种转型
        House h = houseType.cast(b);
        House house = (House) b; // ... or just do this.
    }
} ///:~
