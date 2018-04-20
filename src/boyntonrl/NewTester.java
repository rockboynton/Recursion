/*
 * CS2852
 * Spring 2017
 * Lab 6 - Recursion
 * Name:
 * Created: 3/30/2017
 */
package boyntonrl;

import java.util.Collection;
import java.util.List;

/**
 * Tests the ArrayList and LinkedList implementations for the
 * CS2852 Lab 6 assignment.
 */
public class NewTester {
    private final static String[] EMPTY_STRINGS = {};
    private final static String[] STRINGS1 = {"this"};
    private final static String[] STRINGS2 = {"this", "will"};
    private final static String[] STRINGS3 = {"this", "will", "be"};
    private final static String[] STRINGS4 = {"this", "will", "be", "interesting"};
    private final static String[] STRINGS5 = {"this", null, "will", "be", "interesting"};

    private final static int[] EMPTY_INTS = {};
    private final static int[] INTS1 = {-1};
    private final static int[] INTS2 = {-1, 2};
    private final static int[] INTS3 = {-1, 2, 8};
    private final static int[] INTS4 = {-1, 2, 8, Integer.MAX_VALUE};

    /**
     * Calls all of the test methods
     * @param ignored Not used
     */
    public static void main(String[] ignored) {
        String description = "ArrayList constructor collection of Strings of size: ";
        test(description + 0, stringConstructor(EMPTY_STRINGS));
        test(description + 1, stringConstructor(STRINGS1));
        test(description + 2, stringConstructor(STRINGS2));
        test(description + 3, stringConstructor(STRINGS3));
        test(description + 4, stringConstructor(STRINGS4));
        test(description + 5, stringConstructor(STRINGS5));

        description = "ArrayList constructor collection of Integers of size: ";
        test(description + 0, intConstructor(EMPTY_INTS));
        test(description + 1, intConstructor(INTS1));
        test(description + 2, intConstructor(INTS2));
        test(description + 3, intConstructor(INTS3));
        test(description + 4, intConstructor(INTS4));

        // use & instead of && to prevent short circuit... run all tests
        if (arrayListTests() & linkedListTests()) {
            System.out.println("All tests passed.");
        }
    }

    private static boolean arrayListTests() {
        String description;
        boolean containsTestPassed;
        boolean indexOfTestPassed;
        List<String> utilList = new java.util.ArrayList<>();
        for(String string : STRINGS5) {
            utilList.add(string);
        }
        List<String> myList = new ArrayList<>(utilList);
        description = "ArrayList contains";
        containsTestPassed = containsTest(myList, utilList);
        test(description, containsTestPassed);
        description = "ArrayList indexOf";
        indexOfTestPassed = indexOfTest(myList, utilList);
        test(description, indexOfTestPassed);
        return containsTestPassed && indexOfTestPassed;
    }

    private static boolean linkedListTests() {
        String description;
        boolean sizeTestPassed;
        boolean containsTestPassed;
        boolean indexOfTestPassed;
        boolean getTestPassed;
        List<String> utilList = new java.util.LinkedList<>();
        for(String string : STRINGS5) {
            utilList.add(string);
        }
        List<String> myList = new LinkedList<>(utilList);
        description = "LinkedList size";
        sizeTestPassed = sizeTest(myList, utilList);
        test(description, sizeTestPassed);
        description = "LinkedList contains";
        containsTestPassed = containsTest(myList, utilList);
        test(description, containsTestPassed);
        description = "LinkedList indexOf";
        indexOfTestPassed = indexOfTest(myList, utilList);
        test(description, indexOfTestPassed);
        description = "LinkedList get";
        getTestPassed = getTest(myList, utilList);
        test(description, getTestPassed);
        return sizeTestPassed && containsTestPassed && indexOfTestPassed && getTestPassed;
    }

    private static boolean containsTest(List<String> myList, Collection<String> utilList) {
        return myList.contains("not found") == utilList.contains("not found") &&
                myList.contains(STRINGS5[0]) == utilList.contains(STRINGS5[0]) &&
                myList.contains(null) == utilList.contains(null) &&
                myList.contains(STRINGS5[STRINGS5.length - 1]) == utilList.contains
                        (STRINGS5[STRINGS5.length - 1]) && myList.contains(3) == utilList.contains(3);
    }

    private static boolean indexOfTest(List<String> myList, List<String> utilList) {
        return myList.indexOf("not found") == utilList.indexOf("not found") &&
                myList.indexOf(STRINGS5[0]) == utilList.indexOf(STRINGS5[0]) &&
                myList.indexOf(null) == utilList.indexOf(null) &&
                myList.indexOf(STRINGS5[STRINGS5.length - 1]) == utilList.indexOf
                        (STRINGS5[STRINGS5.length - 1]) && myList.indexOf(3) == utilList.indexOf(3);
    }

    private static boolean sizeTest(List<String> myList, List<String> utilList) {
        return myList.size() == utilList.size();
    }

    private static boolean getTest(List<String> myList, List<String> utilList) {
        boolean passed;
        try {
            passed = myList.get(0).equals(utilList.get(0)) &&
                    myList.get(STRINGS5.length - 1).equals(utilList.get(STRINGS5.length - 1));
        } catch (Exception e) {
            passed = false;
        }
        return passed;
    }

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

    /**
     * Tests the constructor that accepts a collection of elements.
     * After the ArrayList is instantiated, the size is compared with
     * the size of the collection.
     * @param strings An array of Strings to be added to the ArrayList
     * @return true if test passed
     */
    private static boolean stringConstructor(String[] strings) {
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
    private static boolean intConstructor(int[] numbers) {
        Collection<Integer> input = new java.util.ArrayList<>();
        for(int number : numbers) {
            input.add(number);
        }
        List<Integer> list = new ArrayList<>(input);
        return list.size()==input.size();
    }
}
