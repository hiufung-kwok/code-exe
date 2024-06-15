package com.lang.longTest;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Exercise 2:
 * Problem Statement:
 * Create a method that accepts a list of Long objects and returns the sum of all the numbers in the list.
 *
 * Functional Requirements:
 *
 * The method should accept a list of Long objects as its parameter.
 * The method should return a single Long value representing the sum of the list elements.
 * If the list is empty, the method should return 0.
 * The method should handle null values in the list gracefully by ignoring them.
 *
 * ### New Functional Requirements for Exercise 2:
 *
 * 1. The method should handle lists with `null` values by treating them as zero in the sum calculation.
 * 2. The method should support an additional parameter to include or exclude negative numbers in the sum.
 * 3. The method should use a parallel stream for summation if the list size exceeds a specified threshold.
 * 4. The method should return `null` if the input list is `null`.
 * 5. The method should allow for an optional initial sum value to be included in the final sum calculation.
 */
public class LongSum {

    public static void main(String[] args) {
        // Test case
        List<Long> numbers = Arrays.asList(1L, 2L, 3L, null, 4L);
        Long result = sumLongList(numbers);
        System.out.println(result); // Expected output: 10
        System.out.println(sumLongList(List.of())); // Expected output: 0
        System.out.println(sumLongList(List.of(-10L, 0L, 100L))); // Expected output: 90
        System.out.println(sumLongList(List.of(-10L, 0L, 100L), false)); // Expected output: 100
        System.out.println(sumLongList(List.of(-10L, 0L, 100L), false, 200L)); // Expected output: 300
    }

    public static Long sumLongList(List<Long> numbers) {
        // Default counting negative.
        return sumLongList(numbers, true, 0L);
    }

    public static Long sumLongList(List<Long> numbers, boolean countNegative) {
        // Default counting negative.
        return sumLongList(numbers, countNegative, 0L);
    }

    public static Long sumLongList(List<Long> numbers, boolean countNegative, Long initialValue) {
        // TODO: Sum all non-null elements in the list and return the result
        if (numbers == null ) {
            return null;
        }

        Stream<Long> stream = (numbers.size() > 5000) ? numbers.parallelStream() : numbers.stream();

        // Stream it
        long result = numbers.stream()
                .filter(Objects::nonNull)
                .filter(x -> countNegative || x > 0)
                .mapToLong(Long::longValue).sum();

        return (initialValue == null) ? result : result + initialValue;

//        Iterative

//        // Stream it
//        // Iterative
//        long ans = (initialValue != null) ? initialValue : 0L;
//        for (Long num : numbers) {
//            if (num != null) {
//                if (countNegative || num > 0){
//                    ans += num;
//                }
//            }
//        }
//        return ans;
    }
}
