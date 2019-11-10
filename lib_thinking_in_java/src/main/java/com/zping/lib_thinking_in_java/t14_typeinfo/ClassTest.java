package com.zping.lib_thinking_in_java.t14_typeinfo;

public class ClassTest {

    /**
     * 1、Class.GetEnclosingClass
     * <doc>获取对应类的直接外部类Class对象</doc>
     * 2、Class.GetDeclaringClass
     * <doc>获取对应类的声明类Class对象</doc>
     * 3、两者的区别
     * <mPair>
     * GetEnclosingClass与GetDeclaringClass很相近
     * 两者的区别在于匿名内部类、getEnclosingClass对匿名内部类也有效
     */
    public static void main(String[] args) {
        Class<?> enclosingClass = InnerClass.class.getEnclosingClass();
        // com.zping.lib_thinking_in_java.t14_typeinfo.ClassTest
        System.out.println(enclosingClass.getName());

        Class<?> declaringClass = InnerClass.class.getDeclaringClass();
        // com.zping.lib_thinking_in_java.t14_typeinfo.ClassTest
        System.out.println(declaringClass.getName());

        //注意：GetEnclosingClass获取的是直接定义该类的外部类Class实例、这点和getDeclaringClass一致
        Class<?> enclosingClass1 = InnerClass.InnerInnerClass.class.getEnclosingClass();
        // com.zping.lib_thinking_in_java.t14_typeinfo.ClassTest$InnerClass
        System.out.println(enclosingClass1.getName());

        Class<?> declaringClass1 = InnerClass.InnerInnerClass.class.getDeclaringClass();
        // com.zping.lib_thinking_in_java.t14_typeinfo.ClassTest$InnerClass
        System.out.println(declaringClass1.getName());

        //针对匿名内部类的测试
        DifferentBetweenClassGetEnclosingClassAndDeclaringClass s = new DifferentBetweenClassGetEnclosingClassAndDeclaringClass();
        HelloService inst = s.getHelloService();
        inst.sayHello();
    }

    private class InnerClass {

        private class InnerInnerClass {

        }
    }


    public interface HelloService {
        void sayHello();
    }


    public static class DifferentBetweenClassGetEnclosingClassAndDeclaringClass {

        HelloService getHelloService() {
            //匿名内部类
            return new HelloService() {

                @Override
                public void sayHello() {
                    // DifferentBetweenClassGetEnclosingClassAndDeclaringClass
                    System.out.println(this.getClass().getEnclosingClass());
                    // null
                    System.out.println(this.getClass().getDeclaringClass());

                }
            };
        }
    }
}
