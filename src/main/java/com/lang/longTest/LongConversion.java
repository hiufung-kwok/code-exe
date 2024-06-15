package com.lang.longTest;

/**
 * Exercise 1:
 * Problem Statement:
 * Write a method that takes a String representation of a number and returns its Long value. The method should handle both positive and negative numbers.
 *
 * Functional Requirements:
 *
 * The method should accept a single String parameter.
 * The method should return a Long value.
 * The method should correctly handle NumberFormatException for invalid input strings.
 * The method should handle both positive and negative numbers.
 * The method should trim any leading or trailing whitespace from the input string.
 *
 * ### New Functional Requirements for Exercise 1:
 *
 * 1. The method should handle input strings in different numeral bases (e.g., binary, octal, hexadecimal) if specified by an additional parameter indicating the base.
 * 2. The method should return `null` if the input string is `null` or empty.
 * 3. The method should throw an `IllegalArgumentException` if the input string is not a valid number.
 * 4. The method should handle and correctly parse input strings with leading and trailing whitespace.
 * 5. The method should handle and correctly parse input strings with optional `+` and `-` signs.
 */
public class LongConversion {

    public static void main(String[] args) {
        // Test case
        String numberStr = "  -1234567890  ";
        Long result = convertStringToLong(numberStr);
        System.out.println(result); // Expected output: -1234567890
        try {
            System.out.println(convertStringToLong("trash string")); // Expected output: Exception
        } catch (IllegalArgumentException ex) {
            System.out.println("Expected exception");
        }
        System.out.println(convertStringToLong("+1234")); // Expected output: Exception

    }

    public static Long convertStringToLong(String numberStr) {
        // TODO: Trim the input string, handle NumberFormatException, and convert the string to a Long
        // Validation
        if (numberStr == null || numberStr.isEmpty()) {
            return null;
        }


        // Trim str
        final String trimmedStr = numberStr.trim();
        Long result = null;

        // Parse and handle the exception.
        try {
            result = Long.parseLong(trimmedStr);

        } catch (NumberFormatException ex) {
            System.out.println("Invalid String to parse: " + trimmedStr);
            throw new IllegalArgumentException();
        }

        // If ok, then return.
        return result;


    }
}
