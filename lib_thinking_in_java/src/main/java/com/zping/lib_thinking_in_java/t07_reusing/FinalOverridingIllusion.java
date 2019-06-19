package com.zping.lib_thinking_in_java.t07_reusing;//: reusing/FinalOverridingIllusion.java
// It only looks like you can override
// a private or private final method.

import static com.zping.lib_thinking_in_java.net.mindview.util.Print.print;

class WithFinals {
    // Identical to "private" alone:
    private final void f() {
        print("WithFinals.f()");
    }

    // Also automatically "final":
    private void g() {
        print("WithFinals.gFunc()");
    }
}

class OverridingPrivate extends WithFinals {
    private final void f() {
        print("OverridingPrivate.f()");
    }

    private void g() {
        print("OverridingPrivate.gFunc()");
    }
}

class OverridingPrivate2 extends OverridingPrivate {
    public final void f() {
        print("OverridingPrivate2.f()");
    }

    public void g() {
        print("OverridingPrivate2.gFunc()");
    }
}

public class FinalOverridingIllusion {
    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();
        // You can upcast:
        OverridingPrivate op = op2;
        // But you can't call the methods:
        //! op.f();
        //! op.gFunc();
        // Same here:
        WithFinals wf = op2;
        //! wf.f();
        //! wf.gFunc();
    }
} /* Output:
OverridingPrivate2.f()
OverridingPrivate2.gFunc()
*///:~
