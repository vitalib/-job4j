package ru.job4j.baranov.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ACycleLinkedListTest {
    private int size;
    private ACycleLinkedList list;
    private ArrayList<Node<Integer>> nodeArrayList;

    @Before
    public void setUp() {
        size = 10;
        list = new ACycleLinkedList();
        nodeArrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            nodeArrayList.add(new Node(i));
        }

        for (int i = size - 2; i >= 0; i--) {
            nodeArrayList.get(i).next = nodeArrayList.get(i + 1);
        }

    }

    @Test
    public void whenNoCycleInLinkedListReturnFalse() {

        assertThat(list.hasCycle(nodeArrayList.get(0)), is(false));

    }

    @Test
    public void whenCycleInLinkedListReturnTrue() {

        nodeArrayList.get(size - 1).next = nodeArrayList.get(size / 2);
        assertThat(list.hasCycle(nodeArrayList.get(0)), is(true));

    }


}