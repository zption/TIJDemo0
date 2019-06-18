//: annotations/database/Uniqueness.java
// Sample of nested annotations
package com.zping.lib_thinking_in_java.t20_annotations.database;

public @interface Uniqueness {
  Constraints constraints()
    default @Constraints(unique=true);
} ///:~
