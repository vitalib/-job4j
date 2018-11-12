package ru.job4j.baranov.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import org.hamcrest.core.IsNull;
import static org.junit.Assert.*;

public class UserStoreTest {

    private UserStore store;
    private final int size = 10;

    @Before
    public void setUp() {
        store = new UserStore(size);
    }

    @Test
    public void canAddUserToStore() {
        String name = "vitali";
        User user = new User(name);

        store.add(user);

        assertThat(store.findById(name), is(user));
    }

    @Test
    public void canReplaceUserInStore() {
        String name1 = "vitali";
        String name2 = "other_name";
        User user = new User(name1);
        User user2 = new User(name2);

        store.add(user);
        store.replace(name1, user2);

        assertThat(store.findById(name1), is(IsNull.nullValue()));
        assertThat(store.findById(name2), is(user2));
    }


    @Test
    public void canDeleteUserInStore() {
        String name1 = "vitali";
        User user = new User(name1);

        store.add(user);
        assertThat(store.findById(name1), is(user));
        store.delete(name1);
        assertThat(store.findById(name1), is(IsNull.nullValue()));
    }

    @Test
    public void doNotReplaceNonExistingUser() {
        assertThat(store.replace("vitali", new User("")), is(false));
    }

}