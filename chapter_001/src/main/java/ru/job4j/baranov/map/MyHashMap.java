package ru.job4j.baranov.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyHashMap <K, V> implements Iterable<K> {

    private Object[] array = new Object[16];
    private double loadFactor = 0.75;
    private int elements = 0;

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int index = 0;
            Node tmp = null;
            int elementsOnStart = elements;

            @Override
            public boolean hasNext() {
                if (elementsOnStart != elements) {
                    throw new ConcurrentModificationException();
                }
                if (tmp != null) {
                    return true;
                }
                while (index < array.length && (tmp = (Node) array[index++]) == null) {
                }
                return tmp != null;
            }

            @Override
            public K next() {
                if (hasNext()) {
                    K result = tmp.key;
                    tmp = tmp.next;
                    return result;
                }
                throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node (K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public boolean insert(K key, V value){
        boolean result = true;
        int bucket = Math.abs(key.hashCode()) % array.length;
        Node tmp;
        for (tmp = (Node) array[bucket]; tmp != null; tmp = tmp.next) {
            if (key.hashCode() == tmp.key.hashCode() && key.equals(tmp.key)) {
                if (value.equals(tmp.value)) {
                    result = false;
                    break;
                } else {
                    tmp.value = value;
                    break;
                }
            }
        }
        if (tmp == null) {
            array[bucket] = new Node(key, value, (Node) array[bucket]);
            elements++;
        }
        if (elements / array.length > loadFactor) {
            resize();
        }
        return result;
    }

    public V get(K key) {
        int bucket = Math.abs(key.hashCode()) % array.length;
        if (array[bucket] != null) {
            for (Node tmp = (Node) array[bucket]; tmp != null; tmp = tmp.next) {
                if (tmp.key.equals(key)) {
                    return tmp.value;
                }
            }
        }
        return null;
    }

    private void resize() {
        int arraySize = array.length;
        Object[] tmp = array;
        array = new Object[arraySize * 2];
        elements = 0;
        for (int i = 0; i < arraySize; i++) {
            for (Node tmpNode = (Node) tmp[i]; tmpNode != null; tmpNode = tmpNode.next) {
                insert(tmpNode.key, tmpNode.value);
            }
        }
    }


    public int getSize() {
        return elements;
    }


    boolean delete (K key) {
        boolean result = false;
        int bucket = Math.abs(key.hashCode()) % array.length;
        if (array[bucket] != null) {
            Node first = (Node) array[bucket];
            if (first.key.equals(key)){
                array[bucket] = first.next;
                elements--;
            } else {
               for (Node tmp = (Node) array[bucket]; tmp.next != null; tmp = tmp.next) {
                   if (tmp.next.key.equals(key)) {
                      result = true;
                      tmp.next = tmp.next.next;
                      elements--;
                      break;
                   }
               }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
    }
}
