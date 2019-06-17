//: annotations/Testable.java
package com.zping.lib_thinking_in_java.annotations;

import com.zping.lib_thinking_in_java.net.mindview.atunit.Test;

public class Testable {
    public void execute() {
        System.out.println("Executing..");
    }

    @Test
    void testExecute() {
        execute();
    }
} ///:~
