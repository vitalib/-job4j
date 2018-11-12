package ru.job4j.baranov.generic;

public class UserStore extends AbstractStore<User> {
    public UserStore(int size) {
        super(size);
        System.out.println("User store is created");
    }
}
