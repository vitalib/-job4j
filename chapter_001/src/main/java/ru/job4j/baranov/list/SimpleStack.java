package ru.job4j.baranov.list;

public class SimpleStack<T> extends SimpleLinkedList<T> {
    public void push(T value) {
        add(value);
    }

    public T poll() {
        return delete();
    }

}
