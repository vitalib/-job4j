package ru.job4j.baranov.generic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleArrayTest {
    private final int size = 10;
    private SimpleArray<Integer> simpleArray;

    @Before
    public void setUp() {
        simpleArray = new SimpleArray<>(size);
    }

    @Test
    public void whenAddOneCanFethOne() {
        simpleArray.add(5);

        int result = simpleArray.get(0);

        assertThat(result, is(5));
    }

    @Test
    public void whenAddMultipleCanFetchMultiple() {
        for (int i = 0; i < size; i++) {
            simpleArray.add(i);
        }

        for (int i = 0; i < size; i++) {
            assertThat(simpleArray.get(i), is(i));
        }
    }

    @Test
    public void whenAddOneCanDeleteOne() {
        simpleArray.add(0);
        simpleArray.delete(0);

        assertThat(simpleArray.getSize(), is(0));

    }

    @Test
    public void whenAddTwoAndDeleteLastWillGetFirst() {
        simpleArray.add(0);
        simpleArray.add(1);

        simpleArray.delete(1);

        assertThat(simpleArray.get(0), is(0));
    }

    @Test
    public void whenAddTwoAndDeleteFirstWillGetLast() {
        simpleArray.add(0);
        simpleArray.add(1);

        simpleArray.delete(0);

        assertThat(simpleArray.get(0), is(1));
    }

    @Test
    public void whenSetValueThePreviousValueIsModified() {
        simpleArray.add(0);
        simpleArray.set(0, 5);

        assertThat(simpleArray.get(0), is(5));
    }


    @Test
    public void iteratorTest() {
        for (int i = 0; i < 10; i++) {
            simpleArray.add(i);
        }
        int i = 0;
        for (int item : simpleArray) {
            assertThat(item, is(simpleArray.get(i++)));
        }
    }


    @Test(expected = SimpleArrayOutOfBoundException.class)
    public void testIndexOutOfBoundsExceptionWhenGetFromEmptyList() {
        simpleArray.get(0);
    }

    @Test(expected = SimpleArrayOutOfBoundException.class)
    public void testIndexOutOfBoundsExceptionWhenGetFromNonEmptyList() {
        simpleArray.add(5);
        simpleArray.get(1);
    }

    @Test(expected = SimpleArrayOutOfBoundException.class)
    public void testIndexOutOfBoundsExceptionWhenDeleteBeforeEnter() {
        simpleArray.delete(0);
    }

}