package com.lang.longTest;

import java.util.Arrays;
import java.util.function.UnaryOperator;

/**
 * Exercise 3:
 * Problem Statement:
 * Implement a function that converts a given array of long primitives to an array of Long objects.
 *
 * Functional Requirements:
 *
 * The method should accept an array of long primitives as its parameter.
 * The method should return an array of Long objects.
 * The resulting array should have the same length as the input array.
 * Each element in the input array should be converted to its corresponding Long object in the resulting array.
 *
 * ### New Functional Requirements for Exercise 3:
 *
 * 1. The method should handle `null` input by returning `null`.
 * 2. The method should support converting only a specified range within the input array to `Long` objects.
 * 3. The method should allow for converting every nth element of the input array to a `Long` object.
 * 4. The method should throw an `IllegalArgumentException` if the specified range is invalid.
 * 5. The method should allow for applying a transformation function to each element during conversion.
 */
public class LongArrayConversion {

    public static void main(String[] args) {
        // Test case
        long[] primitiveArray = {1, 2, 3, 4, 5};
        Long[] objectArray = convertLongArray(primitiveArray);
        System.out.println(Arrays.toString(objectArray)); // Expected output: [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(convertLongArray(null))); // Expected output: null.
        System.out.println(Arrays.toString(convertLongArray(primitiveArray, 1, 3))); // Expected output: [2, 3]
        System.out.println(Arrays.toString(convertLongArray(primitiveArray, 1, 5, 2))); // Expected output: [2, 3]

        try {
            System.out.println(Arrays.toString(convertLongArray(primitiveArray, 1, 9999))); // Expected output: [2, 3]
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        System.out.println(Arrays.toString(convertLongArray(primitiveArray,
                1, 5, 1, x -> x * 100))); // Expected output: [200, 300, 400, 500]

    }


    public static Long[] convertLongArray(long[] primitiveArray) {
        return convertLongArray(primitiveArray, 0, -1, 1, null);
    }

    public static Long[] convertLongArray(long[] primitiveArray, int startIndex, int endIndex) {
        return convertLongArray(primitiveArray, startIndex, endIndex, 1, null);
    }

    public static Long[] convertLongArray(long[] primitiveArray, int startIndex, int endIndex, int elementToSkip) {
        return convertLongArray(primitiveArray, startIndex, endIndex, elementToSkip, null);
    }

    public static Long[] convertLongArray(long[] primitiveArray, int startIndex, int endIndex, int elementToSkip, UnaryOperator<Long> func) {
        // TODO: Convert the input array of long primitives to an array of Long objects
        if (primitiveArray == null) {
            return null;
        }
        // Only assign endIndex when confirm primitiveArray is valid.
        if (endIndex == -1) {
            endIndex = primitiveArray.length;
        }

        // Range check.
        if (startIndex >= endIndex || startIndex > primitiveArray.length || endIndex > primitiveArray.length) {
            throw new IllegalArgumentException("Invalid range: " + startIndex + " " + endIndex);
        }



        Long[] arr = new Long[(endIndex - startIndex)/elementToSkip ];
        // Iterative
        for (int i = 0; i < (endIndex - startIndex); i+=elementToSkip) {
            if (func != null) {
                arr[i/elementToSkip] = func.apply(primitiveArray[startIndex + i]);
            } else {
                arr[i/elementToSkip] = primitiveArray[startIndex + i];
            }

        }

        return arr;
    }
}
