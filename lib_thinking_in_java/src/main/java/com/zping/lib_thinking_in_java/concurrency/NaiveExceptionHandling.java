package com.zping.lib_thinking_in_java.concurrency;//: concurrency/NaiveExceptionHandling.java
// {ThrowsException}
import com.zping.lib_thinking_in_java.concurrency.ExceptionThread;

import java.util.concurrent.*;

public class NaiveExceptionHandling {
  public static void main(String[] args) {
    try {
      ExecutorService exec =
        Executors.newCachedThreadPool();
      exec.execute(new ExceptionThread());
    } catch(RuntimeException ue) {
      // This statement will NOT execute!
      System.out.println("Exception has been handled!");
    }
  }
} ///:~
