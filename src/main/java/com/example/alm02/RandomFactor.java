package com.example.alm02;

import java.io.Serializable;
import java.util.Random;

public class RandomFactor implements Serializable {
    
    public RandomFactor() {
    }
    
    public int numberBetween1And10() {
        Random rand = new Random();
        return rand.nextInt(10) + 1;
    }
    
}
