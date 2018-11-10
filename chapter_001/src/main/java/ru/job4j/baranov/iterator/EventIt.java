package ru.job4j.baranov.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EventIt implements Iterator<Integer> {
    private final int[][] arr;
    private int i, j;

    public EventIt(int[][] arr) {
        this.arr = arr;
        i = 0;
        j = 0;
    }

    private int[] findNextEven() {
        int jCopy = j;
        for (int k = i; k < arr.length; k++) {
            for (int l = jCopy; l < arr[k].length; l++) {
                if (arr[k][l] % 2 == 0) {
                    return new int[]{k, l};
                }
            }
            jCopy = 0;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return findNextEven() != null;
    }

    @Override
    public Integer next() {
        int[] indexes = findNextEven();
        if (indexes == null) {
            throw new NoSuchElementException();
        }
        i = indexes[0];
        j = indexes[1];
        Integer item = arr[i][j++];
        if (j >= arr[i].length) {
            i++;
            j = 0;
        }
        return item;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
