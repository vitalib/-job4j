package ru.job4j.baranov.iterator;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer> (){
            private Iterator<Integer> current = it.next();

            private boolean currentIsNull() {
                return current == null;
            }

            private void goToNextNonEmptyIterator() {
                while (!currentIsNull() && !current.hasNext()) {
                    try {
                        current = it.next();
                    } catch (NoSuchElementException ex) {
                        current = null;
                    }
                }
            }

            @Override
            public boolean hasNext() {
                goToNextNonEmptyIterator();
                return !currentIsNull() && current.hasNext();
            }

            @Override
            public Integer next() {
                goToNextNonEmptyIterator();
                if (!currentIsNull()) {
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
