package com.willcampbell;

import org.junit.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class UtilitiesTest {
    private Utilities utilities;

    @Before
    public void setup() {
        utilities = new Utilities();
    }

    /**
     * everyNthChar Tests
     */

    @Test
    public void everyNthCharTest() {
        char[] result = utilities.everyNthChar(null, 2);
        assertNull(result);
        result = utilities.everyNthChar("hello".toCharArray(), 2);
        //assertEquals("el", new String(result));
        assertArrayEquals("el".toCharArray(), result);
        result = utilities.everyNthChar("hello".toCharArray(), 6);
        assertArrayEquals("hello".toCharArray(), result);
    }

    /**
     * removePairs Tests
     */
    @Test
    public void removePairsTest() {
        String test1 = utilities.removePairs("AABCDDEFF");
        assertEquals("ABCDEF", test1);
        test1 = utilities.removePairs("ABCCABDEEF");
        assertEquals("ABCABDEF", test1);
        test1 = utilities.removePairs("A");
        assertEquals("A", test1);
        test1 = utilities.removePairs("AAAAAAAAA");
        assertEquals("A", test1);
        test1 = utilities.removePairs(null);
        assertNull(test1);
    }

    /**
     * converter Tests
     */
    @Test
    public void converterTest() {
        int testConverter = utilities.converter(10, 5);
        assertEquals(300, testConverter);
    }

    @Test(expected = ArithmeticException.class)
    public void converterTestException() {
        int testConverter = utilities.converter(10, 0);
    }

    /**
     * nullIfOdd Tests
     */
    @Test
    public void nullIfOddTest() {
        String testNull = utilities.nullIfOddLength("hello");
        assertNull(testNull);
        testNull = utilities.nullIfOddLength("shaper");
        assertEquals("shaper", testNull);
        testNull = utilities.nullIfOddLength(null);
        assertNull(testNull);
    }

}
