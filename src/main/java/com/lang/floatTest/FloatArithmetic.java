package com.lang.floatTest;

import java.text.DecimalFormat;

/**
 * Problem Statement
 * Implement a method to perform basic arithmetic operations (addition, subtraction, multiplication, and division),
 * on floating-point numbers using the Java Float class.
 *
 * Functional Requirements
 * Create a class FloatArithmetic with a method performOperation that takes three arguments:
 * A float value a.
 * A float value b.
 * A String value operation which can be "add", "subtract", "multiply", or "divide".
 * The method should return the result of the specified arithmetic operation on the two float values.
 * Handle the case of division by zero by returning Float.POSITIVE_INFINITY or Float.NEGATIVE_INFINITY as appropriate.
 * If the operation string is not one of the specified operations, throw an IllegalArgumentException.
 *
 * Additional req (1)
 *  - Precision Handling: Ensure the method handles precision up to two decimal places for all arithmetic operations.
 *  - Negative Number Handling: Ensure that the method correctly handles cases where one or both input values are negative.
 *  - Overflow Handling: Ensure that the method checks for and handles arithmetic overflow, returning Float.MAX_VALUE or Float.MIN_VALUE when appropriate.
 *  - Input Validation: Ensure the method validates that the inputs a and b are not Float.NaN (Not a Number). If either input is Float.NaN, the method should throw an IllegalArgumentException.
 *  - Result Formatting: Ensure that the method returns the result as a String formatted to two decimal places instead of a float.
 *
 *  ### Additional Functional Requirements (2)
 * 6. **Logging**: Implement logging to record each operation and its result.
 * 7. **Null Operation Handling**: Ensure the method checks if the `operation` parameter is `null` and throws an `IllegalArgumentException` if it is.
 * 8. **Operation Case Insensitivity**: Ensure that the `operation` parameter is case-insensitive, meaning "ADD", "add", "Add", etc., should all be valid.
 * 9. **Zero Check for Addition/Subtraction**: If `a` or `b` is zero, return the other number without performing the arithmetic operation.
 * 10. **Configurable Precision**: Add an optional parameter to the method to allow configurable precision for the result, defaulting to two decimal places if not provided.
 */
public class FloatArithmetic {

    public static void main(String[] args) {
        // Test dataset
        float a = 5.5f;
        float b = 2.0f;

        // Example usage and expected output
        System.out.println(performOperation(a, b, "add"));      // Expected: 7.5
        System.out.println(performOperation(a, b, "subtract")); // Expected: 3.5
        System.out.println(performOperation(a, b, "multiply")); // Expected: 11.0
        System.out.println(performOperation(a, b, "divide"));   // Expected: 2.75
        System.out.println(performOperation(a, 0, "divide"));   // Expected: Return a, the calculation should be ignored.
        try {
            System.out.println(performOperation(a, b, "xxx"));   // Expected: Exception to be thrown.
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(performOperation(21.36f, 4, "divide"));   // Expected: 5.34
        System.out.println(performOperation(-5, 3, "divide"));   // Expected: 1.67
        System.out.println(performOperation(5, -3, "divide"));   // Expected: 1.67

        try {
            System.out.println(performOperation(Float.NaN, b, "divide"));   // Expected: Exception to be thrown.
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            System.out.println(performOperation(a, b, null));   // Expected: Exception to be thrown.
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        // Case-insensitive
        System.out.println(performOperation(a, b, "Add"));      // Expected: 7.5
        System.out.println(performOperation(a, b, "Subtract")); // Expected: 3.5
        System.out.println(performOperation(a, b, "Multiply")); // Expected: 11.0
        System.out.println(performOperation(a, b, "Divide"));   // Expected: 2.75


    }


    /**
     * Perform the specified arithmetic operation on two float numbers.
     *
     * @param a         the first float number
     * @param b         the second float number
     * @param operation the operation to perform ("add", "subtract", "multiply", "divide")
     * @return the result of the arithmetic operation
     * @throws IllegalArgumentException if the operation is not valid
     */
    public static String performOperation(float a, float b, String operation) {
        return performOperation(a, b, operation, 2);
    }

        /**
         * Perform the specified arithmetic operation on two float numbers.
         *
         * @param a         the first float number
         * @param b         the second float number
         * @param operation the operation to perform ("add", "subtract", "multiply", "divide")
         * @param precision the number of digit to print after decimal point
         * @return the result of the arithmetic operation
         * @throws IllegalArgumentException if the operation is not valid
         */
    public static String performOperation(float a, float b, String operation, int precision) {
        // To-do: Implement the method logic based on the operation
        // Input validation
        if (Float.isNaN(a) || Float.isNaN(b)) {
            throw new IllegalArgumentException("Invalid input: " + a + " " + b);
        } else if (operation == null) {
            throw new IllegalArgumentException("Null operation");
        }

        DecimalFormat formatter = new DecimalFormat();
        formatter.setMaximumFractionDigits(precision);
        if (a == 0) {
            return formatter.format(a);
        } else if (b == 0) {
            return formatter.format(b);
        }

        // Computation
        float result;
        switch (operation.toLowerCase()) {
            case "add" -> result = a + b;
            case "subtract" -> result = a - b;
            case "multiply" -> result = a * b;
            case "divide" -> result =a / b;
            default -> throw new IllegalArgumentException("Unsupported operation: " + operation);
        };

        if (Float.POSITIVE_INFINITY == result) {
            return "Float Max value";
        } else if (Float.NEGATIVE_INFINITY == result) {
            return "Float Min value";
        } else {
            return formatter.format(result);
        }

    }
}
