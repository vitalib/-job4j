package ru.job4j.baranov.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {
    private final int initialSize = 10;
    private T[] arr = (T[]) new Object[initialSize];
    private int n = 0;
    private int modCount = 0;

    private void resize(int newSize) {
        T[] tmpArr = (T[]) new Object[newSize];
        for (int i = 0; i < n; i++) {
            tmpArr[i] = arr[i];
        }
        arr = tmpArr;
        modCount++;
    }

    public void add(T value) {
        arr[n++] = value;
        if (n == arr.length) {
            resize(2 * n);
        }
    }

    public T get(int index) {
        return arr[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            private int expectedModCount = modCount;
            private int ind = 0;

            void checkModifications() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public boolean hasNext() {
                checkModifications();
                return ind < n;
            }

            @Override
            public Object next() {
                return arr[ind++];
            }
        };
    }
}
