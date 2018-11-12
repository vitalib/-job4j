package ru.job4j.baranov.list;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

public class DynamicArrayTest {

    private DynamicArray<Integer> dynamicArray;

    @Before
    public void setUp() {
        dynamicArray = new DynamicArray<>();
        for (int i = 0; i < 10; i++) {
            dynamicArray.add(i);
        }
    }


    @Test
    public void whenAddElementThenCanReceiveItBack() {
        for (int i = 0; i < 10; i++) {
            assertThat(dynamicArray.get(i), is(i));
        }
    }


    @Test
    public void whenRunIterationThenReceiveAllItemOfArray() {
        int i = 0;
        for (int item : dynamicArray) {
            assertThat(item, is(i++));
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddElementDuringIterationThanRaiseException() {
        for (int item : dynamicArray) {
            dynamicArray.add(0);
        }
    }


}