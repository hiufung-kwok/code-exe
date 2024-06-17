package com.util.collection.set;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.HashSet;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SetTest {
    public static Set<String> getSampleData1() {
        Set<String> sampleData1 = new HashSet<>();
        sampleData1.add("apple");
        sampleData1.add("banana");
        sampleData1.add("cherry");
        sampleData1.add("date");
        sampleData1.add("elderberry");
        return sampleData1;
    }

    public static Set<String> getSampleData2() {
        Set<String> sampleData2 = new HashSet<>();
        sampleData2.add("fig");
        sampleData2.add("grape");
        sampleData2.add("honeydew");
        sampleData2.add("apple");
        sampleData2.add("banana");
        return sampleData2;
    }
    //Add Element: Implement a method to add a new fruit to the set. Ensure duplicates are not added.
    public boolean addFruit(Set<String> fruits, String fruit) {
        return fruits.add(fruit);
    }

    //Remove Element: Implement a method to remove a fruit from the set.
    public boolean removeFruit(Set<String> fruits, String fruit) {
        return fruits.remove(fruit);
    }

    //Check Element: Implement a method to check if a fruit is present in the set.
    //
    public boolean containsFruit(Set<String> fruits, String fruit) {
        return fruits.contains(fruit);
    }

    //Union of Sets: Implement a method to return the union of two sets.
    //
    public Set<String> unionSets(Set<String> set1, Set<String> set2) {
        var unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }

    //Intersection of Sets: Implement a method to return the intersection of two sets.
    //
    public Set<String> intersectSets(Set<String> set1, Set<String> set2) {
        var interSectSet = new HashSet<>(set1);
        interSectSet.retainAll(set2);
        return interSectSet;
    }

    //Difference of Sets: Implement a method to return the difference between two sets (elements in the first set but not in the second).
    //
    public Set<String> differenceSets(Set<String> set1, Set<String> set2) {
        var differentSet = new HashSet<>(set1);
        differentSet.removeAll(set2);
        return differentSet;

    }

    //Set Size: Implement a method to return the size of the set.
    //
    public int getSize(Set<String> fruits) {
        return fruits.size();
    }

    //Clear Set: Implement a method to clear all elements from the set.
    //
    public void clearSet(Set<String> fruits) {
        fruits.clear();
    }

    //Convert Set to List: Implement a method to convert the set to a list.
    //
    public List<String> convertToList(Set<String> fruits) {
        return new ArrayList<>(fruits);
    }

    //Iterate Over Set: Implement a method to iterate over the set and print each fruit.
    //
    public void printFruits(Set<String> fruits) {
        fruits.forEach(System.out::println);
    }

    //Subset Check: Implement a method to check if one set is a subset of another.
    //
    public boolean isSubset(Set<String> subset, Set<String> superset) {
        return superset.containsAll(subset);
    }

    //Symmetric Difference: Implement a method to find the symmetric difference between two sets (elements in either of the sets but not in both).
    //
    public Set<String> symmetricDifference(Set<String> set1, Set<String> set2) {
        // Get the duplicate first, then use it as filter for both sets.
        var interSectSet = new HashSet<>(set1);
        for (String str : set2) {
            if (!interSectSet.add(str)) {
                interSectSet.remove(str);
            }
        }
        return interSectSet;
    }

    //Immutable Set: Implement a method to return an immutable copy of the set.
    //
    public Set<String> getImmutableSet(Set<String> fruits) {
        return (Set<String>) Collections.unmodifiableCollection(new HashSet<>(fruits));
    }

    //Find Longest String: Implement a method to find the longest string in the set.
    //
    public String findLongestString(Set<String> fruits) {
        Optional<String> result = fruits.stream()
                .max(Comparator.comparing(String::length));

        return result.orElse("");
    }

    //Frequency Map: Implement a method to create a frequency map of character occurrences across all strings in the set.
    //
    public Map<Character, Integer> getCharacterFrequency(Set<String> fruits) {
        // Iterative
//        Map<Character, Integer> freqMap = new HashMap<>();
//        for (String fruit : fruits) {
//            for (char c : fruit.toCharArray()) {
//                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
//            }
//        }
//        return freqMap;
        return fruits.stream()
                .flatMapToInt(String::chars)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toMap(
                        Function.identity(),
                        c -> 1,
                        Integer::sum));

    }

    //Custom Comparator: Implement a method to return a sorted list of the set's elements using a custom comparator (e.g., by string length).
    //
    public List<String> sortWithComparator(Set<String> fruits, Comparator<String> comparator) {
        var list = new ArrayList<>(fruits);
        list.sort(comparator);
        return list;

    }

    //Parallel Processing: Implement a method to process each element in the set in parallel and return the results (e.g., convert each string to uppercase).
    //
    public Set<String> processInParallel(Set<String> fruits, Function<String, String> processor) {
        return fruits.parallelStream()
                .map(processor)
                .collect(Collectors.toSet());

    }

    //Filter Elements: Implement a method to filter elements in the set based on a given predicate.
    //
    public Set<String> filterSet(Set<String> fruits, Predicate<String> condition) {
        return fruits.stream()
                .filter(condition)
                .collect(Collectors.toSet());
    }

    //Merge Multiple Sets: Implement a method to merge multiple sets into one.
    //
    public Set<String> mergeMultipleSets(Set<String>... sets) {
        var resultSet = new HashSet<String>();
        for (Set<String> set : sets) {
            resultSet.addAll(set);
        }
        return resultSet;
    }

    //Stream Operations: Implement a method to demonstrate a stream operation that collects the set's elements into a single concatenated string.
    //
    public String concatenateWithStream(Set<String> fruits) {
        return fruits.stream()
                .collect(Collectors.joining(", "));
//        return String.join(", ", fruits);

    }

    //Thread-Safe Set: Implement a method to return a thread-safe version of the set.
    //
    public Set<String> getThreadSafeSet(Set<String> fruits) {
        return Collections.synchronizedSet(fruits);
    }

    //Custom Serialization: Implement custom serialization and deserialization for the set.
    //
    public byte[] serializeSet(Set<String> fruits) {
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(fruits);
            return bos.toByteArray();
             } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Set<String> deserializeSet(byte[] data) {
        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            return (Set<String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) {
        // Functional Requirements
        System.out.println(new SetTest().findLongestString(getSampleData1()));


    }
}
