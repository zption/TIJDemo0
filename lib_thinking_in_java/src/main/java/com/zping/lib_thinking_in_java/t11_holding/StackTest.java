package com.zping.lib_thinking_in_java.t11_holding;//: holding/StackTest.java

import com.zping.lib_thinking_in_java.net.mindview.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        for (String s : "My dog has fleas".split(" ")) {
            stack.push(s);
            System.out.println(s);
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
} /* Output:
my dog has fleas
fleas has dog My
*///:~
