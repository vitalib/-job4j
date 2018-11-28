package ru.job4j.baranov.list;

public class SimpleStack<T> {
    SimpleLinkedList<T> linkedList = new SimpleLinkedList<>();

    public boolean isEmpty() {
        return linkedList.getSize() == 0;
    }
    public void push(T value) {
        linkedList.add(value);
    }

    public T poll() {
        return linkedList.delete();
    }

}
