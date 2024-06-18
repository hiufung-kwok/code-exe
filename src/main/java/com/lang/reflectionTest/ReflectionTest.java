package com.lang.reflectionTest;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person {
    private String name;

    private void printName() {
        System.out.println("Name: " + name);
    }
}

public class ReflectionTest {
    public static void main(String[] args) {
        try {
            // Create an instance of Person
            Person person = new Person();

            // Get the Class object associated with Person
            Class<?> personClass = person.getClass();

            // Access and modify the private field 'name'
            Field nameField = personClass.getDeclaredField("name");
            nameField.setAccessible(true); // Suppress access checks
            nameField.set(person, "John Doe");

            // Access and invoke the private method 'printName'
            Method printNameMethod = personClass.getDeclaredMethod("printName");
            printNameMethod.setAccessible(true); // Suppress access checks
            printNameMethod.invoke(person);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
