package ru.job4j.baranov.list;

public class SimpleQueue<T> {
    private SimpleStack<T> pushStack = new SimpleStack<>();
    private SimpleStack<T> pollStack = new SimpleStack<>();

    public void push(T item) {
        pushStack.push(item);
    }

    public T poll() {
        if (pollStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                pollStack.push(pushStack.poll());
            }
        }
        return pollStack.poll();
    }
}
