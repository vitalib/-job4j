package ru.job4j.baranov.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DynamicLinkedArray<T> implements Iterable<T> {

    private Node<T> first = null;
    private int modCount = 0;

    class Node<T> {
        public final T data;
        public Node<T> next;

        public Node(T item) {
            data = item;
        }
    }

    public void add(T value) {
        Node<T> newItem = new Node<>(value);
        newItem.next = first;
        first = newItem;
        modCount++;
    }

    public T get(int index) {
        Node<T> tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator() {
            private Node<T> tmp = first;
            private int expectedModCount = modCount;

            private void checkModifications() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override
            public boolean hasNext() {
                checkModifications();
                return tmp == null;
            }

            @Override
            public Object next() {
                checkModifications();
                T item = tmp.data;
                tmp = tmp.next;
                return item;
            }
        };
    }
}
