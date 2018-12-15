package ru.job4j.baranov.map;

import org.junit.Ignore;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void whenInvokeUserConstructorUserObjectIsCreated() {
        User user = new User("name", 0, new GregorianCalendar(1983, 11, 24));
        assertThat(user instanceof User, is(true));
    }

    @Test
    @Ignore
    public void whenTwoUsersWithSameFieldsWithouProperHashAndEqualsAreStoredTwiceInMap() {
        User user1 = new User("Vitali", 0, new GregorianCalendar(1983, 11, 24));
        User user2 = new User("Vitali", 0, new GregorianCalendar(1983, 11, 24));

        Map<User, Object> map = new HashMap<>();
        map.put(user1, user1.getName());
        map.put(user2, user2.getName());
        System.out.println(map);
        System.out.println("user1 hashcode = " + user1.hashCode());
        System.out.println("user2 hashcode = " + user2.hashCode());

        assertEquals(map.size(), 2);
        assertNotEquals(user1.hashCode(), user2.hashCode());

    }

    @Test
    @Ignore
    public void whenTwoUsersWithSameFieldsWithProperHashwithouEqualsAreStoredTwiceInMap() {
        User user1 = new User("Vitali", 0, new GregorianCalendar(1983, 11, 24));
        User user2 = new User("Vitali", 0, new GregorianCalendar(1983, 11, 24));

        Map<User, Object> map = new HashMap<>();
        map.put(user1, user1.getName());
        map.put(user2, user2.getName());
        System.out.println(map);
        System.out.println("user1 hashcode = " + user1.hashCode());
        System.out.println("user2 hashcode = " + user2.hashCode());

        assertEquals(map.size(), 2);
        assertEquals(user1.hashCode(), user2.hashCode());
    }

    @Test
    @Ignore
    public void whenTwoUsersWithSameFieldsWithoutProperHashwithProperEqualsAreStoredTwiceInMap() {
        User user1 = new User("Vitali", 0, new GregorianCalendar(1983, 11, 24));
        User user2 = new User("Vitali", 0, new GregorianCalendar(1983, 11, 24));

        Map<User, Object> map = new HashMap<>();
        map.put(user1, user1.getName());
        map.put(user2, user2.getName());
        System.out.println(map);
        System.out.println("user1 hashcode = " + user1.hashCode());
        System.out.println("user2 hashcode = " + user2.hashCode());

        assertEquals(map.size(), 2);
        assertNotEquals(user1.hashCode(), user2.hashCode());
        assertTrue(user1.equals(user2));
    }


    @Test
    public void whenTwoUsersWithSameFieldsWithProperHashandEqualsAreStoredOnceInMap() {
        User user1 = new User("Vitali", 0, new GregorianCalendar(1983, 11, 24));
        User user2 = new User("Vitali", 0, new GregorianCalendar(1983, 11, 24));

        Map<User, Object> map = new HashMap<>();
        map.put(user1, user1.getName());
        map.put(user2, user2.getName());
        System.out.println(map);
        System.out.println("user1 hashcode = " + user1.hashCode());
        System.out.println("user2 hashcode = " + user2.hashCode());

        assertEquals(map.size(), 1);
        assertEquals(user1.hashCode(), user2.hashCode());
        assertTrue(user1.equals(user2));
    }

}