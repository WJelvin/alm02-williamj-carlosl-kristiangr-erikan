package com.example.alm02;

import org.junit.Test;
import static org.junit.Assert.*;

public class TranslatorTest {

    public TranslatorTest() {
    }

    @Test
    public void testPredictFuture() {
        Translator translator = new Translator();
        assertEquals("Thou will haveth tough upbringing.", translator.predictFuture("Mike", "Hunt", 8, 4));
        assertEquals("Your life is void, it is.", translator.predictFuture("Mike", "Hunt", 3, 4));
        assertEquals("Your life is void, it is.", translator.predictFuture("Mike", "Stunt", 8, 4));
        assertEquals("Your life is void, it is.", translator.predictFuture("Spike", "Blunt", 4, 4));
        assertEquals("This sentenced has a random number that is less than 3. Same rating we give you!", translator.predictFuture("Mike", "Hunt", 8, 1));
        assertEquals("For one more year your life will still be bad.", translator.predictFuture("Mike", "Hunt", 17, 5));
    }
}
