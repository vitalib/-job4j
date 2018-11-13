package ru.job4j.baranov.generic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleListTest {
    private final int size = 10;
    private SimpleList<Integer> simpleList;

    @Before
    public void setUp() {
        simpleList = new SimpleList<>(size);
    }

    @Test
    public void whenAddOneCanFethOne() {
        simpleList.add(5);

        int result = simpleList.get(0);

        assertThat(result, is(5));
    }

    @Test
    public void whenAddMultipleCanFetchMultiple() {
        for (int i = 0; i < size; i++) {
            simpleList.add(i);
        }

        for (int i = 0; i < size; i++) {
            assertThat(simpleList.get(i), is(i));
        }
    }

    @Test
    public void whenAddOneCanDeleteOne() {
        simpleList.add(0);
        simpleList.delete(0);

        assertThat(simpleList.getSize(), is(0));

    }

    @Test
    public void whenAddTwoAndDeleteLastWillGetFirst() {
        simpleList.add(0);
        simpleList.add(1);

        simpleList.delete(1);

        assertThat(simpleList.get(0), is(0));
    }

    @Test
    public void whenAddTwoAndDeleteFirstWillGetLast() {
        simpleList.add(0);
        simpleList.add(1);

        simpleList.delete(0);

        assertThat(simpleList.get(0), is(1));
    }

    @Test
    public void whenSetValueThePreviousValueIsModified() {
        simpleList.add(0);
        simpleList.set(0, 5);

        assertThat(simpleList.get(0), is(5));
    }


    @Test
    public void iteratorTest() {
        for (int i = 0; i < 10; i++) {
            simpleList.add(i);
        }
        int i = 0;
        for (int item : simpleList) {
            assertThat(item, is(simpleList.get(i++)));
        }
    }


    @Test(expected = SimpleArrayOutOfBoundException.class)
    public void testIndexOutOfBoundsExceptionWhenGetFromEmptyList() {
        simpleList.get(0);
    }

    @Test(expected = SimpleArrayOutOfBoundException.class)
    public void testIndexOutOfBoundsExceptionWhenGetFromNonEmptyList() {
        simpleList.add(5);
        simpleList.get(1);
    }

    @Test(expected = SimpleArrayOutOfBoundException.class)
    public void testIndexOutOfBoundsExceptionWhenDeleteBeforeEnter() {
        simpleList.delete(0);
    }

}