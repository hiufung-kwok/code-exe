package com.util.comparable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Getters and setters

    @Override
    public int compareTo(Student other) {
        // Default comparison logic
         return this.name.compareTo(other.name);

        //Compare by Age: Implement comparison logic to sort Student objects by age in ascending order.
//        return Integer.compare(this.age, other.age);

        //Compare by Grade: Implement comparison logic to sort Student objects by grade in descending order.
//        return Double.compare(other.grade, this.grade);

        //Secondary Sort: Modify the comparison logic to sort by age, then by grade if ages are equal.
//        int ageComparison = Integer.compare(this.age, other.age);
//        if (ageComparison != 0) {
//            return ageComparison;
//        }
//        Double.compare(other.grade, this.grade);

        //Custom Comparator: Create a custom comparator to sort by grade first, then by name if grades are equal.
//        int gradeComparison = Double.compare(this.grade, other.grade);
//        if (gradeComparison != 0) {
//            return gradeComparison;
//        }
//        return this.name.compareTo(other.name);
    }

    //Sorting and Display: Write a method to sort a list of students using the implemented comparison logic and print the sorted list.
    public void sortAndDisplay (List<Student> students) {
        Collections.sort(students);
        students.forEach(System.out::println);
    }

    //Sort by Name Ignoring Case: Implement comparison logic in the Student class to sort students by name, ignoring case.
    //
    public int compareToIgnoreCase(Student other) {
        return this.name.compareToIgnoreCase(other.name);
    }

    //Sort by Age and Reverse Alphabetical Name: Sort students by age and then by name in reverse alphabetical order.
    //
    public int compareToByAgeAndReverseName(Student other) {
        int ageComparison = Integer.compare(this.age, other.age);
        return (ageComparison != 0)
                ? ageComparison
                : other.name.compareTo(this.name);
    }

    //Sort by Grade with Threshold Filter: Sort students by grade, but only include students with grades above a certain threshold.
    //
    public List<Student> sortByGradeWithThreshold(List<Student> students, double threshold) {
        return students.stream()
                .filter(s -> s.grade > threshold)
                .sorted(Comparator.comparing(s -> s.grade))
                .toList();
    }

    //Sort by Name with Suffix Priority: Sort students by name, giving priority to names that end with a specific suffix.
    public int compareToByNameWithSuffixPriority(Student other, String suffix) {
        boolean thisSuffix = this.name.endsWith(suffix);
        boolean otherSuffix = other.name.endsWith(suffix);

        if (thisSuffix && !otherSuffix) {
            return -1;
        } else if (!thisSuffix && otherSuffix) {
            return 1;
        } else {
            return this.name.compareTo(other.name);
        }
    }

    //Sort by Age and Name Length Combination: Sort students by a combination of age and the length of their names.
    public int compareToByAgeAndNameLength(Student other) {
        int ageComparison = Integer.compare(this.age, other.age);
        return (ageComparison != 0)
                ? ageComparison
                : Integer.compare(this.name.length(), other.name.length());
    }

    //Sort by Custom Weight Function: Sort students using a custom weight function that considers age, grade, and name length.
    public int compareToByCustomWeight(Student other) {
        final double ageWeight = 0.3F;
        final double gradeWeight = 0.5F;
        final double nameWeight = 0.2F;

        double thisWeight = this.age * ageWeight + this.grade * gradeWeight + this.name.length() * nameWeight;
        double otherWeight = other.age * ageWeight + other.grade * gradeWeight + other.name.length() * nameWeight;
        return Double.compare(thisWeight, otherWeight);
    }

    //Sort by Age Group and Average Grade: Group students by age range (e.g., 10-15, 16-20) and sort within groups by average grade.
    public List<Student> sortByAgeGroupAndAverageGrade(List<Student> students) {
        return students.stream()
                .sorted(Comparator
                        .comparingInt( (Student s) -> s.age / 5)
                        .thenComparingDouble(s -> s.grade))
                .toList();

    }

    //Sort by Name with Special Character Handling: Sort students by name, placing names with special characters at the end.
    public int compareToByNameWithSpecialCharacterHandling(Student other) {
        final String regex = "[a-zA-Z]*";
        boolean thisSpecialChar = !this.name.matches(regex);
        boolean otherSpecialChar = !other.name.matches(regex);

        if (thisSpecialChar && !otherSpecialChar) {
            return 1;
        } else if (!thisSpecialChar && otherSpecialChar) {
            return -1;
        } else {
            return this.name.compareTo(other.name);
        }
    }




    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", grade=" + grade + "}";
    }

    public static void main(String[] args) {
    }
}
