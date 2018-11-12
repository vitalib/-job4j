package ru.job4j.baranov.list;

public class SimpleStack<T> extends SimpleLinkedList<T> {
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }
    public void push(T value) {
        add(value);
        size++;
    }

    public T poll() {
        size--;
        return delete();
    }

}
