package com.util.collection.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UnmodifiableCollectionTest {
    public static List<String> getNames() {
        return List.of("Alice", "Bob", "Charlie");
    }

    public static Set<Integer> getNumbers() {
        return Set.of(1, 2, 3, 4, 5);
    }

    public static Map<String, Integer> getScores() {
        return Map.of("Alice", 90, "Bob", 85, "Charlie", 88);
    }

    //Create Unmodifiable List: Implement a method that returns an unmodifiable list using the sample data.
    //
    public List<String> getUnmodifiableNames() {
        return Collections.unmodifiableList(getNames());
    }

    //Create Unmodifiable Set: Implement a method that returns an unmodifiable set using the sample data.
    //
    public Set<Integer> getUnmodifiableNumbers() {
        return Collections.unmodifiableSet(getNumbers());
    }

    //Create Unmodifiable Map: Implement a method that returns an unmodifiable map using the sample data.
    //
    public Map<String, Integer> getUnmodifiableScores() {
        return Collections.unmodifiableMap(getScores());
    }

    //Attempt Modification: Implement a method that attempts to modify an unmodifiable collection and catches the resulting exception.
    //
    public void attemptModification(List<String> names) {
        try {
            names.add("Insertion on immutable. ");
        } catch (UnsupportedOperationException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //Combine Collections: Implement a method that combines the provided list, set, and map into a single unmodifiable collection.
    //
    public Map<String, Object> combineCollections() {
        var result = new HashMap<String, Integer>();
        var iterator = getNumbers().iterator();
        // It stops when either collection finished
        for (String name : getNames()) {
            if (iterator.hasNext()) {
                result.put(name, iterator.next());
            } else {
                break;
            }
        }
        return Collections.unmodifiableMap(result);
    }


    // ### Additional Functional Requirements for Senior Engineer Level
    //
    //6. **Filter and Return Unmodifiable List**:
    // Implement a method that filters the list of names to include only names starting with 'A',
    // and returns an unmodifiable list.
    public List<String> getFilteredUnmodifiableNames() {
        return getNames().stream()
                .filter( e -> e.charAt(0) == 'A')
                .toList();
    }

    //7. **Merge and Return Unmodifiable Set**:
    // Implement a method that merges the given set with another set of integers,
    // and returns an unmodifiable set.
   public Set<Integer> mergeAndReturnUnmodifiableSet(Set<Integer> additionalNumbers) {
        var unionSet = new HashSet<>(getNumbers());
        unionSet.addAll(additionalNumbers);
        return Collections.unmodifiableSet(unionSet);
   }

    //8. **Transform and Return Unmodifiable Map**:
    // Implement a method that transforms the map by doubling the scores,
    // and returns an unmodifiable map.
    public Map<String, Integer> getTransformedUnmodifiableScores() {
        return getScores().entrySet().stream()
                .collect(Collectors.toUnmodifiableMap(
                        Map.Entry::getKey,
                        e -> e.getValue() * 2
                ));
    }

    //9. **Deep Copy and Unmodifiable Collection**:
    // Implement a method that performs a deep copy of a collection of collections,
    // and returns an unmodifiable version of the deep copy.
    public List<List<String>> getDeepCopiedUnmodifiableList(List<List<String>> nestedList) {

        List<List<String>> deepCopiedList = new ArrayList<>();
        for (List<String> innerList : nestedList) {
            List<String> copiedInnerList = new ArrayList<>(innerList);
            deepCopiedList.add(Collections.unmodifiableList(copiedInnerList));
        }
        return Collections.unmodifiableList(deepCopiedList);
    }

    //10. **Create Nested Unmodifiable Collections**:
    // Implement a method that creates a nested unmodifiable collection,
    // such as a map of lists, where both the outer map and inner lists are unmodifiable.
    public Map<String, List<Integer>> getNestedUnmodifiableCollection() {
        return Map.of(
                "1", List.of(1),
                "2", List.of(2),
                "3", List.of(3)
        );
    }


    //11. **Concurrent Unmodifiable Collection**:
    //  Implement a method that ensures thread-safe operations on a collection and returns an unmodifiable view of it.
    public List<String> getConcurrentUnmodifiableList(List<String> concurrentList) {
        var syncList = Collections.synchronizedList(new ArrayList<>(concurrentList));
        return Collections.unmodifiableList(syncList);
    }

    //12. **Test Immutability**:
    // Write a unit test to ensure that the collections remain unmodifiable after various operations.
    //15. **Exception Handling for Unmodifiable Collections**:
    // Implement a method that handles specific exceptions when attempting to modify unmodifiable collections and provides meaningful error messages.
    public void testUnmodifiableCollections() {
        try {
            getNames().add("test");
        } catch (UnsupportedOperationException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            getNumbers().add(123);
        } catch (UnsupportedOperationException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            getScores().put("Tes", 20);
        } catch (UnsupportedOperationException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //13. **Stream Operations on Unmodifiable Collections**:
    // Implement a method that performs stream operations (e.g., map, filter, collect) on an unmodifiable collection and returns a new unmodifiable collection.
    public List<String> performStreamOperations(List<String> names) {
        return names.stream()
                .filter(String::isBlank)
                .map(String::toUpperCase)
                .toList();

    }

    //14. **Create Unmodifiable Multi-Map**:
    // Implement a method that creates an unmodifiable multi-map (a map of lists) from provided data.
    public Map<String, List<Integer>> getUnmodifiableMultiMap() {
        Map<String, List<Integer>> multiMap = new HashMap<>();

        multiMap.put("Group1", List.of(1, 2, 3));
        multiMap.put("Group2", List.of(4, 5, 6));
        multiMap.put("Group3", List.of(7, 8, 9));

        Map<String, List<Integer>> unmodifiableMultiMap = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : multiMap.entrySet()) {
            unmodifiableMultiMap.put(entry.getKey(), Collections.unmodifiableList(entry.getValue()));
        }

        return Collections.unmodifiableMap(unmodifiableMultiMap);
    }


    //16. **Immutable Data Transfer Object**: Design an immutable Data Transfer Object (DTO) that contains unmodifiable collections and write a method to populate it.
    public final class DataTransferObject {
        List<String> names = Collections.unmodifiableList(UnmodifiableCollectionTest.getNames());
        Set<Integer> numbers = Collections.unmodifiableSet(UnmodifiableCollectionTest.getNumbers());
        Map<String, Integer> scores = Collections.unmodifiableMap(UnmodifiableCollectionTest.getScores());

        public DataTransferObject createDTO() {
            return new DataTransferObject();
        }
    }



    public static void main(String[] args) {

    }
}
