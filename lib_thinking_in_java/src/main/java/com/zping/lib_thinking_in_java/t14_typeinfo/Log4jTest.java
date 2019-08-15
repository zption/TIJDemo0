package com.zping.lib_thinking_in_java.t14_typeinfo;

public class Log4jTest {
    class InnerClass {

    }

    public static void main(String[] args) {
        System.out.println("-----------内部类----------------");
        Class innr = InnerClass.class;
        // com.zping.lib_thinking_in_java.t14_typeinfo.Log4jTest.InnerClass
        System.out.println("getCanonicalName()：" + innr.getCanonicalName());
        // com.zping.lib_thinking_in_java.t14_typeinfo.Log4jTest$InnerClass
        System.out.println("getName()：" + innr.getName());
        // InnerClass
        System.out.println("getSimpleName()：" + innr.getSimpleName());
        try {
            // ClassNotFoundException: com.zping.lib_thinking_in_java.t14_typeinfo.Log4jTest.InnerClass
            Class<?> aClass = Class.forName(innr.getCanonicalName());// 失败
            Class<?> aClass1 = Class.forName(innr.getName());// 成功
            // ClassNotFoundException: InnerClass
            Class<?> aClass2 = Class.forName(innr.getSimpleName());// 失败
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("-----------匿名类----------------");
        Class anonymousClass = new Object() {
        }.getClass();
        // null
        System.out.println("getCanonicalName()：" + anonymousClass.getCanonicalName());
        // com.zping.lib_thinking_in_java.t14_typeinfo.Log4jTest$1
        System.out.println("getName()：" + anonymousClass.getName());
        // 空字符串
        System.out.println("getSimpleName()：" + anonymousClass.getSimpleName());
        try {
            // java.lang.NullPointerException
            Class<?> aClass = Class.forName(anonymousClass.getCanonicalName());// 失败
            Class<?> aClass1 = Class.forName(anonymousClass.getName());// 成功
            // // ClassNotFoundException:
            Class<?> aClass2 = Class.forName(anonymousClass.getSimpleName());// 失败
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        System.out.println("-----------数组类----------------");
        Class arrayClass = new Object[1].getClass();
        // java.lang.Object[]
        System.out.println("getCanonicalName()：" + arrayClass.getCanonicalName());
        // [Ljava.lang.Object;
        System.out.println("getName()：" + arrayClass.getName());
        // Object[]
        System.out.println("getSimpleName()：" + arrayClass.getSimpleName());
        try {
            // ClassNotFoundException: java/lang/Object[]
            Class<?> aClass = Class.forName(arrayClass.getCanonicalName());// 失败
            Class<?> aClass1 = Class.forName(arrayClass.getName());// 成功
            // ClassNotFoundException: Object[]
            Class<?> aClass2 = Class.forName(arrayClass.getSimpleName());// 失败
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
/*
-----------内部类----------------
getCanonicalName()：com.zping.lib_thinking_in_java.t14_typeinfo.Log4jTest.InnerClass
getName()：com.zping.lib_thinking_in_java.t14_typeinfo.Log4jTest$InnerClass
getSimpleName()：InnerClass
-----------匿名类----------------
getCanonicalName()：null
getName()：com.zping.lib_thinking_in_java.t14_typeinfo.Log4jTest$1
getSimpleName()：
-----------数组类----------------
getCanonicalName()：java.lang.Object[]
getName()：[Ljava.lang.Object;
getSimpleName()：Object[]
* */

