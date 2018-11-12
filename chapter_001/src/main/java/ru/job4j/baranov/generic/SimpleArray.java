package ru.job4j.baranov.generic;

import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    private T[] a;
    private int n;

    public SimpleArray(int size) {
        a = (T[]) new Object[size];
        n = 0;
    }


    private boolean indexInBounds(int index) {
        return index >= 0 && index < a.length;
    }


    public void add(T model) {
        if (indexInBounds(n)) {
            a[n++] = model;
        } else {
            throw new SimpleArrayOutOfBoundException();
        }

    }

    public int indexOf(T model) {
        for (int i = 0; i < n; i++) {
            if (a[i] == model) {
                return i;
            }
        }
        return -1;
    }

    public void set(int index, T model) {
        if (indexInBounds(index) && index < n) {
            a[index] = model;
        } else {
            throw new SimpleArrayOutOfBoundException();
        }

    }

    public void delete(int index) {
        if (indexInBounds(index) && index < n) {
            if (n > 1) {
                for (int i = index; i < n - 1; i++) {
                    a[i] = a[i + 1];
                }
            }
            n--;
        } else {
            throw new SimpleArrayOutOfBoundException();
        }
    }

    public T get(int index) {
        if (indexInBounds(index) && index < n) {
           return a[index];
        } else {
            throw new SimpleArrayOutOfBoundException();
        }
    }


    public int getSize() {
        return n;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < n;
            }

            @Override
            public Object next() {
                return a[index++];
            }
        };
    }

    public static void main(String[] args) {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(10);
        for (int i = 0; i < 12; i++) {
            simpleArray.add(i);
        }

        for (int i : simpleArray) {
            System.out.println(i);
        }

    }

}

class SimpleArrayOutOfBoundException extends ArrayIndexOutOfBoundsException {

}
