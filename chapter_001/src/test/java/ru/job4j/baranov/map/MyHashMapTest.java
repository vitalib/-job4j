package ru.job4j.baranov.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {

    @Test
    public void whenInsertOnePairSizeEqualsOne() {
        MyHashMap<Integer, Integer> map = new MyHashMap();
        map.insert(5, 5);
        assertEquals(1, map.getSize());
    }

    @Test
    public void whenInsertOnePairGetSameValueBack() {
        MyHashMap<Integer, Integer> map = new MyHashMap();
        map.insert(5, 5);
        assertEquals(new Integer(5), map.get(5));
    }

    @Test
    public void whenInsertOnePairThenDeleteItThenSizeEqualNull() {
        MyHashMap<Integer, Integer> map = new MyHashMap();
        map.insert(5, 5);
        map.delete(5);
        assertEquals(0, map.getSize());
    }


    @Test
    public void whenInsertThirtySizeIsThirty() {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();

        for (int i = 0; i < 30; i++) {
            map.insert(i, i);
        }
        assertEquals(30, map.getSize());
    }


    @Test
    public void whenInsertTwoValueCanIterateOnThem() {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();
        boolean[] test = {false, false};
        map.insert(0, 0);
        map.insert(1, 1);

        int count = 0;
        for (Integer key: map) {
            test[map.get(key)] = true;
            count++;
        }
        assertEquals(2, count);
        assertTrue(test[0]);
        assertTrue(test[1]);

    }

    @Test
    public void whenInsertManyValuesAndDeleteAllOfThemSizeEqualsZero() {
        MyHashMap<Integer, Integer> map = new MyHashMap<>();
        int n = 1000000;
        for (int i = 0; i < n; i++) {
            map.insert(i, i);
        }
        assertEquals(n, map.getSize());
        for (int i = 0; i < n; i++) {
            map.delete(i);
        }
        assertEquals(0, map.getSize());

    }

    @Test
    public void whenInsertSameKeyValueTwiceSizeIsOne() {
        MyHashMap<String, String> map = new MyHashMap<>();

        map.insert("vitali", "baranov");
        map.insert("vitali", "baranov");

        assertEquals(1, map.getSize());
    }


}