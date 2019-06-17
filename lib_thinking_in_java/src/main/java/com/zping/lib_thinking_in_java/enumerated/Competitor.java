//: enumerated/Competitor.java
// Switching one enum on another.
package com.zping.lib_thinking_in_java.enumerated;

public interface Competitor<T extends Competitor<T>> {
  Outcome compete(T competitor);
} ///:~
