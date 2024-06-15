package com.lang.floatTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Problem Statement
 * Implement a method to find the minimum and maximum values from a list of floating-point numbers,
 * using the Java Float class.
 *
 * Functional Requirements
 * Create a class FloatMinMax with a method findMinMax that takes a list of Float values as input.
 * The method should return a Pair<Float, Float> where the first element is the minimum value,
 * and the second element is the maximum value from the list.
 *
 * Handle the case where the list is empty by throwing an IllegalArgumentException.
 * If the list contains null values, they should be ignored.
 * Use the Float class methods for comparison.
 * Ensure the method is efficient and handles large lists of numbers.
 *
 * ### Additional Functional Requirements
 * 1. **Precision Handling**: Ensure that the method maintains the precision of the float values up to two decimal places.
 * 2. **Handling Special Values**: Ensure the method correctly handles special float values like `Float.NaN`, `Float.POSITIVE_INFINITY`, and `Float.NEGATIVE_INFINITY`.
 * 3. **Custom Pair Class**: Implement a custom `Pair` class within the `FloatMinMax` class instead of using an external or pre-defined class.
 * 4. **Stream API**: Use Java Stream API for filtering and finding the minimum and maximum values.
 * 5. **Parallel Processing**: Ensure the method can handle parallel processing for large datasets.
 * 6. **Logging**: Add logging to record the input list and the resulting minimum and maximum values.
 * 7. **Performance Measurement**: Measure and log the time taken to find the minimum and maximum values.
 * 8. **Immutable Result**: Ensure that the `Pair` object returned is immutable.
 * 9. **Custom Exception**: Throw a custom exception `NoValidFloatValuesException` if the list does not contain any valid float values.
 * 10. **Input List Copy**: Make a defensive copy of the input list to ensure the original list is not modified.
 */
public class FloatMinMax {

    public static void main(String[] args) {
        // Test dataset
        List<Float> numbers = Arrays.asList(1.5f, -2.3f, 4.4f, null, 3.3f, -1.1f);

        // Example usage and expected output
        Pair<Float, Float> result = findMinMax(numbers);
        System.out.println("Min: " + result.getFirst()); // Expected: -2.3
        System.out.println("Max: " + result.getSecond()); // Expected: 4.4
    }

    /**
     * Find the minimum and maximum values in a list of Float numbers.
     *
     * @param numbers the list of Float numbers
     * @return a Pair containing the minimum and maximum values
     * @throws IllegalArgumentException if the list is empty or null
     */
    public static Pair<Float, Float> findMinMax(List<Float> numbers) {
        // To-do: Implement the method logic to find the minimum and maximum values
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Empty list, no-ops.");
        }
        // Defensive copy.
        List<Float> clonedNums = new ArrayList<>(numbers);

        DecimalFormat formatter = new DecimalFormat();
        formatter.setMaximumFractionDigits(2);
        // Stream it
        DoubleSummaryStatistics stat = clonedNums.stream()
                .filter(Objects::nonNull)
                .map(FloatMinMax::countToTwoDecimalPlaces)
                .collect(Collectors.summarizingDouble(Float::doubleValue));
        return new Pair<>((float) stat.getMin(),(float) stat.getMax());

//        Iterative
//        Float min = null;
//        Float max = null;
//        for (Float num : numbers) {
//            if (num != null) {
//                if (max == null || num.compareTo(max) > 0) {
//                    max = num;
//                }
//
//                if (min == null || num.compareTo(min) < 0) {
//                    min = num;
//                }
//            }
//        }
//        return new Pair<>(
//                countToTwoDecimalPlaces(min),
//                countToTwoDecimalPlaces(max)); // Placeholder return statement
    }

    private static Float countToTwoDecimalPlaces(Float value) {
        BigDecimal bd = new BigDecimal(value);
        bd.setScale(2, RoundingMode.HALF_UP);
        return bd.floatValue();
    }
}




// A simple Pair class to hold two values
class Pair<F, S> {
    private final F first;
    private final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }
}
