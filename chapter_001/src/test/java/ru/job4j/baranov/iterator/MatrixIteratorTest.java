package ru.job4j.baranov.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test.
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */

public class MatrixIteratorTest {
    /**
     * Test echo
     */
    public static final class ForEachArray implements Iterable<Integer> {
        private final int[][] arr;

        public ForEachArray(int[][] arr) {
            this.arr = arr;
        }
        @Override
        public Iterator<Integer> iterator() {
            return new MatrixIterator(arr);
        }
    }
    @Test
    public void whenInnerArraysHasEqualLengthSequantialShowReturnSequantial() {
        int[][] testArray = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<Integer> result = new ArrayList<>();

        ForEachArray forEachArray = new ForEachArray(testArray);
        for (int item : forEachArray) {
            result.add(item);
        }

        assertThat(result.toArray(new Integer[result.size()]), is(expectedOutput));
    }

    @Test
    public void whenInnerArraysHasDifLengthSequantialShowReturnSequantial() {
        int[][] testArray = {{1, 2}, {3, 4, 5, 6}, {7, 8}, {9, 10}};
        int[] expectedOutput = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayList<Integer> result = new ArrayList<>();

        ForEachArray forEachArray = new ForEachArray(testArray);
        for (int item : forEachArray) {
            result.add(item);
        }

        assertThat(result.toArray(new Integer[result.size()]), is(expectedOutput));
    }

    @Test
    public void whenInnerArraysHasEmptyLengthSequantialNoElementsAreReturned() {
        int[][] testArray = {{}, {}, {}, {}};
        ArrayList<Integer> result = new ArrayList<>();

        ForEachArray forEachArray = new ForEachArray(testArray);
        for (int item : forEachArray) {
            result.add(item);
        }


        assertThat(result.size(), is(0));
    }
}


