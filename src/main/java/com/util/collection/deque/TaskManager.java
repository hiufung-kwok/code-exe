package com.util.collection.deque;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Title:
 * Java Deque Implementation and API Usage
 *
 * Description:
 * In this exercise, you will demonstrate your understanding of the Deque interface and its common implementations in Java.
 * You will create a program that performs various operations on a Deque to simulate a simplified version of a task manager.
 * Your task manager will support adding tasks, processing tasks, and viewing tasks in a specific order.
 */
public class TaskManager {

    private final ArrayDeque<String> deque;

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Sample tasks
        manager.addTask("Task 1");
        manager.addTask("Task 2");
        manager.addTask("Task 3");

        System.out.println("Next task to process: " + manager.viewNextTask());
        System.out.println("Last task added: " + manager.viewLastTask());

        manager.processNextTask();
        System.out.println("Next task to process: " + manager.viewNextTask());
    }

    public TaskManager() {
        this.deque = new ArrayDeque<String>();
    }

    // Your implementation goes here
    //Add a task: Add a new task to the end of the deque.
    public void addTask(String task) {
        deque.add(task);
    }


    //View the next task: Return the task at the front of the deque without removing it.
    public String viewNextTask() {
        return deque.peek();
    }

    //View the last task: Return the task at the end of the deque without removing it.
    public String viewLastTask() {
        return deque.peekLast();
    }

    //Process the next task: Remove and return the task at the front of the deque.
    public String processNextTask() {
        return deque.getFirst();
    }

    //Prioritize a task: Move a specified task to the front of the deque.
    public void prioritizeTask(String task) throws NoSuchElementException {
        if (deque.remove(task)) {
            deque.addFirst(task);
        } else {
            throw new NoSuchElementException(
                    "Element: " + task + " is absent from the deque");
        }
    }


    //Retrieve all tasks in reverse order: Return a list of all tasks in the deque in reverse order.
    public List<String> getAllTasksInReverseOrder() {
        return new ArrayList<>(deque.reversed());

    }

    //Check if a specific task exists: Return true if the specified task is present in the deque, false otherwise.
    public boolean taskExists(String task) {
        return deque.contains(task);
    }


    //Remove a specific task: Remove the first occurrence of the specified task from the deque.
    public boolean removeTask(String task) {
        return deque.remove(task);
    }

    //Clear all tasks: Remove all tasks from the deque.
    public void clearAllTasks() {
        deque.clear();
    }
}
