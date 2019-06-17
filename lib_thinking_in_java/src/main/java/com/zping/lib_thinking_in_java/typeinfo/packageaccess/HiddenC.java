//: typeinfo/packageaccess/HiddenC.java
package com.zping.lib_thinking_in_java.typeinfo.packageaccess;

import com.zping.lib_thinking_in_java.typeinfo.interfacea.A;

import static com.zping.lib_thinking_in_java.net.mindview.util.Print.print;

class C implements A {
  public void f() { print("public C.f()"); }
  public void g() { print("public C.g()"); }
  void u() { print("package C.u()"); }
  protected void v() { print("protected C.v()"); }
  private void w() { print("private C.w()"); }
}

public class HiddenC {
  public static A makeA() { return new C(); }
} ///:~
