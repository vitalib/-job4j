package ru.job4j.baranov.iterator;

import java.util.Iterator;

public class MatrixIterator implements Iterator<Integer> {
    private int[][] arr;
    private int i, j;

    public MatrixIterator(int[][] arr) {
        this.arr = arr;
        i = 0;
        j = 0;
    }

    @Override
    public boolean hasNext() {
        return i < arr.length && j < arr[i].length;
    }

    @Override
    public Integer next() {
        Integer item = arr[i][j++];
        if (j >= arr[i].length) {
            i++;
            j = 0;
        }
        return item;
    }
}
