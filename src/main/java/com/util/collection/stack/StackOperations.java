package com.util.collection.stack;

import java.util.Stack;

/**
 *
 Title: Leveraging Java Stack API for Custom Operations

 Description: In this exercise, you will leverage an existing instance of the Java Stack class to perform various operations.
 This will test your ability to use the Stack API effectively and creatively.
 You will not extend the Stack class but instead, use an instance of it to complete specific tasks.
 */
public class StackOperations {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Original stack: " + stack);
        reverseStack(stack);
        System.out.println("Reversed stack: " + stack);

        stack.push(40);
        stack.push(50);
        System.out.println("Stack after pushing 40 and 50: " + stack);
        removeBottomElement(stack);
        System.out.println("Stack after removing bottom element: " + stack);

        System.out.println("Middle element: " + findMiddleElement(stack));
    }

    //reverseStack(Stack<T> stack): Implement a method that reverses the elements of the given stack.
    //
    public static <T> void reverseStack(Stack<T> stack) {
        if (stack.isEmpty()) {
            return;
        }

        // Do a recursive calling, until you reach to the end of the stack.
        T bottom = popBottom(stack);
        reverseStack(stack);
        stack.push(bottom);
    }

    private static <T> T popBottom(Stack<T> stack) {
        T top = stack.pop();
        if (stack.isEmpty()) {
            return top;
        } else {
            T bottom = popBottom(stack);
            stack.push(top);
            return bottom;
        }
    }

    //removeBottomElement(Stack<T> stack):
    // Implement a method that removes the bottom element from the stack without using any additional data structures.
    //
    public static <T> void removeBottomElement(Stack<T> stack) {
        if (stack.isEmpty()) {
            return;
        }

        T top = stack.pop();
//        System.out.println("Popping: " + top);
        if (!stack.isEmpty()) {
            removeBottomElement(stack);
            stack.push(top);
//            System.out.println("Pushed: " + top) ;
        } else {
            // This is the where the last element fall, no-ops.
        }

    }
    //findMiddleElement(Stack<T> stack):
    // Implement a method that finds and returns the middle element of the stack.
    // If the stack has an even number of elements, return the lower middle element.
    //
    public static <T> T findMiddleElement(Stack<T> stack) {
        // Keep track of size.
        Stack<T> tempStack = new Stack<>();
        int size = stack.size();
        int midIndex = size / 2;
        // Get the middle.

        for (int i=0 ; i< midIndex ; i++) {
            tempStack.push(stack.pop());
        }

        T middleElement = stack.peek();

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return middleElement;
    }


}
