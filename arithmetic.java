// Write a Java program that takes user input and processes it as a mathematical expression.
// https://beta.openai.com/playground/p/HMz9UixN2z7cTVyYhaMrc4rg

import java.util.Scanner;

public class MathExpression {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Prompt user for input
        System.out.println("Please enter a mathematical expression:");
        String expression = in.nextLine();
        // Split expression into an array of strings
        String[] arr = expression.split(" ");
        // Initialize variables
        double result = 0;
        int i = 0;
        double num1 = 0;
        double num2 = 0;
        String operator = "";
        // Iterate through array of strings
        while (i < arr.length) {
            // Get first number and operator
            if (i == 0) {
                num1 = Double.parseDouble(arr[i]);
                operator = arr[i + 1];
            }
            // Get second number
            else if (i == 2) {
                num2 = Double.parseDouble(arr[i]);
            }
            // Perform calculation
            if (operator.equals("+")) {
                result = num1 + num2;
            } else if (operator.equals("-")) {
                result = num1 - num2;
            } else if (operator.equals("*")) {
                result = num1 * num2;
            } else if (operator.equals("/")) {
                result  = num1 / num2;
            }
            i++;
        }
        // Print result
        System.out.println("Result: " + result);
    }
}
