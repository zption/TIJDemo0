//: enumerated/EnumSets.java
// Operations on EnumSets
package com.zping.lib_thinking_in_java.t19_enumerated;

import java.util.EnumSet;

import static com.zping.lib_thinking_in_java.net.mindview.util.Print.print;
import static com.zping.lib_thinking_in_java.t19_enumerated.AlarmPoints.BATHROOM;
import static com.zping.lib_thinking_in_java.t19_enumerated.AlarmPoints.KITCHEN;
import static com.zping.lib_thinking_in_java.t19_enumerated.AlarmPoints.OFFICE1;
import static com.zping.lib_thinking_in_java.t19_enumerated.AlarmPoints.OFFICE4;
import static com.zping.lib_thinking_in_java.t19_enumerated.AlarmPoints.STAIR1;
import static com.zping.lib_thinking_in_java.t19_enumerated.AlarmPoints.STAIR2;

public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points =
                EnumSet.noneOf(AlarmPoints.class); // Empty set
        points.add(BATHROOM);
        print(points);
        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        print(points);
        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        print(points);
        points = EnumSet.complementOf(points);
        print(points);
    }
} /* Output:
[BATHROOM]
[STAIR1, STAIR2, BATHROOM, KITCHEN]
[LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM, UTILITY]
[LOBBY, BATHROOM, UTILITY]
[STAIR1, STAIR2, OFFICE1, OFFICE2, OFFICE3, OFFICE4, KITCHEN]
*///:~
