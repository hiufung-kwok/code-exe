package com.util.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class ComparatorTest {

    static class Employee {
        String name;
        int age;
        double salary;

        Employee(String name, int age, double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
        }
    }
    public static List<Employee> getSampleEmployees() {
        return Arrays.asList(
                new Employee("Alice", 30, 70000),
                new Employee("Bob", 25, 50000),
                new Employee("Charlie", 35, 120000),
                new Employee("Kit", 35, 70000),
                new Employee("Kitty", 35, 70000),
                new Employee("Andy", 35, 90000),
                new Employee("David", 28, 55000),
                new Employee("Eve", 40, 85000)
        );
    }

    // Sort by Name (Lambda):
    // Implement a Comparator to sort the list of employees by their names in alphabetical order.
    public static final Comparator<Employee> nameComparator = (o1, o2) -> {
        return o1.name.compareTo(o2.name);
    };


    // Sort by Name (Comparing).
    public static final Comparator<Employee> nameComparatorNew = Comparator.comparing(o -> o.name);

    //Sort by Age:
    //Create a Comparator to sort the employees by age in ascending order.
    public static final Comparator<Employee> ageComparator = Comparator.comparing(Employee::getAge);

    //Sort by Salary:
    //Write a Comparator to sort the employees by salary in descending order.
    public static final Comparator<Employee> salaryDescComparator = Comparator.comparing(Employee::getSalary)
            .reversed();

    //Sort by Age then Name:
    //Develop a Comparator that first sorts by age, then by name if ages are the same.
    public static final Comparator<Employee> ageNameComparator = Comparator
            .comparing(Employee::getAge)
            .thenComparing(Employee::getName);

    //Sort by Name Length:
    //Implement a Comparator to sort employees by the length of their names in ascending order.
    public static final Comparator<Employee> nameLenComparator = Comparator
            .comparingInt( e -> e.getName().length());

    //Sort by First Character of Name:
    //Develop a Comparator that sorts employees by the first character of their names in alphabetical order.
    public static final Comparator<Employee> firstCharComparator = Comparator
            .comparing( e -> e.getName().charAt(0));

    //Sort by Name Length then Salary:
    //Implement a Comparator to sort employees first by the length of their names in ascending order,
    // then by salary in descending order if name lengths are the same.
    public static final Comparator<Employee> nameLenSalaryAllReviseComparator = Comparator
            .comparingInt((Employee e) -> e.name.length())
            .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed());

    public static final Comparator<Employee> ageSalaryAllReviseComparator = Comparator
            .comparingInt(Employee::getAge)
            .thenComparingDouble(Employee::getSalary)
            .thenComparing(employee -> employee.getName().length())
            .reversed();


    // Sort by Name with Case Insensitivity:
    //Implement a Comparator that sorts the list of employees by their names in alphabetical order, ignoring case differences.
    public static final Comparator<Employee> nameIgnoreCaseComparator = Comparator
            .comparing( e -> e.getName().toLowerCase());

    //Sort by Age with Null Handling:
    //Create a Comparator to sort employees by age in ascending order,
    // ensuring that null values are handled gracefully (e.g., treating null ages as the lowest value).
    public static final Comparator<Employee> ageNullLastComparator = Comparator
            .comparing(Employee::getAge, Comparator.nullsLast(Comparator.naturalOrder()));


    //Sort by Custom Criteria:
    //Write a Comparator that sorts employees based on a custom criteria,
    //which is defined by a user-provided lambda expression.
    public static void sortByCustomCriteria (List<Employee> list, Comparator comparator) {
        list.sort(comparator);
    }

    //Sort by Name Length with Secondary Criteria:
    //Develop a Comparator that sorts employees by the length of their names in ascending order,
    // with a secondary sort by salary in descending order if name lengths are the same,
    // and a tertiary sort by age in ascending order if salaries are the same.
    public static final Comparator<Employee> teriaryComparator = Comparator
            .comparingInt((Employee e) -> e.getName().length())
            .thenComparing(Employee::getSalary, Comparator.reverseOrder())
            .thenComparing(Employee::getAge);

    //Sort by Complex Nested Criteria:
    //Implement a Comparator that sorts employees first by age in ascending order,
    // then by salary in descending order, and finally by the reverse alphabetical order of their names.
    // Handle edge cases such as null values and ensure the Comparator is efficient for large data sets.
    public static final Comparator<Employee> complexComparator = Comparator
            .comparing(Employee::getAge)
            .thenComparing(Employee::getSalary, Comparator.nullsLast(Comparator.reverseOrder()))
            .thenComparing(Employee::getName, Comparator.nullsLast(Comparator.reverseOrder()));



    public static void main(String[] args) {

        var test = getSampleEmployees();
        test.sort(ageSalaryAllReviseComparator);
        test.forEach(System.out::println);

    }
}
