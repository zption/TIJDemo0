//: enumerated/menu/TypeOfFood.java
package com.zping.lib_thinking_in_java.t19_enumerated.menu;

public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Food.Appetizer.SALAD;
        food = Food.MainCourse.LASAGNE;
        food = Food.Dessert.GELATO;
        food = Food.Coffee.CAPPUCCINO;
    }
} ///:~
