package ru.job4j.baranov.map;

import java.util.Iterator;

public class MyHashMap<K, V> implements Iterable<K> {

    private Object[] array = new Object[16];
    double loadFactor = 0.75;
    int elements = 0;

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int index = 0;
            Node tmp = null;

            @Override
            public boolean hasNext() {
                if (tmp != null) {
                    return true;
                }
                while (index < array.length) {
                    tmp = (Node) array[index++];
                    if (tmp != null) {
                        break;
                    }
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
                return null;
            }
        };
    }

    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public boolean insert(K key, V value) {
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
        Object[] tmp = new Object[arraySize];
        System.arraycopy(array, 0, tmp, 0, array.length);
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


    boolean delete(K key) {
        boolean result = false;
        int bucket = Math.abs(key.hashCode()) % array.length;
        if (array[bucket] != null) {
            Node first = (Node) array[bucket];
            if (first.key.equals(key)) {
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
