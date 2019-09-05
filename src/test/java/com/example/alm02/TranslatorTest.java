package com.example.alm02;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TranslatorTest extends Translator {

    private List<String> goodFortunes = new ArrayList<>();
    private List<String> badFortunes = new ArrayList<>();
    private List<String> neutralFortunes = new ArrayList<>();
    private int factor = 0;

    public TranslatorTest() {

        goodFortunes.add("Stop eating now. Food poisoning no fun.");
        goodFortunes.add("Flattery will go far tonight.");
        goodFortunes.add("It could be better, but it's good enough.");
        goodFortunes.add("You love Chinese food.");
        goodFortunes.add("You will receive a fortune cookie.");
        goodFortunes.add("You are not illiterate.");
        goodFortunes.add("Never forget a friend. Especially if he owes you.");

        badFortunes.add("He who laughs last is laughing at you.");
        badFortunes.add("If you look back, you'll soon be going that way.");
        badFortunes.add("Fortune not found? Abort, Retry, Ignore.");
        badFortunes.add("Help! I am being held prisoner in a fortune cookie factory.");
        badFortunes.add("Some fortune cookies contain no fortune.");
        badFortunes.add("You will be hungry again in one hour.");
        badFortunes.add("The fortune you seek is in another cookie.");

        neutralFortunes.add("Do not mistake temptation for opportunity.");
        neutralFortunes.add("Some men dream of fortunes, others dream of cookies.");
        neutralFortunes.add("You have rice in your teeth.");
        neutralFortunes.add("If a turtle doesn't have a shell, is it naked or homeless?");
        neutralFortunes.add("Hard work pays off in the future. Laziness pays off now.");
        neutralFortunes.add("Ask your mom instead of a cookie.");
        neutralFortunes.add("He who laughs at himself never runs out of things to laugh at.");
    }

    @Test
    public void testCalculateFirstNameFactor() {
        Translator t1 = new Translator("ATest", "Testson", 30, 9);
        Translator t2 = new Translator("GTest", "Testson", 30, 9);
        Translator t3 = new Translator("HTest", "Testson", 30, 9);
        Translator t4 = new Translator("OTest", "Testson", 30, 9);
        Translator t5 = new Translator("PTest", "Testson", 30, 9);
        Translator t6 = new Translator("ÖTest", "Testson", 30, 9);

        assertEquals(t1.calculateFirstNameFactor() == 1, true);
        assertEquals(t2.calculateFirstNameFactor() == 1, true);
        assertEquals(t3.calculateFirstNameFactor() == 2, true);
        assertEquals(t4.calculateFirstNameFactor() == 2, true);
        assertEquals(t5.calculateFirstNameFactor() == 3, true);
        assertEquals(t6.calculateFirstNameFactor() == 3, true);

        assertEquals(t1.calculateFirstNameFactor() == 2, false);
        assertEquals(t2.calculateFirstNameFactor() == 2, false);
        assertEquals(t3.calculateFirstNameFactor() == 3, false);
        assertEquals(t4.calculateFirstNameFactor() == 3, false);
        assertEquals(t5.calculateFirstNameFactor() == 1, false);
        assertEquals(t6.calculateFirstNameFactor() == 1, false);

    }

    @Test
    public void testCalculateLastNameFactor() {
        Translator t1 = new Translator("ATest", "ATestson", 30, 9);
        Translator t2 = new Translator("GTest", "GTestson", 30, 9);
        Translator t3 = new Translator("HTest", "HTestson", 30, 9);
        Translator t4 = new Translator("OTest", "OTestson", 30, 9);
        Translator t5 = new Translator("PTest", "PTestson", 30, 9);
        Translator t6 = new Translator("ÖTest", "ÖTestson", 30, 9);

        assertEquals(t1.calculateLastNameFactor() == 3, true);
        assertEquals(t2.calculateLastNameFactor() == 3, true);
        assertEquals(t3.calculateLastNameFactor() == 2, true);
        assertEquals(t4.calculateLastNameFactor() == 2, true);
        assertEquals(t5.calculateLastNameFactor() == 1, true);
        assertEquals(t6.calculateLastNameFactor() == 1, true);

        assertEquals(t1.calculateLastNameFactor() == 1, false);
        assertEquals(t2.calculateLastNameFactor() == 1, false);
        assertEquals(t3.calculateLastNameFactor() == 3, false);
        assertEquals(t4.calculateLastNameFactor() == 3, false);
        assertEquals(t5.calculateLastNameFactor() == 2, false);
        assertEquals(t6.calculateLastNameFactor() == 2, false);
        assertEquals(t5.calculateLastNameFactor() == 3, false);
        assertEquals(t6.calculateLastNameFactor() == 3, false);
    }

    @Test
    public void testCalculateAgeFactor() {
        Translator t1 = new Translator("ATest", "ATestson", 5, 9);
        Translator t2 = new Translator("GTest", "GTestson", 9, 9);
        Translator t3 = new Translator("HTest", "HTestson", 10, 9);
        Translator t4 = new Translator("OTest", "OTestson", 32, 9);
        Translator t5 = new Translator("PTest", "PTestson", 33, 9);
        Translator t6 = new Translator("ÖTest", "ÖTestson", 100, 9);

        assertEquals(t1.calculateAgeFactor() == 0, true);
        assertEquals(t1.calculateAgeFactor() == 1, false);
        assertEquals(t2.calculateAgeFactor() == 0, true);
        assertEquals(t2.calculateAgeFactor() == 23, false);
        assertEquals(t3.calculateAgeFactor() == 1, true);
        assertEquals(t3.calculateAgeFactor() == 0, false);
        assertEquals(t4.calculateAgeFactor() == 1, true);
        assertEquals(t4.calculateAgeFactor() == 23, false);
        assertEquals(t5.calculateAgeFactor() == 2, true);
        assertEquals(t5.calculateAgeFactor() == 1, false);
        assertEquals(t6.calculateAgeFactor() == 50, true);
        assertEquals(t6.calculateAgeFactor() == 23, false);

    }

    @Test
    public void testDecideFortuneType() {
        Translator t1 = new Translator("ATest", "ATestson", 5, 6);
        Translator t2 = new Translator("GTest", "GTestson", 9, 7);
        Translator t3 = new Translator("HTest", "HTestson", 10, 7);
        Translator t4 = new Translator("OTest", "OTestson", 32, 6);
        Translator t5 = new Translator("PTest", "PTestson", 33, 20);
        Translator t6 = new Translator("ÖTest", "ÖTestson", 100, 21);
        factor = 0;
        // < 7 == good (1), >= 7 && < 21 == neutral (2), bad (3)
        assertEquals(t1.decideFortuneType() == 1, true);
        assertEquals(t2.decideFortuneType() == 1, false);
        assertEquals(t3.decideFortuneType() == 2, true);
        assertEquals(t4.decideFortuneType() == 2, false);
        assertEquals(t5.decideFortuneType() == 2, true);
        assertEquals(t6.decideFortuneType() == 2, false);
        assertEquals(t6.decideFortuneType() == 3, true);

    }

    @Test
    public void testReadFortune() {
        Translator t1 = new Translator("ATest", "ATestson", 5, 0);
        Translator t2 = new Translator("GTest", "GTestson", 9, 6);
        Translator t3 = new Translator("HTest", "HTestson", 10, 7);
        Translator t4 = new Translator("OTest", "OTestson", 32, 8);

        assertEquals(t1.readFortune(goodFortunes), "Stop eating now. Food poisoning no fun.");
        assertEquals(t2.readFortune(goodFortunes), "Never forget a friend. Especially if he owes you.");
        assertEquals(t3.readFortune(goodFortunes), "Stop eating now. Food poisoning no fun.");
        assertEquals(t4.readFortune(goodFortunes), "Flattery will go far tonight.");

        assertEquals(t1.readFortune(badFortunes), "He who laughs last is laughing at you.");
        assertEquals(t2.readFortune(badFortunes), "The fortune you seek is in another cookie.");
        assertEquals(t3.readFortune(badFortunes), "He who laughs last is laughing at you.");
        assertEquals(t4.readFortune(badFortunes), "If you look back, you'll soon be going that way.");

        assertEquals(t1.readFortune(neutralFortunes), "Do not mistake temptation for opportunity.");
        assertEquals(t2.readFortune(neutralFortunes), "He who laughs at himself never runs out of things to laugh at.");
        assertEquals(t3.readFortune(neutralFortunes), "Do not mistake temptation for opportunity.");
        assertEquals(t4.readFortune(neutralFortunes), "Some men dream of fortunes, others dream of cookies.");

    }

    @Test
    public void testGetFirstName() {
        Translator t = new Translator("Test", "Testson", 30, 0);
        assertEquals(t.getFirstName().equals("Test"), true);
        assertEquals(t.getFirstName().equals("Testing"), false);
    }

    @Test
    public void testSetFirstName() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        final Translator t = new Translator();

        t.setFirstName("Test");

        final Field field = t.getClass().getDeclaredField("firstName");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(t), "Test");

    }

    @Test
    public void testGetLastName() {
        Translator t = new Translator("Test", "Testson", 30, 0);
        assertEquals(t.getLastName().equals("Testson"), true);
        assertEquals(t.getLastName().equals("Testing"), false);
    }

    @Test
    public void testSetLastName() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        final Translator t = new Translator();

        t.setLastName("Testson");

        final Field field = t.getClass().getDeclaredField("lastName");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(t), "Testson");

    }

    @Test
    public void testGetAge() {
        Translator t = new Translator("Test", "Testson", 30, 0);
        assertEquals(t.getAge() == 30, true);
        assertEquals(t.getAge() == 40, false);
    }

    @Test
    public void testSetAge() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        final Translator t = new Translator();

        t.setAge(30);

        final Field field = t.getClass().getDeclaredField("age");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(t), 30);

    }

    @Test
    public void testGetFactor() {
        Translator t = new Translator("Test", "Testson", 30, 0);
        assertEquals(t.getFactor() == 0, true);
        assertEquals(t.getFactor() == 40, false);
    }

    @Test
    public void testSetFactor() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        final Translator t = new Translator();

        t.setFactor(30);

        final Field field = t.getClass().getDeclaredField("factor");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(t), 30);

    }

    @Test
    public void testPredictFuture() {
        Translator t1 = new Translator("Test", "Testson", 30, 6);

        assertEquals(t1.predictFuture().equals("Hard work pays off in the future. Laziness pays off now."), true);
        assertEquals(t1.predictFuture().equals("If a turtle doesn't have a shell, is it naked or homeless?"), false);

        Translator t2 = new Translator("ATest", "Testson", 9, 1);
        assertEquals(t2.predictFuture().equals("You love Chinese food."), true);
        assertEquals(t2.predictFuture().equals("If a turtle doesn't have a shell, is it naked or homeless?"), false);
        assertEquals(t2.predictFuture().equals("You are not illiterate."), false);

        Translator t3 = new Translator("Test", "Testson", 100, 10);
        assertEquals(t3.predictFuture().equals("If you look back, you'll soon be going that way."), true);
        assertEquals(t3.predictFuture().equals("If a turtle doesn't have a shell, is it naked or homeless?"), false);
        assertEquals(t3.predictFuture().equals("You are not illiterate."), false);
    }

    @Test
    public void testGetRandomNumber() {
        Translator t = new Translator("Test", "Testson", 30, 6);
        assertEquals(t.getRandomNumber() == 6, true);
        assertEquals(t.getRandomNumber() == 40, false);
    }

    @Test
    public void testSetRandomNumber() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        final Translator t = new Translator();

        t.setRandomNumber(1);

        final Field field = t.getClass().getDeclaredField("randomNumber");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(t), 1);

    }

    @Test
    public void testGetGoodFortunes() {
        Translator t = new Translator("Test", "Testson", 30, 6);
        t.setGoodFortunes(goodFortunes);
        assertEquals(t.getGoodFortunes().equals(goodFortunes), true);
        assertEquals(t.getGoodFortunes().equals(badFortunes), false);
        assertEquals(t.getGoodFortunes().equals(neutralFortunes), false);
    }

    @Test
    public void testSetGoodFortunes() throws NoSuchFieldException, IllegalAccessException {
        Translator t = new Translator("Test", "Testson", 30, 6);
        t.setGoodFortunes(goodFortunes);

        final Field field = t.getClass().getDeclaredField("goodFortunes");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(t), goodFortunes);
    }

    @Test
    public void testGetBadFortunes() {
        Translator t = new Translator("Test", "Testson", 30, 6);
        t.setBadFortunes(badFortunes);
        assertEquals(t.getBadFortunes().equals(badFortunes), true);
        assertEquals(t.getBadFortunes().equals(goodFortunes), false);
        assertEquals(t.getBadFortunes().equals(neutralFortunes), false);
    }

    @Test
    public void testSetBadFortunes() throws NoSuchFieldException, IllegalAccessException {
        Translator t = new Translator("Test", "Testson", 30, 6);
        t.setBadFortunes(badFortunes);

        final Field field = t.getClass().getDeclaredField("badFortunes");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(t), badFortunes);
    }

    @Test
    public void testGetNeutralFortunes() {
        Translator t = new Translator("Test", "Testson", 30, 6);
        t.setNeutralFortunes(neutralFortunes);
        assertEquals(t.getNeutralFortunes().equals(neutralFortunes), true);
        assertEquals(t.getNeutralFortunes().equals(goodFortunes), false);
        assertEquals(t.getNeutralFortunes().equals(badFortunes), false);
    }

    @Test
    public void testSetNeutralFortunes() throws NoSuchFieldException, IllegalAccessException {
        Translator t = new Translator("Test", "Testson", 30, 6);
        t.setNeutralFortunes(neutralFortunes);

        final Field field = t.getClass().getDeclaredField("neutralFortunes");
        field.setAccessible(true);
        assertEquals("Fields didn't match", field.get(t), neutralFortunes);
    }

}
