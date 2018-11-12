package ru.job4j.baranov.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

import static org.junit.Assert.*;

public class SimpleStackTest {
    SimpleStack<Integer> stack;

    @Before
    public void setUp() {
        stack = new SimpleStack<>();
    }


    @Test
    public void whenPushThreeElementsWillReceiveElementsInLIFOOrder() {
        for (int i = 0; i < 3; i++) {
            stack.push(i);
        }
        for (int i = 2; i >= 0; i--) {
            assertThat(stack.poll(), is(i));
        }

    }

}