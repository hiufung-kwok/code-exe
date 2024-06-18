package org.example;

class SuperClass {
    static void display() {
        System.out.println("Static method in SuperClass");
    }
}

class SubClass extends SuperClass {
    static void display() {
        System.out.println("Static method in SubClass");
    }
}

public class Main {
    public static void main(String[] args) {
        SuperClass superClass = new SuperClass();
        SuperClass subClass = new SubClass();

        superClass.display(); // Output: Static method in SuperClass
        subClass.display();   // Output: Static method in SuperClass
        SubClass.display();   // Output: Static method in SubClass
    }
}