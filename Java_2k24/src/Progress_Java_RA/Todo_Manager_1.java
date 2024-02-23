// Day 1 Progress

/*
 
## Problem Statement
ToDo Manager is an application, which can Manage our Tasks and keep track of our Tasks. 
## User Stories:- 
1. As a user I should be able to print my name on the screen
2. As a user I should be able to list at least 5 tasks for the day. 
3. As a user I should be able to see all the tasks in increasing and decreasing order. 
4. As a user I should be able to see the repeated tasks.
## Instructions:- 
1. Please use simple system.out.println to print the name
2. Please use simple variables to store all tasks
3. Please use simple if else to arrange the task in an order
4. Please use if else to check the repeated tasks
  
*/
package Progress_Java_RA;

import java.util.Scanner;
public class Todo_Manager_1 {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter Name : ");
		String name = sc.nextLine();
        System.out.println("This ToDo Manager belongs to " + name);
        
        System.out.println("Enter number of tasks:");
        int numberOfTasks = sc.nextInt();
        sc.nextLine();
        String[] tasks = new String[numberOfTasks];
        for(int i = 0; i < numberOfTasks; i++) {
            System.out.println("Enter the " + (i + 1) + " task ");
            tasks[i] = sc.nextLine();
        }
        System.out.println("Your Tasks are : ");
        for(String task : tasks)
            System.out.println(task);
        
        System.out.println("Checking for repeated tasks? Enter Yes or No");
        String checkRepeats = sc.nextLine();
        if(checkRepeats.equalsIgnoreCase("yes")) {
        	boolean repeatedFound = false;
            for(int i = 0; i < tasks.length; i++) {
                for(int j = i + 1; j < tasks.length; j++) {
                    if(tasks[i].equals(tasks[j])) {
                        System.out.println("Repeated task : " + tasks[i]);
                        repeatedFound = true;
                        break;
                    }
                }
                if(repeatedFound)
                    break;
            }
            if(!repeatedFound)
                System.out.println("No repeated tasks");
        }
	}

}
