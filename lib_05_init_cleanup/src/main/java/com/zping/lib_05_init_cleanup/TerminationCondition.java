package com.zping.lib_05_init_cleanup;//: initialization/TerminationCondition.java
// Using finalize() to detect an object that
// hasn't been properly cleaned up.

class Book {
    boolean checkedOut = false;

    Book(boolean checkOut) {
        checkedOut = checkOut;
    }

    void checkIn() {
        checkedOut = false;
    }


    protected void finalize() {
//        super.finalize();
        if (checkedOut) {
            System.out.println("Error: checked out");
        } else {
            System.out.println("checkedOut == false");
        }
        // Normally, you'll also do this:
        // super.finalize(); // Call the base-class version
    }
}

/**
 * 有一本书未被签入，要是没有finalize()来验证终结条件，将很难发现这种缺陷。
 */
public class TerminationCondition {
    public static void main(String[] args) {
        Book novel = new Book(true);
        // Proper cleanup:
        novel.checkIn();
        // Drop the reference, forget to clean up:
        new Book(true);
        // Force garbage collection & finalization:
        System.gc();
    }
} /* Output:
Error: checked out
*///:~
