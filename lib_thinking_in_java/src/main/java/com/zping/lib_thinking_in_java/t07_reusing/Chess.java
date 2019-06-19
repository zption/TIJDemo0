package com.zping.lib_thinking_in_java.t07_reusing;//: reusing/Chess.java
// Inheritance, constructors and arguments.

import static com.zping.lib_thinking_in_java.net.mindview.util.Print.print;

class Game {
    Game(int i) {
        print("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        print("BoardGame constructor");
    }
}

public class Chess extends BoardGame {
    Chess() {
        super(11);
        print("Chess constructor");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
} /* Output:
Game constructor
BoardGame constructor
Chess constructor
*///:~
