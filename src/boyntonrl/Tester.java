/*
 * CS2852
 * Spring 2017
 * Lab 6 - Recursion
 * Name: Rock Boynton
 * Created: 3/30/2017
 */
package boyntonrl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Tests the ArrayList and LinkedList implementations for the
 * CS2852 Lab 6 assignment.
 */
public class Tester {
    private final static String[] EMPTY_STRINGS = {};
    private final static String[] STRINGS1 = {"this"};
    private final static String[] STRINGS2 = {"this", "will"};
    private final static String[] STRINGS3 = {"this", "will", "be"};
    private final static String[] STRINGS4 = {"this", "will", "be", "interesting"};
    private final static String[] STRINGS5 = {"this", null, "will", "be", "interesting"};
    private final static String[] RANDOM_STRINGS = {"foo", "bar"};

    private final static int[] EMPTY_INTS = {};
    private final static int[] INTS1 = {-1};
    private final static int[] INTS2 = {-1, 2};
    private final static int[] INTS3 = {-1, 2, 8};
    private final static int[] INTS4 = {-1, 2, 8, Integer.MAX_VALUE};
    private final static int[] RANDOM_INTS = {Integer.MIN_VALUE, 13, 7};

    /**
     * Calls all of the test methods
     * @param ignored Not used
     */
    public static void main(String[] ignored) {
        constructorTests();

        containsTests();

        indexOfTests();
//
//        sizeTests();
//
//        getTests();
    }

    private static void constructorTests() {
        String description = "ArrayList constructor collection of Strings of size: ";
        test(description + 0, stringConstructorArrayList(EMPTY_STRINGS));
        test(description + 1, stringConstructorArrayList(STRINGS1));
        test(description + 2, stringConstructorArrayList(STRINGS2));
        test(description + 3, stringConstructorArrayList(STRINGS3));
        test(description + 4, stringConstructorArrayList(STRINGS4));
        test(description + 5, stringConstructorArrayList(STRINGS5));

        description = "ArrayList constructor collection of Integers of size: ";
        test(description + 0, intConstructorArrayList(EMPTY_INTS));
        test(description + 1, intConstructorArrayList(INTS1));
        test(description + 2, intConstructorArrayList(INTS2));
        test(description + 3, intConstructorArrayList(INTS3));
        test(description + 4, intConstructorArrayList(INTS4));

        description = "LinkedList constructor collection of Strings of size: ";
        test(description + 0, stringConstructorLinkedList(EMPTY_STRINGS));
        test(description + 1, stringConstructorLinkedList(STRINGS1));
        test(description + 2, stringConstructorLinkedList(STRINGS2));
        test(description + 3, stringConstructorLinkedList(STRINGS3));
        test(description + 4, stringConstructorLinkedList(STRINGS4));
        test(description + 5, stringConstructorLinkedList(STRINGS5));

        description = "LinkedList constructor collection of Integers of size: ";
        test(description + 0, intConstructorLinkedList(EMPTY_INTS));
        test(description + 1, intConstructorLinkedList(INTS1));
        test(description + 2, intConstructorLinkedList(INTS2));
        test(description + 3, intConstructorLinkedList(INTS3));
        test(description + 4, intConstructorLinkedList(INTS4));
    }

    private static void containsTests() {
        String description;
        description = "ArrayList contains collection of String of size: ";
        test(description + 0, arrayListContains(EMPTY_STRINGS));
        test(description + 1, arrayListContains(STRINGS1));
        test(description + 2, arrayListContains(STRINGS2));
        test(description + 3, arrayListContains(STRINGS3));
        test(description + 4, arrayListContains(STRINGS4));
        test(description + 5, arrayListContains(STRINGS5));

        description = "ArrayList contains collection of Integers of size: ";
        test(description + 0, arrayListContains(EMPTY_INTS));
        test(description + 1, arrayListContains(INTS1));
        test(description + 2, arrayListContains(INTS2));
        test(description + 3, arrayListContains(INTS3));
        test(description + 4, arrayListContains(INTS4));

        description = "LinkedList contains collection of String of size: ";
        test(description + 0, linkedListContains(EMPTY_STRINGS));
        test(description + 1, linkedListContains(STRINGS1));
        test(description + 2, linkedListContains(STRINGS2));
        test(description + 3, linkedListContains(STRINGS3));
        test(description + 4, linkedListContains(STRINGS4));
        test(description + 5, linkedListContains(STRINGS5));

        description = "LinkedList contains collection of String of size: ";
        test(description + 0, linkedListContains(EMPTY_INTS));
        test(description + 1, linkedListContains(INTS1));
        test(description + 2, linkedListContains(INTS2));
        test(description + 3, linkedListContains(INTS3));
        test(description + 4, linkedListContains(INTS4));
    }

