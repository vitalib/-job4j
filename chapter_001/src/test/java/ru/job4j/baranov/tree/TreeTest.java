package ru.job4j.baranov.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6).isPresent(),
                is(true));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }
    @Test
    public void when6ElFindLastThen6Iterate() {
        Tree<Integer> tree = new Tree<>(1);
        List<Integer> initValues = Arrays.asList(1, 2, 3, 4, 5, 6);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        List<Integer> results = new ArrayList<>();
        for (Integer i: tree) {
            results.add(i);
        }
        assertEquals(results, initValues);
    }

    @Test
    public void whenBinaryTreeCreatedReturnIsBinaryTrue() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(2, 5);
        tree.add(5, 6);
        assertEquals(tree.isBinary(), true);
    }
        @Test
    public void whenNonBinaryTreeCreatedReturnIsBinaryFalse() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(2, 4);
        tree.add(2, 5);
        tree.add(5, 6);
        tree.add(5, 7);
        tree.add(5, 8);
        assertEquals(tree.isBinary(), false);
    }
}