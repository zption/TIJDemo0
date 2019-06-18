//: annotations/ExtractInterface.java
// APT-based annotation processing.
package com.zping.lib_thinking_in_java.t20_annotations;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {
  public String value();
} ///:~
