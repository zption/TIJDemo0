//: interfaces/filters/HighPass.java
package com.zping.lib_thinking_in_java.t09_interfaces.filters;

public class HighPass extends Filter {
  double cutoff;
  public HighPass(double cutoff) { this.cutoff = cutoff; }
  public Waveform process(Waveform input) { return input; }
} ///:~
