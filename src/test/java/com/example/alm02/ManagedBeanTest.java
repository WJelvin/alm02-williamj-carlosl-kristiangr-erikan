package com.example.alm02;

import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class ManagedBeanTest extends ManagedBean {


    @Test
    public void testCalculateFortune() {
        ManagedBean mb = new ManagedBean("Urban", "Andersson", 36);
        mb.setRandomNumber(1);
        Translator t = new Translator(mb.getFirstName(), mb.getLastName(), mb.getAge(), mb.getRandomNumber());
        String fortune = t.predictFuture();
        System.out.println(fortune);

        assertEquals(fortune.equals("This sentenced has a random number that is less than 3. Same rating we give you!"), true);
        assertEquals(fortune.equals("Blaaaaah"), false);
        mb.setRandomNumber(4);
        fortune = t.predictFuture();
        System.out.println(fortune);
        assertEquals(fortune.equals("Your life is void, it is."), true);
    }

    @Test
    public void testSetFortune() {
        ManagedBean mb = new ManagedBean("Urban", "Anderson", 37);
        int fakeRandomNumber = 7;
        Translator translator = new Translator(mb.getFirstName(), mb.getLastName(), mb.getAge(), fakeRandomNumber);
        String fortune = translator.predictFuture();
        assertEquals(fortune, "Your life is void, it is.");
    }



    /*
    @Test
    public void testGetFortune() {
        ManagedBean mb = new ManagedBean("Bob", "Johnson", 49);
        Translator translator = new Translator();
        int number = 10;
        mb.setFortune(translator.predictFuture(mb.getFirstName(), mb.getLastName(), mb.getAge(), number));
        assertEquals("Your life is void, it is.", mb.getFortune());
    }

     */

    @Test
    public void testGetFirstName() {
        ManagedBean mb = new ManagedBean("Test", "Testson", 30);
        assertEquals(mb.getFirstName().equals("Test"), true);
        assertEquals(mb.getFirstName().equals("Testing"), false);
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
        assertEquals(mb.getLastName().equals("Testson"), true);
        assertEquals(mb.getLastName().equals("Testing"), false);
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
        assertEquals(mb.getAge() == 30, true);
        assertEquals(mb.getAge() == 20, false);
    }

    @Test
    public void testSetAge() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        final ManagedBean mb = new ManagedBean();

        mb.setAge(30);

        final Field field = mb.getClass().getDeclaredField("age");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(mb), 30);
    }

    @Test
    public void testGetRandomNumber() {
        ManagedBean mb = new ManagedBean("Test", "Testson", 30);
        mb.setRandomNumber(1);
        assertEquals(mb.getRandomNumber() == 1, true);
        assertEquals(mb.getRandomNumber() == 20, false);
    }

    @Test
    public void testSetRandomNumber() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        final ManagedBean mb = new ManagedBean();

        mb.setRandomNumber(1);

        final Field field = mb.getClass().getDeclaredField("randomNumber");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(mb), 1);
    }

    @Test
    public void testGetTranslator() {
        ManagedBean mb = new ManagedBean("Test", "Testson", 30);
        Translator t = new Translator();
        Translator tFalse = new Translator();

        mb.setTranslator(t);

        assertEquals(mb.getTranslator().equals(t), true);
        assertEquals(mb.getTranslator().equals(tFalse), false);
    }

    @Test
    public void testSetTranslator() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        final ManagedBean mb = new ManagedBean();
        Translator t = new Translator();

        mb.setTranslator(t);

        final Field field = mb.getClass().getDeclaredField("translator");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(mb), t);

    }

    @Test
    public void testGetRandomFactor() {
        ManagedBean mb = new ManagedBean("Test", "Testson", 30);
        RandomFactor rF = new RandomFactor();
        RandomFactor rFFalse= new RandomFactor();

        mb.setRandomFactor(rF);

        assertEquals(mb.getRandomFactor().equals(rF), true);
        assertEquals(mb.getRandomFactor().equals(rFFalse), false);
    }

    @Test
    public void testSetRandomFactor() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        final ManagedBean mb = new ManagedBean();
        RandomFactor rF = new RandomFactor();

        mb.setRandomFactor(rF);

        final Field field = mb.getClass().getDeclaredField("randomFactor");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(mb), rF);

    }
}
