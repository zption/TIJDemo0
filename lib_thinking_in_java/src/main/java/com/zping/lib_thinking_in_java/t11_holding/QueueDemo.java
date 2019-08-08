package com.zping.lib_thinking_in_java.t11_holding;//: holding/QueueDemo.java
// Upcasting to a Queue from a LinkedList.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueDemo {
    public static void printQ(Queue queue) {
        while (queue.peek() != null)
            System.out.print(queue.remove() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            int e = rand.nextInt(i + 10);
            System.out.println("in:" + i + "  " + e);
            queue.offer(e);
        }
        printQ(queue);
        Queue<Character> qc = new LinkedList<Character>();
        for (char c : "Brontosaurus".toCharArray()) {
            qc.offer(c);
        }
        printQ(qc);
    }
} /* Output:
in:0  8
in:1  1
in:2  1
in:3  1
in:4  5
in:5  14
in:6  3
in:7  1
in:8  0
in:9  1
8 1 1 1 5 14 3 1 0 1
B r o n t o s a u r u s
*///:~
