package ru.job4j.baranov.tree;

import java.util.Optional;

public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * Add element child to parent
     * Parent may have list of childs
     * @param parent parent
     * @param child child.
     * @return
     */
    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);

}
