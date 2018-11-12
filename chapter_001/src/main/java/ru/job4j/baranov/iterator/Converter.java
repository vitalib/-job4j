package ru.job4j.baranov.iterator;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Integer> current = it.next();

            private boolean currentIsNull() {
                return current == null;
            }

            private boolean hasNonEmptyIterator() {
                boolean currentIteratorIsNotEmpty = current.hasNext();
                while (!currentIteratorIsNotEmpty) {
                    if (it.hasNext()) {
                        current = it.next();
                        currentIteratorIsNotEmpty = current.hasNext();
                    } else {
                        break;
                    }
                }
                return currentIteratorIsNotEmpty;
            }

            @Override
            public boolean hasNext() {
                return hasNonEmptyIterator();
            }

            @Override
            public Integer next() {
                if (hasNonEmptyIterator()) {
                    return current.next();
                } else {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
