package com.zping.lib_thinking_in_java.access;//: access/ChocolateChip.java
// Can't use package-access member from another package.
import com.zping.lib_thinking_in_java.access.*;
import com.zping.lib_thinking_in_java.access.cookie2.Cookie;

public class ChocolateChip extends Cookie {
  public ChocolateChip() {
   System.out.println("ChocolateChip constructor");
  }
  public void chomp() {
    //! bite(); // Can't access bite
  }
  public static void main(String[] args) {
    ChocolateChip x = new ChocolateChip();
    x.chomp();
  }
} /* Output:
Cookie constructor
ChocolateChip constructor
*///:~
