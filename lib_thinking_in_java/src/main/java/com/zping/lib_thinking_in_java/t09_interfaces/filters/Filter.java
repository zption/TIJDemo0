//: interfaces/filters/Filter.java
package com.zping.lib_thinking_in_java.t09_interfaces.filters;

public class Filter {
  public String name() {
    return getClass().getSimpleName();
  }
  public Waveform process(Waveform input) { return input; }
} ///:~
