package ru.job4j.baranov.list;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class SimpleLinkedListTest {

    private SimpleLinkedList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDeleteReturnFirstElement() {
        int result = list.delete();

        assertThat(result, is(3));
    }


    @Test
    public void whenRunInIterableContextReturnCorrectValue() {
        int value = 3;
        for (int val: list){
            assertEquals(val, value--);
        }
    }

}