    private static void indexOfTests() {
        String description;
        description = "ArrayList indexOf collection of String of size: ";
        test(description + 0, arrayListIndexOf(EMPTY_STRINGS));
        test(description + 1, arrayListIndexOf(STRINGS1));
        test(description + 2, arrayListIndexOf(STRINGS2));
        test(description + 3, arrayListIndexOf(STRINGS3));
        test(description + 4, arrayListIndexOf(STRINGS4));
        test(description + 5, arrayListIndexOf(STRINGS5));

        description = "ArrayList indexOf collection of Integers of size: ";
        test(description + 0, arrayListIndexOf(EMPTY_INTS));
        test(description + 1, arrayListIndexOf(INTS1));
        test(description + 2, arrayListIndexOf(INTS2));
        test(description + 3, arrayListIndexOf(INTS3));
        test(description + 4, arrayListIndexOf(INTS4));

        description = "LinkedList indexOf collection of String of size: ";
        test(description + 0, linkedListIndexOf(EMPTY_STRINGS));
        test(description + 1, linkedListIndexOf(STRINGS1));
        test(description + 2, linkedListIndexOf(STRINGS2));
        test(description + 3, linkedListIndexOf(STRINGS3));
        test(description + 4, linkedListIndexOf(STRINGS4));
        test(description + 5, linkedListIndexOf(STRINGS5));

        description = "LinkedList indexOf collection of String of size: ";
        test(description + 0, linkedListIndexOf(EMPTY_INTS));
        test(description + 1, linkedListIndexOf(INTS1));
        test(description + 2, linkedListIndexOf(INTS2));
        test(description + 3, linkedListIndexOf(INTS3));
        test(description + 4, linkedListIndexOf(INTS4));
    }

//    private static void sizeTests() {
//        String description;
//        description = "LinkedList size collection of String of size: ";
//        test(description + 0, linkedListSize(EMPTY_STRINGS));
//        test(description + 1, linkedListSize(STRINGS1));
//        test(description + 2, linkedListSize(STRINGS2));
//        test(description + 3, linkedListSize(STRINGS3));
//        test(description + 4, linkedListSize(STRINGS4));
//        test(description + 5, linkedListSize(STRINGS5));
//
//        description = "LinkedList size collection of String of size: ";
//        test(description + 0, linkedListSize(EMPTY_INTS));
//        test(description + 1, linkedListSize(INTS1));
//        test(description + 2, linkedListSize(INTS2));
//        test(description + 3, linkedListSize(INTS3));
//        test(description + 4, linkedListSize(INTS4));
//    }

//    private static void getTests() {
//        String description;
//        description = "LinkedList get collection of String of size: ";
//        test(description + 0, linkedListGet(EMPTY_STRINGS));
//        test(description + 1, linkedListGet(STRINGS1));
//        test(description + 2, linkedListGet(STRINGS2));
//        test(description + 3, linkedListGet(STRINGS3));
//        test(description + 4, linkedListGet(STRINGS4));
//        test(description + 5, linkedListGet(STRINGS5));
//
//        description = "LinkedList get collection of String of size: ";
//        test(description + 0, linkedListGet(EMPTY_INTS));
//        test(description + 1, linkedListGet(INTS1));
//        test(description + 2, linkedListGet(INTS2));
//        test(description + 3, linkedListGet(INTS3));
//        test(description + 4, linkedListGet(INTS4));
//    }

    /**
     * Displays an error if the test fails
     * @param description Description of the test
     * @param passed true if the test passed
     */
    private static void test(String description, boolean passed) {
        if(!passed) {
            System.out.println("Test failed: " + description);
        }
    }

    //----------------------------------------------------------------------------------------------

    /**
     * Tests the constructor that accepts a collection of elements.
     * After the ArrayList is instantiated, the size is compared with
     * the size of the collection.
     * @param strings An array of Strings to be added to the ArrayList
     * @return true if test passed
     */
    private static boolean stringConstructorArrayList(String[] strings) {
        Collection<String> input = new java.util.ArrayList<>();
        for(String string : strings) {
            input.add(string);
        }
        List<String> list = new ArrayList<>(input);
        return list.size()==input.size();
    }

    /**
     * Tests the constructor that accepts a collection of elements.
     * After the ArrayList is instantiated, the size is compared with
     * the size of the collection.
     * @param numbers An array of ints to be added to the ArrayList
     * @return true if test passed
     */
    private static boolean intConstructorArrayList(int[] numbers) {
        Collection<Integer> input = new java.util.ArrayList<>();
        for(int number : numbers) {
            input.add(number);
        }
        List<Integer> list = new ArrayList<>(input);
        return list.size()==input.size();
    }

    /**
     * Tests the constructor that accepts a collection of elements.
     * After the LinkedList is instantiated, the size is compared with
     * the size of the collection. Assumes size() method works.
     * @param strings An array of Strings to be added to the LinkedList
     * @return true if test passed
     */
    private static boolean stringConstructorLinkedList(String[] strings) {
        Collection<String> input = new java.util.LinkedList<>();
        for(String string : strings) {
            input.add(string);
        }
        List<String> list = new LinkedList<>(input);
        return list.size()==input.size();
    }

