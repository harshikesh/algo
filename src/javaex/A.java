package javaex;

/**
 * Created by harshikesh.kumar on 12/09/16.
 */
public  class A {

       int a;
    void hello(){
    }
    static class B{
        void func(){
         //   System.out.println(a);
        }
    }
}

class C{
    A.B b = new A.B();
}
