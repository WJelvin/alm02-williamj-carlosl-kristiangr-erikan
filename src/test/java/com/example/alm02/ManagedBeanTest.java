package com.example.alm02;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class ManagedBeanTest extends ManagedBean {

    /*
    @Test
    public void testCalculateFortune() {
    }
    */


    @Test
    public void testGetFirstName() {
    ManagedBean mb = new ManagedBean("Test", "Testson", 30);
        assertEquals(mb.getFirstName().equals("Test"),true);
        assertEquals(mb.getFirstName().equals("Testing"),false);
    }

    @Test
    public void testSetFirstName() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        final ManagedBean mb = new ManagedBean();

        mb.setFirstName("Test");

        final Field field = mb.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(mb), "Test");

    }


    @Test
    public void testGetLastName() {
        ManagedBean mb = new ManagedBean("Test", "Testson", 30);
        assertEquals(mb.getLastName().equals("Testson"),true);
        assertEquals(mb.getLastName().equals("Testing"),false);
    }

    @Test
    public void testSetLastName() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        final ManagedBean mb = new ManagedBean();

        mb.setLastName("Testson");

        final Field field = mb.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(mb), "Testson");

    }

    @Test
    public void testGetAge() {
        ManagedBean mb = new ManagedBean("Test", "Testson", 30);
        assertEquals(mb.getAge()==30,true);
        assertEquals(mb.getAge()== 20,false);
    }

    @Test
    public void testSetAge() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        final ManagedBean mb = new ManagedBean();

        mb.setAge(30);

        final Field field = mb.getClass().getDeclaredField("age");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(mb), 30);
    }
    /*
    @Test
    public void testGetFortune() {
    }

    @Test
    public void testSetFortune() {
    }
    */

}