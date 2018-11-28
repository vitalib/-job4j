package ru.job4j.baranov.map;

import org.junit.Test;

import java.util.GregorianCalendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void whenInvokeUserConstructorUserObjectIsCreated(){
        User user = new User("name", 0, new GregorianCalendar(1983, 11, 24));
        assertThat(user instanceof User, is(true));
    }

}