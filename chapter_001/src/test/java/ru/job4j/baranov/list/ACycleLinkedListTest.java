package ru.job4j.baranov.list;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ACycleLinkedListTest {


    @Test
    public void whenNoCycleInLinkedListReturnFalse() {
        int size = 10;
        ACycleLinkedList list = new ACycleLinkedList();
        ArrayList<Node<Integer>> nodeArrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            nodeArrayList.add(new Node(i));
        }

        for (int i = size - 2; i >= 0; i--) {
            nodeArrayList.get(i).next = nodeArrayList.get(i + 1);
        }

        assertThat(list.hasCycle(nodeArrayList.get(0)), is(false));

    }

    @Test
    public void whenCycleInLinkedListReturnTrue() {
        int size = 10;
        ACycleLinkedList list = new ACycleLinkedList();
        ArrayList<Node<Integer>> nodeArrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            nodeArrayList.add(new Node(i));
        }

        for (int i = size - 2; i >= 0; i--) {
            nodeArrayList.get(i).next = nodeArrayList.get(i + 1);
        }


        nodeArrayList.get(size - 1).next = nodeArrayList.get(size / 2);
        assertThat(list.hasCycle(nodeArrayList.get(0)), is(true));

    }


}
