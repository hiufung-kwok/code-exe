package com.util.iterator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Description:
 * In this exercise, you will learn to use the Iterator interface to traverse elements in a Java collection.
 * You will focus on the standard Java collections implementation such as ArrayList, HashSet, and HashMap.
 * The objective is to familiarize yourself with the iterator API and its methods.
 *
 * The JDK provides several iterator implementations, including:
 *
 * ArrayList (ArrayList.Itr, ArrayList.ListItr)
 * LinkedList (LinkedList.ListItr, LinkedList.DescendingIterator)
 * HashSet (HashSet.Iterator)
 * TreeSet (TreeSet.Iterator, TreeSet.DescendingIterator)
 * HashMap (HashMap.KeyIterator, HashMap.ValueIterator, HashMap.EntryIterator)
 * TreeMap (TreeMap.KeyIterator, TreeMap.ValueIterator, TreeMap.EntryIterator, TreeMap.DescendingKeyIterator)
 * Vector (Vector.Itr, Vector.ListItr)
 * Stack (inherits Vector.Itr, Vector.ListItr)
 * PriorityQueue (PriorityQueue.Itr)
 */
public class CollectionIteratorExample {

    // Iterate over ArrayList: Traverse the elements of the provided ArrayList using an Iterator and print each element.
    static void iterateArrayList(ArrayList<String> arrayList) {
        var iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //Iterate over HashSet: Traverse the elements of the provided HashSet using an Iterator and print each element.
    void iterateHashSet(HashSet<String> hashSet) {
        var iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //Iterate over HashMap: Traverse the entries of the provided HashMap using an Iterator and print each key-value pair.
    void iterateHashMap(HashMap<Integer, String> hashMap) {
        var iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    //Iterate over ArrayList in reverse: Traverse the elements of the provided ArrayList in reverse order using an Iterator and print each element.
    static void iterateArrayListInReverse(ArrayList<String> arrayList) {
        var listIterator = arrayList.listIterator(arrayList.size());
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }

    //Remove elements from ArrayList: Use an Iterator to remove all elements from the provided ArrayList that contain the letter 'a' (case insensitive).
    static void removeElementsFromArrayList(ArrayList<String> arrayList) {
        var iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            var next = iterator.next();
            if (next.startsWith("a") || next.startsWith("A")) {
                iterator.remove();
            }
        }
    }

    //Check element existence in HashSet: Use an Iterator to check if a specified element exists in the provided HashSet and return true or false.
    boolean checkElementInHashSet(HashSet<String> hashSet, String element) {
        var iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(element)) {
                return true;
            }
        }
        return false;
    }

    //Count elements in HashSet: Use an Iterator to count the number of elements in the provided HashSet and return the count.
    static int countElementsInHashSet(HashSet<String> hashSet) {
        int count = 0;
        var iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            count++;
            iterator.next();
        }
        return count;
    }

    //Remove entry from HashMap: Use an Iterator to remove an entry from the provided HashMap where the key matches a specified value.
    void removeEntryFromHashMap(HashMap<Integer, String> hashMap, Integer key) {
        var iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            var item = iterator.next();
            if (item.getKey().equals(key)){
                iterator.remove();
            }
        }
    }

    //Sum of HashMap keys: Use an Iterator to calculate and return the sum of all keys in the provided HashMap.
    int sumOfHashMapKeys(HashMap<Integer, String> hashMap) {
        int sum = 0;
        var iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            sum += iterator.next().getKey();
        }
        return sum;
    }

    //Print HashMap values: Use an Iterator to traverse the values of the provided HashMap and print each value.
    void printHashMapValues(HashMap<Integer, String> hashMap) {
        var iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            var next = iterator.next();
            System.out.println(next.getKey() + " " + next.getValue());
        }
    }

    //Replace values in ArrayList: Use an Iterator to replace each element in the provided ArrayList with its uppercase equivalent.
    static void replaceValuesInArrayList(ArrayList<String> arrayList) {
        var iterator = arrayList.listIterator();
        while (iterator.hasNext()) {
            var next = iterator.next();
            iterator.remove();
            iterator.add(next.toUpperCase());
        }
    }

    //Filter HashSet elements: Use an Iterator to filter and return a new HashSet containing only the elements from the provided HashSet that start with a vowel.
    HashSet<String> filterHashSetElements(HashSet<String> hashSet) {
        var vowelSet = new HashSet();
        var iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            var next = iterator.next();
            if (next.matches("^[AEIOUaeiou]")){
                vowelSet.add(next);
            }
        }
        return vowelSet;
    }

    //Update HashMap values: Use an Iterator to update the value of each entry in the provided HashMap by appending the string "-updated" to each value.
    void updateHashMapValues(HashMap<Integer, String> hashMap) {
        var iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            var next = iterator.next();
            next.setValue(next.getValue() + "-updated");
        }
    }

    //Find longest string in ArrayList: Use an Iterator to find and return the longest string in the provided ArrayList. If there are multiple strings of the same maximum length, return the first one encountered.
    String findLongestStringInArrayList(ArrayList<String> arrayList) {
        String str = null;
        var iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            var item = iterator.next();
            if (str == null || item.length() > str.length()) {
                str = item;
            }
        }
        return str;
    }

    //Merge two HashMaps: Use an Iterator to merge the entries of a second HashMap into the provided HashMap. If a key already exists in the first HashMap,
    // append the value from the second HashMap to the existing value with a hyphen.
    void mergeHashMaps(HashMap<Integer, String> hashMap1, HashMap<Integer, String> hashMap2) {
        var iterator = hashMap2.entrySet().iterator();
        while (iterator.hasNext()) {
            var item = iterator.next();
//            if (hashMap1.containsKey(item.getKey())) {
//                hashMap1.put(item.getKey(), hashMap1.get(item.getKey()) + "-" + item.getValue());
//            } else {
//                hashMap1.put(item.getKey(), item.getValue());
//            }
            hashMap1.put(item.getKey(),
                    (hashMap1.containsKey(item.getKey()))
                        ? hashMap1.get(item.getKey()) + "-" + item.getValue()
                        : item.getValue());


        }

    }



    public static void main(String[] args) {
        // Sample data for ArrayList
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Apple");
        arrayList.add("Banana");
        arrayList.add("Cherry");

        // Sample data for HashSet
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Dog");
        hashSet.add("Cat");
        hashSet.add("Rabbit");

        // Sample data for HashMap
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(3, "Three");

        iterateArrayList(arrayList);
//        removeElementsFromArrayList(arrayList);
        replaceValuesInArrayList(arrayList);
        iterateArrayList(arrayList);

//        iterateArrayListInReverse(arrayList);
//        System.out.println("Size: " + countElementsInHashSet(hashSet));

        // TODO: Implement the methods to iterate over the collections using Iterator
    }
}
