package com.zping.lib_thinking_in_java.t10_innerclasses;//: innerclasses/Parcel9.java
// An anonymous inner class that performs
// initialization. A briefer version of Parcel5.java.

public class Parcel9 {
    // Argument must be final to use inside
    // anonymous inner class:
    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;

            public String readLabel() {
                return label;
            }
        };
    }

//    public static void test(final String string) {
////        string = "nima";
//        new Destination() {
//            @Override
//            public String readLabel() {
//                return string = "wocao";
//            }
//        };
//        System.out.println(string);
//    }


    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
        System.out.println(d.readLabel());
    }
} ///:Tasmania