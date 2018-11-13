package ru.job4j.baranov.list;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.baranov.generic.SimpleArrayOutOfBoundException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class SimpleSetTest {
    private final int size = 10;
    private SimpleSet<Integer> simpleSet;

    @Before
    public void setUp() {
        simpleSet = new SimpleSet<>(size);
    }

    @Test
    public void whenAddOneCanFethOne() {
        simpleSet.add(5);

        for (Integer i : simpleSet) {
            assertThat(i, is(5));
        }

    }

    @Test
    public void whenAddTwoEqualValuesOnlyOneIsAdded() {
        simpleSet.add(5);
        simpleSet.add(5);

        for (Integer i : simpleSet) {
            assertThat(i, is(5));
        }
    }

    @Test
    public void whenAddTenDifferentTwiceOnlyTenDifferentAreStored() {
        Integer[] arr = new Integer[size];
        Boolean[] visited = new Boolean[size];

        for (int i = 0; i < size; i++) {
            simpleSet.add(i);
            simpleSet.add(i);
            visited[i] = false;
        }
        for (Integer i : simpleSet) {
            assertThat(visited[i], is(false));
            visited[i] = true;
        }
        for (int i = 0; i < size; i++) {
            assertThat(visited[i], is(true));
        }
        for (Integer i : simpleSet) {
            assertThat(visited[i], is(true));
        }
    }
}

