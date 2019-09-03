package com.example.alm02;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class PersonTest extends Person {

    @Test
    public void testGetFirstName() {
        Person p = new Person("Test", "Testson", 30);
        assertEquals(p.getFirstName().equals("Test"),true);
        assertEquals(p.getFirstName().equals("Testing"),false);
    }

    @Test
    public void testSetFirstName() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        final Person p = new Person();

        p.setFirstName("Test");

        final Field field =p.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(p), "Test");

    }

    @Test
    public void testGetLastName() {
        Person p = new Person("Test", "Testson", 30);
        assertEquals(p.getLastName().equals("Testson"),true);
        assertEquals(p.getLastName().equals("Testing"),false);
    }

    @Test
    public void testSetLastName() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        final Person p = new Person();

        p.setLastName("Testson");

        final Field field =p.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(p), "Testson");

    }

    @Test
    public void testGetAge() {
        Person p = new Person("Test", "Testson", 30);
        assertEquals(p.getAge()==30,true);
        assertEquals(p.getAge()== 40,false);
    }

    @Test
    public void testSetAge() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
            final Person p = new Person();

            p.setAge(30);

            final Field field =p.getClass().getDeclaredField("age");
            field.setAccessible(true);
            assertEquals("Fields didn't match", field.get(p), 30);


    }
}