// Day 3 Progress

// To Do Manager 3


/*
## Problem Statement Todo Manager is an application, which can Manage our 
Tasks and keep track of our Tasks.
## User Stories:-
1. As a user I should be able to add the task into an array
2. As a user I should be able to update the task in the array
3. As a user I should be able to delete the task in the array
4. As a user I should be able to search a task from an array
5. As a user I should be able to assignee the task to an user. 
## Instructions:- 
1. Please refactor the code created in sprint 2.
2. Please create a task pojo.
3. The task object should have 
	a. TaskId(number auto generated) 
	b. TaskTitle(String entered by the user) 
	c. TaskText( String entered by the user) 
	d. assignedTo(String entered by the user) 
4. Please use arrays to store the tasks objects.
5. All the CRUD operations should happen in a dao class. Main should contain only menu.
6. The application can be exited only if user enters 0 to exit. Else user should see the 
menu again and again.
 
*/
package Progress_Java_RA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Todo_Manager_3 {

    private static Scanner sc = new Scanner(System.in);
    private static TaskDao taskDao = new TaskDao();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nTodo Manager Application");
            System.out.println("1. Add Task");
            System.out.println("2. Update Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Search Task");
            System.out.println("5. List All Tasks");
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
                case 5:
                    listAllTasks();
                    break;
                case 0:
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("Invalid choice. Enter again!");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task title: ");
        String title = sc.nextLine();
        System.out.print("Enter task description: ");
        String text = sc.nextLine();
        System.out.print("Enter assigned to: ");
        String assignedTo = sc.nextLine();
        Task newTask = new Task(title, text, assignedTo);
        taskDao.addTask(newTask);
        System.out.println("Task added successfully.");
    }

    private static void updateTask() {
        System.out.print("Enter the task ID to update: ");
        int taskId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new task title: ");
        String title = sc.nextLine();
        System.out.print("Enter new task text: ");
        String text = sc.nextLine();
        System.out.print("Enter new assigned to: ");
        String assignedTo = sc.nextLine();
        taskDao.updateTask(taskId, title, text, assignedTo);
        System.out.println("Task updated.");
    }

    private static void deleteTask() {
        System.out.print("Enter the task ID to delete: ");
        int taskId = sc.nextInt();
        sc.nextLine();
        taskDao.deleteTask(taskId);
        System.out.println("Task deleted successfully.");
    }

    private static void searchTask() {
        System.out.print("Enter keyword to search tasks: ");
        String keyword = sc.nextLine();
        List<Task> foundTasks = taskDao.searchTask(keyword);
        if (foundTasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            foundTasks.forEach(System.out::println);
        }
    }

    private static void listAllTasks() {
        List<Task> allTasks = taskDao.getAllTasks();
        if (allTasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            allTasks.forEach(System.out::println);
        }
    }

    // Task POJO
    static class Task {
        private static int idCounter = 0;
        private int taskId;
        private String taskTitle;
        private String taskText;
        private String assignedTo;

        public Task(String taskTitle, String taskText, String assignedTo) {
            this.taskId = ++idCounter; // Auto incrementing the task ID
            this.taskTitle = taskTitle;
            this.taskText = taskText;
            this.assignedTo = assignedTo;
        }

        @Override
        public String toString() {
            return "Task ID: " + taskId + ", Title: " + taskTitle + ", Text: " + taskText + ", Assigned To: " + assignedTo;
        }
    }

    // TaskDao class
    static class TaskDao {
        private List<Task> tasks = new ArrayList<>();

        public void addTask(Task task) {
            tasks.add(task);
        }

        public void updateTask(int taskId, String taskTitle, String taskText, String assignedTo) {
            for (Task task : tasks) {
                if (task.taskId == taskId) {
                    task.taskTitle = taskTitle;
                    task.taskText = taskText;
                    task.assignedTo = assignedTo;
                    return;
                }
            }
        }

        public void deleteTask(int taskId) {
            for (int i = 0; i < tasks.size(); i++) {
                if (tasks.get(i).taskId == taskId) {
                    tasks.remove(i);
                    break;
                }
            }
        }

        public List<Task> searchTask(String keyword) {
            List<Task> foundTasks = new ArrayList<>();
            for (Task task : tasks) {
                if (task.taskTitle.contains(keyword) || task.taskText.contains(keyword)) {
                    foundTasks.add(task);
                }
            }
            return foundTasks;
        }
        
        public List<Task> getAllTasks() {
            return new ArrayList<>(tasks);
        }
    }
}

