package ru.job4j.baranov.list;

import ru.job4j.baranov.generic.SimpleList;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleList<T> simpleList;

    public SimpleSet(int size) {
        simpleList = new SimpleList<>(size);
    }

    public void add(T item) {
       int index = simpleList.indexOf(item);
       if (index < 0) {
           simpleList.add(item);
       }
    }

    @Override
    public Iterator<T> iterator() {
        return simpleList.iterator();
    }
}
