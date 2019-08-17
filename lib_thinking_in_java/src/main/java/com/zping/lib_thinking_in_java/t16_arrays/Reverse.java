package com.zping.lib_thinking_in_java.t16_arrays;//: arrays/Reverse.java
// The Collections.reverseOrder() Comparator

import com.zping.lib_thinking_in_java.net.mindview.util.Generated;

import java.util.Arrays;
import java.util.Collections;

import static com.zping.lib_thinking_in_java.net.mindview.util.Print.print;

public class Reverse {
    public static void main(String[] args) {
        CompType[] compType_array = Generated.array(
                new CompType[12], CompType.generator());
        print("before sorting:");
        print(Arrays.toString(compType_array));
        Arrays.sort(compType_array, Collections.reverseOrder());
        print("after sorting:");
        print(Arrays.toString(compType_array));
    }
} /* Output:
before sorting:
[[i = 58, j = 55], [i = 93, j = 61], [i = 61, j = 29]
, [i = 68, j = 0], [i = 22, j = 7], [i = 88, j = 28]
, [i = 51, j = 89], [i = 9, j = 78], [i = 98, j = 61]
, [i = 20, j = 58], [i = 16, j = 40], [i = 11, j = 22]
]
after sorting:
[[i = 98, j = 61], [i = 93, j = 61], [i = 88, j = 28]
, [i = 68, j = 0], [i = 61, j = 29], [i = 58, j = 55]
, [i = 51, j = 89], [i = 22, j = 7], [i = 20, j = 58]
, [i = 16, j = 40], [i = 11, j = 22], [i = 9, j = 78]
]
*///:~
