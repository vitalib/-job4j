package ru.job4j.baranov.list;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class SimpleQueueTest {

    @Test
    public void whenPushItemsPollThemBackInFIFOOrder() {
        SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();
        for (int i = 0; i < 10; i++) {
            simpleQueue.push(i);
        }
        for (int i = 0; i < 10; i++) {
            assertThat(simpleQueue.poll(), is(i));
        }
    }
}