    /**
     * Tests the constructor that accepts a collection of elements.
     * After the LinkedList is instantiated, the size is compared with
     * the size of the collection. Assumes size() method works.
     * @param numbers An array of ints to be added to the LinkedList
     * @return true if test passed
     */
    private static boolean intConstructorLinkedList(int[] numbers) {
        Collection<Integer> input = new java.util.LinkedList<>();
        for(int number : numbers) {
            input.add(number);
        }
        List<Integer> list = new LinkedList<>(input);
        return list.size()==input.size();
    }

    //----------------------------------------------------------------------------------------------

    /**
     * Tests if the ArrayList contains() method contains each word in the list and
     * doesn't contain random stuff not in the list.
     * Assumes size() and get() work properly.
     * @param strings string array to construct ArrayList
     * @return true if the test passed, false if it failed
     */
    private static boolean arrayListContains(String[] strings) {
        Collection<String> util = new java.util.ArrayList<>(Arrays.asList(strings));
        List<String> myList = new ArrayList<>(util);
        return containsStringPassed(myList);
    }

    /**
     * Tests if the ArrayList contains() method contains each word in the list and
     * doesn't contain random stuff not in the list.
     * Assumes size() and get() work properly.
     * @param numbers int array to construct ArrayList
     * @return true if the test passed, false if it failed
     */
    private static boolean arrayListContains(int[] numbers) {
        Collection<Integer> util = new java.util.ArrayList<>();
        for (int num : numbers) {
            util.add(num);
        }
        List<Integer> myList = new ArrayList<>(util);
        return containsIntPassed(myList);
    }

    /**
     * Tests if the LinkedList contains() method contains each word in the list and
     * doesn't contain random stuff not in the list.
     * Assumes size() and get() work properly.
     * @param strings string array to construct ArrayList
     * @return true if the test passed, false if it failed
     */
    private static boolean linkedListContains(String[] strings) {
        Collection<String> util = new java.util.LinkedList<>(Arrays.asList(strings));
        List<String> myList = new LinkedList<>(util);
        return containsStringPassed(myList);
    }

    /**
     * Tests if the LinkedList contains() method contains each word in the list and
     * doesn't contain random stuff not in the list.
     * Assumes size() and get() work properly.
     * @param numbers int array to construct ArrayList
     * @return true if the test passed, false if it failed
     */
    private static boolean linkedListContains(int[] numbers) {
        Collection<Integer> util = new java.util.LinkedList<>();
        for (int num : numbers) {
            util.add(num);
        }
        List<Integer> myList = new LinkedList<>(util);
        return containsIntPassed(myList);
    }


    private static boolean containsStringPassed(List<String> myList) {
        boolean passed = true;
        for (int i = 0; i < myList.size() && passed; i++) {
            if (!myList.contains(myList.get(i))) {
                passed = false;
            }
        }
        for (String randomString : RANDOM_STRINGS) {
            if (myList.contains(randomString)) {
                passed = false;
            }
        }
        return passed;
    }

    private static boolean containsIntPassed(List<Integer> myList) {
        boolean passed = true;
        for (int i = 0; i < myList.size() && passed; i++) {
            if (!myList.contains(myList.get(i))) {
                passed = false;
            }
        }
        for (int randomInt : RANDOM_INTS) {
            if (myList.contains(randomInt)) {
                passed = false;
            }
        }
        return passed;
    }

    //----------------------------------------------------------------------------------------------

    private static boolean arrayListIndexOf(String[] strings) {
        Collection<String> util = new java.util.ArrayList<>(Arrays.asList(strings));
        List<String> myList = new ArrayList<>(util);
        return indexOfStringPassed(myList);
    }

    private static boolean arrayListIndexOf(int[] numbers) {
        Collection<Integer> util = new java.util.ArrayList<>();
        for (int num : numbers) {
            util.add(num);
        }
        List<Integer> myList = new ArrayList<>(util);
        return indexOfIntPassed(myList);
    }

    private static boolean linkedListIndexOf(String[] strings) {
        Collection<String> util = new java.util.LinkedList<>(Arrays.asList(strings));
        List<String> myList = new LinkedList<>(util);
        return indexOfStringPassed(myList);
    }

    private static boolean linkedListIndexOf(int[] numbers) {
        Collection<Integer> util = new java.util.LinkedList<>();
        for (int num : numbers) {
            util.add(num);
        }
        List<Integer> myList = new LinkedList<>(util);
        return indexOfIntPassed(myList);
    }

    private static boolean indexOfStringPassed(List<String> myList) {
        return false;
    }

    private static boolean indexOfIntPassed(List<Integer> myList) {
        return false;
    }

    private static boolean assertEquals(int value1, int value2) {
        return value1 == value2;
    }
}