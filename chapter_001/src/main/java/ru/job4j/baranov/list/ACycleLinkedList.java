package ru.job4j.baranov.list;

import java.util.ArrayList;

public class ACycleLinkedList {
    public boolean hasCycle(Node start) {
        Node checker = new Node(null);
        Node tmp = start;
        while (tmp != null) {
            if (tmp.next == checker) {
                return true;
            }
            Node cur = tmp;
            tmp = tmp.next;
            cur.next = checker;
        }
        return false;
    }

    public static void main(String[] args) {
        int size = 10;
        ACycleLinkedList list = new ACycleLinkedList();
        Object[] nodeArray = new Object[size];
        ArrayList<Node<Integer>> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(new Node(i));
        }

        for (int i = size - 2; i >= 0; i--) {
            arrayList.get(i).next = arrayList.get(i + 1);
        }
        arrayList.get(size - 1).next = arrayList.get(size / 2);
        System.out.println(list.hasCycle(arrayList.get(0)));
    }

}

class Node<T> {
    T data;
    public Node<T> next;
    public Node(T data) {
        this.data = data;
    }
}
