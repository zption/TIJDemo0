//: interfaces/filters/Waveform.java
package com.zping.lib_thinking_in_java.t09_interfaces.filters;

public class Waveform {
  private static long counter;
  private final long id = counter++;
  public String toString() { return "Waveform " + id; }
} ///:~
