package Progress_7_Java_Part_3;

import java.util.*;

public class ExceptionHandling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        System.out.println("Enter the number of elements: ");
        while (true) {
            try {
                n = sc.nextInt();
                if (n <= 0) {
                    System.out.println("Please enter a positive integer.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter integers only.");
                sc.next();
            }
        }

        int[] arr = new int[n];

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter element " + (i + 1) + ": ");
            while (true) {
                try {
                    arr[i] = sc.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter integers only.");
                    sc.next();
                }
            }
        }

        for (int j : arr) {
            sum += j;
        }
        sc.close();
        System.out.println("Sum: " + sum);
    }
}
