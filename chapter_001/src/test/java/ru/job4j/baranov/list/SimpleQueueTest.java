package ru.job4j.baranov.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleQueueTest {

    private SimpleQueue<Integer> simpleQueue;

    @Before
    public void setUp() {
        simpleQueue = new SimpleQueue<>();
    }


    @Test
    public void whenPushItemsPollThemBackInFIFOOrder() {
        for (int i = 0; i < 10; i++) {
            simpleQueue.push(i);
        }
        for (int i = 0; i < 10; i++) {
            assertThat(simpleQueue.poll(), is(i));
        }
    }
}