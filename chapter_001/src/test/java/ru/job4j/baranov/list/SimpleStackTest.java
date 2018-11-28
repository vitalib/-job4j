package ru.job4j.baranov.list;

import org.junit.Test;


import static org.junit.Assert.*;

public class SimpleStackTest {

    @Test
    public void whenPushThreeElementsWillReceiveElementsInLIFOOrder() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);

        int value = simpleStack.poll();
        assertEquals(value, 3);

        value = simpleStack.poll();
        assertEquals(value, 2);

        value = simpleStack.poll();
        assertEquals(value, 1);

    }

}
