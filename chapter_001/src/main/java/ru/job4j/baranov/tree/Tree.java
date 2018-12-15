package ru.job4j.baranov.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int elements;


    public Tree(E value) {
        this.root = new Node(value);
        elements = 0;
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> optionalParent = findBy(parent);
        if (optionalParent.isPresent()) {
            elements++;
            Node<E> nodeParent = optionalParent.get();
            nodeParent.add(new Node(child));
        }
        return optionalParent.isPresent();
    }
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Queue<Node<E>> nodes = new LinkedList<>();
            final int elementsIter = elements;
            {
                nodes.offer(root);
            }

            @Override
            public boolean hasNext() {
                if (elementsIter == 0) {
                    return false;
                }
                if (elements != elementsIter) {
                    throw new ConcurrentModificationException();
                }
                return nodes.size() != 0;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    Node<E> curNode = nodes.poll();
                    nodes.addAll(curNode.leaves());
                    return curNode.getValue();
                }
                throw new NoSuchElementException();
            }
        };
    }

    public boolean isBinary() {
        return recursiveIsBinary(root);
    }

    private boolean recursiveIsBinary(Node<E> node) {
        if (node.leaves().size() > 2) {
            return false;
        }
        for (Node<E> child : node.leaves()) {
            if (!recursiveIsBinary(child)) {
                return false;
            }
        }
        return true;
    }
}
