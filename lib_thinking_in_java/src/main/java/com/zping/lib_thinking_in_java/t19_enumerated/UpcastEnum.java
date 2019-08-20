package com.zping.lib_thinking_in_java.t19_enumerated;//: enumerated/UpcastEnum.java
// No values() method if you upcast an enum

import com.zping.lib_thinking_in_java.net.mindview.util.Print;

enum Search {HITHER, YON}

public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();

        Enum e = Search.HITHER; // Upcast
        // e.values(); // No values() in Enum
        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }
} /*
getEnumConstants 返回结果与 vals 一样
Output:
HITHER
YON
*///:~
