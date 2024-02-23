// Day 2 progress

// ToDo Manager 2

/*

# Todo Manager Sprint 2 
## Problem Statement Todo Manager is an application, which can manage our Tasks 
and keep track of our Tasks.
## User Stories:-
1. As a user I should be able to add the task into an array
2. As a user I should be able to update the task in the array 
3. As a user I should be able to delete the task in the array 
4. As a user I should be able to search a task from an array
## Instructions:-
1. Please refactor the code created in sprint 1.
2. Please use arrays to store the tasks. 
3. The application can be exited only if user enters 0 to exit. Else, user 
should see the menu again and again.
 
*/
package Progress_Java_RA;

import java.util.Scanner;

public class Todo_Manager_2 {
    private static Scanner sc = new Scanner(System.in);
    private static String[] tasks = new String[0];

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n Upgraded Todo Manager");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Search Task");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    updateTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    searchTask();
                    break;
                case 0:
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("Invalid choice, try entering again!");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter a new task: ");
        String newTask = sc.nextLine();
        tasks = java.util.Arrays.copyOf(tasks, tasks.length + 1);
        tasks[tasks.length - 1] = newTask;
        System.out.println("Task added successfully.");
    }

    private static void updateTask() {
        listTasks();
        System.out.print("Enter the task number to update: ");
        int taskNumber = sc.nextInt() - 1;
        sc.nextLine();
        if (taskNumber >= 0 && taskNumber < tasks.length) {
            System.out.print("Enter the new task description: ");
            tasks[taskNumber] = sc.nextLine();
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    private static void deleteTask() {
        listTasks();
        System.out.print("Enter the task number to delete: ");
        int taskNumber = sc.nextInt() - 1;
        sc.nextLine();
        if (taskNumber >= 0 && taskNumber < tasks.length) {
            String[] newTasks = new String[tasks.length - 1];
            for (int i = 0, j = 0; i < tasks.length; i++) {
                if (i != taskNumber) {
                    newTasks[j++] = tasks[i];
                }
            }
            tasks = newTasks;
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    private static void searchTask() {
        System.out.print("Enter a keyword to search for a task: ");
        String keyword = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].contains(keyword)) {
                System.out.println((i + 1) + ". " + tasks[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No such tasks found. ");
        }
    }

    private static void listTasks() {
        if (tasks.length == 0) {
            System.out.println("No tasks in the list.");
            return;
        }
        System.out.println("Current tasks : ");
        for (int i = 0; i < tasks.length; i++)
            System.out.println((i + 1) + ". " + tasks[i]);
    }
}
