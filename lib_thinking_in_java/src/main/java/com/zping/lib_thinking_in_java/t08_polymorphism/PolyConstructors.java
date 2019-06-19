package com.zping.lib_thinking_in_java.t08_polymorphism;//: polymorphism/PolyConstructors.java
// Constructors and polymorphism
// don't produce what you might expect.

import static com.zping.lib_thinking_in_java.net.mindview.util.Print.print;

class Glyph {
    void draw() {
        print("Glyph.draw()");
    }

    Glyph() {
        /* 111 */
        print("Glyph() before draw()");
        draw();
        print("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    /* 333 */
    RoundGlyph(int r) {
        radius = r;
        print("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    void draw() {
        /* 222 */
        print("RoundGlyph.draw(), radius = " + radius);
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
    }
} /* Output:
Glyph() before draw()
RoundGlyph.draw(), radius = 0
Glyph() after draw()
RoundGlyph.RoundGlyph(), radius = 5
*///:~
