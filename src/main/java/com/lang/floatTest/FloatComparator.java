package com.lang.floatTest;

/**
 * Problem Statement
 * Write a method that compares two floating-point numbers for equality using Float.compare().
 * The method should take two Float objects and return true if they are equal and false otherwise.
 * Additionally, the method should handle null values gracefully, considering null as not equal to any other value including another null.
 *
 * Functional Requirements
 * The method should accept two Float objects as parameters.
 * It should use the Float.compare() method to compare the two floats.
 * If either of the Float objects is null, the method should return false.
 * The method should return true only if both Float objects are non-null and equal.
 * The method should handle edge cases such as Float.NaN, Float.POSITIVE_INFINITY, and Float.NEGATIVE_INFINITY correctly.
 *
 * ### Additional Functional Requirements
 *
 * 1. The method should handle the comparison of `Float.NaN` values correctly, returning `true` if both floats are `NaN`.
 * 2. The method should handle `Float.POSITIVE_INFINITY` and `Float.NEGATIVE_INFINITY` correctly, ensuring they are compared accurately.
 * 3. If both `Float` objects are `null`, the method should return `true`.
 * 4. The method should be efficient, with a time complexity of O(1).
 * 5. Add logging statements to indicate when the method is handling `NaN`, infinities, or `null` values.
 */
public class FloatComparator {

    public static void main(String[] args) {
        Float f1 = 1.23f;
        Float f2 = 1.23f;
        Float f3 = 2.34f;
        Float f4 = null;

        System.out.println("Comparing f1 and f2: " + compareFloats(f1, f2)); // Expected: true
        System.out.println("Comparing f1 and f3: " + compareFloats(f1, f3)); // Expected: false
        System.out.println("Comparing f1 and f4: " + compareFloats(f1, f4)); // Expected: false
        System.out.println("Comparing f4 and f4: " + compareFloats(f4, f4)); // Expected: false
        System.out.println("Comparing Nan and Nan: " + compareFloats(Float.NaN, Float.NaN)); // Expected: true
        System.out.println("Comparing Nan and 2: " + compareFloats(Float.NaN, 2f)); // Expected: false
        System.out.println("Comparing Infinite and Infinite: " + compareFloats(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY)); // Expected: true
        System.out.println("Comparing Negative Infinite and  Negative Infinite: " + compareFloats(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY)); // Expected: true
    }

    /**
     * Compares two Float objects for equality using Float.compare().
     *
     * @param f1 First Float object.
     * @param f2 Second Float object.
     * @return true if both Float objects are non-null and equal, false otherwise.
     */
    public static boolean compareFloats(Float f1, Float f2) {
        // To-do: Implement the method to compare two Float objects for equality.
        if (f1 == null || f2 == null) {
            return false;
        }

        return f1.compareTo(f2) == 0; // Placeholder return value. Replace with your logic.
    }
}
