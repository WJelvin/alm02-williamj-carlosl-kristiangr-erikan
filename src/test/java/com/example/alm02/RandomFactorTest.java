package com.example.alm02;

import org.junit.Test;
import static org.junit.Assert.*;

public class RandomFactorTest {
    
    RandomFactor rf = new RandomFactor();
    
    @Test
    public void testRandomNumberBetween1And10() {
        int max = 10;
        int min = 1;

        for (int i = 0; i < 10000; i++) {
            int random = rf.numberBetween1And10();
            assertTrue(max >= random && min <= random);
        }
        
    }
}
