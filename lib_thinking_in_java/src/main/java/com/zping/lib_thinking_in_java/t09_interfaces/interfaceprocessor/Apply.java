//: interfaces/interfaceprocessor/Apply.java
package com.zping.lib_thinking_in_java.t09_interfaces.interfaceprocessor;
import static com.zping.lib_thinking_in_java.net.mindview.util.Print.*;

public class Apply {
  public static void process(Processor p, Object s) {
    print("Using Processor " + p.name());
    print(p.process(s));
  }
} ///:~
