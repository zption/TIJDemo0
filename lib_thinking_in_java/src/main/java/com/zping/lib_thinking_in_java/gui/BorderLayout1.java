package com.zping.lib_thinking_in_java.gui;//: gui/BorderLayout1.java
// Demonstrates BorderLayout.
import javax.swing.*;
import java.awt.*;
import static com.zping.lib_thinking_in_java.net.mindview.util.SwingConsole.*;

public class BorderLayout1 extends JFrame {
  public BorderLayout1() {
    add(BorderLayout.NORTH, new JButton("North"));
    add(BorderLayout.SOUTH, new JButton("South"));
    add(BorderLayout.EAST, new JButton("East"));
    add(BorderLayout.WEST, new JButton("West"));
    add(BorderLayout.CENTER, new JButton("Center"));
  }
  public static void main(String[] args) {
    run(new BorderLayout1(), 300, 250);
  }
} ///:~
