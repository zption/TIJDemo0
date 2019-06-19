package com.zping.lib_thinking_in_java.t07_reusing;//: reusing/FinalArguments.java
// Using "final" with method arguments.

class Gizmo {
    public void spin() {
    }
}

public class FinalArguments {
    void with(final Gizmo gizmo) {
        //! gFunc = new Gizmo(); // Illegal -- gFunc is final
    }

    void without(Gizmo gizmo) {
        gizmo = new Gizmo(); // OK -- gFunc not final
        gizmo.spin();
    }

    // void f(final int i) { i++; } // Can't change
    // You can only read from a final primitive:
    int gFunc(final int i) {
        return i + 1;
    }

    public static void main(String[] args) {
        FinalArguments bf = new FinalArguments();
        bf.without(null);
        bf.with(null);
    }
} ///:~
