package Progress_4_Java;

import java.util.*;

public class Main {
    private static UserDAO userDAO = new UserDAOImpl();
    private static TaskDAO taskDAO = new TaskDAOImpl();
    private static Scanner scanner = new Scanner(System.in);
    private static User loggedInUser = null;

    public static void main(String[] args) {
        userDAO.addUser(new Client("admin", "admin"));

        while (true) {
            if (loggedInUser == null) {
                System.out.println("\n1. Register");
                System.out.println("2. Login");
                System.out.println("3. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        registerUser();
                        break;
                    case 2:
                        loginUser();
                        break;
                    case 3:
                    	System.out.println("Exiting");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } else {
            	System.out.println("\n1. Add Task");
                System.out.println("2. Update Task");
                System.out.println("3. Delete Task");
                System.out.println("4. Search Task");
                System.out.println("5. View My Profile");
                System.out.println("6. Update My Profile");
                System.out.println("7. Delete My Profile");
                System.out.println("8. Logout");
                System.out.print("Enter choice: ");
                int taskChoice = scanner.nextInt();
                scanner.nextLine();

                switch (taskChoice) {
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
                    viewProfile();
                    break;
                case 6:
                    updateProfile();
                    break;
                case 7:
                    deleteProfile();
                    break;
                case 8:
                    logout();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            }
        }
    }
    
    private static void viewProfile() {
        System.out.println("User Profile:");
        System.out.println("Username: " + loggedInUser.getUsername());
    }

    private static void updateProfile() {
        System.out.println("What would you like to update?");
        System.out.println("1. Username");
        System.out.println("2. Password");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                updateUsername();
                break;
            case 2:
                updatePassword();
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private static void updateUsername() {
        System.out.print("Enter new username: ");
        String newUsername = scanner.nextLine();
        // Check if the new user name already exists
        if (userDAO.getUser(newUsername) != null) {
            System.out.println("This username is already taken. Please choose a different one.");
            return;
        }

        // String oldUsername = loggedInUser.getUsername();
        loggedInUser.setUsername(newUsername);
        userDAO.updateUser(loggedInUser);
        System.out.println("Username updated successfully. Please log in again with your new username.");
        // Force re-login with new credentials
        logout();
    }

    private static void updatePassword() {
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        loggedInUser.setPassword(newPassword);
        userDAO.updateUser(loggedInUser);
        System.out.println("Password updated successfully.");
    }


    private static void deleteProfile() {
        userDAO.deleteUser(loggedInUser.getUsername());
        loggedInUser = null;
        System.out.println("Your profile has been deleted.");
    }

    private static void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = userDAO.getUser(username);
        if (user == null) {
            userDAO.addUser(new Client(username, password));
            System.out.println("Registration successful.");
        } else {
            System.out.println("Username already exists. Try logging in.");
        }
    }

    private static void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = userDAO.login(username, password);
        if (user != null) {
            loggedInUser = user;
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid credentials or user does not exist.");
        }
    }

    private static void addTask() {
        System.out.print("Enter task ID: ");
        String taskId = scanner.nextLine();
        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();

        taskDAO.addTask(new Tasks(taskId, taskName, loggedInUser.getUsername()));
        System.out.println("Task added successfully.");
    }

    private static void updateTask() {
        System.out.print("Enter task ID: ");
        String taskId = scanner.nextLine();
        Tasks task = taskDAO.getTask(taskId);

        if (task != null) {
            System.out.print("Enter new task name: ");
            String newTaskName = scanner.nextLine();
            task.setTaskName(newTaskName);
            taskDAO.updateTask(task);
            System.out.println("Task updated successfully.");
        } else {
            System.out.println("Task not found.");
        }
    }

    private static void deleteTask() {
        System.out.print("Enter task ID: ");
        String taskId = scanner.nextLine();
        taskDAO.deleteTask(taskId);
        System.out.println("Task deleted successfully.");
    }

    private static void searchTask() {
        System.out.print("Enter keyword to search tasks: ");
        String keyword = scanner.nextLine();
        taskDAO.searchTasks(keyword);
    }

    private static void logout() {
        loggedInUser = null;
        System.out.println("Logged out successfully.");
    }
}
