package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        calc(input);
    }

    public static void calc(Scanner input) {
        System.out.println("Enter expression (type 'Y' to exit):");
        String in = input.nextLine();

        if (in.equalsIgnoreCase("Y")) {
            System.out.println("Successfully exited");
            return;
        }

        // Preprocess: remove spaces and add spaces around operators
        in = normalizeExpression(in);

        String[] parts = in.split(" ");
        if (parts.length != 3) {
            System.out.println("Error, Invalid Input");
            calc(input); // recursive call to try again
            return;
        }

        try {
            double num1 = Double.parseDouble(parts[0]);
            String op = parts[1];
            double num2 = Double.parseDouble(parts[2]);
            double result = calculate(num1, op, num2);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        calc(input);
    }
    public static String normalizeExpression(String input) {
        input = input.replaceAll("\\s+", "");         // remove all spaces
        return input.replaceAll("([+\\-*/])", " $1 "); // add spaces around operators
    }

    public static double calculate(double a, String op, double b) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/":
                if (b == 0) throw new ArithmeticException("Division by zero!");
                return a / b;
            default: throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }
}
