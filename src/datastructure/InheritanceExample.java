package datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class Parent {
    Parent(int a, int b) {
        int c = a + b;
        System.out.println("Sum=" + c);
    }
    void display() {
        System.out.println("Return Statement");
    }
}
class Child extends Parent {
    Child(int a, int b) {
        super(a,b);
        int c = a - b;
        System.out.println("Difference=" + c);
    }
}
public class InheritanceExample {
    public static void main(String args[]) {
        System.out.println(Objects.equals("test", new String("test")));
    }
}