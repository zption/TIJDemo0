//: annotations/database/SQLInteger.java
package com.zping.lib_thinking_in_java.t20_annotations.database;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {
  String name() default "";
  Constraints constraints() default @Constraints;
} ///:~
