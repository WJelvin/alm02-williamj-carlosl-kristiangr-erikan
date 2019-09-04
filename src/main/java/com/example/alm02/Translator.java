package com.example.alm02;

import java.io.Serializable;

public class Translator implements Serializable {
    
    public Translator() { }
    
    public String predictFuture(String firstName, String lastName, int age, int randomNumber) {
        
        String prediction = "Your life is void, it is.";
        
        if ((firstName.equals("Mike") && lastName.equals("Hunt")) && age == 8) {
            prediction =  "Thou will haveth tough upbringing.";
        }
        
        if (age == 17) {
            prediction = "For one more year your life will still be bad.";
        }
        
        if (randomNumber < 3) {
            prediction = "This sentenced has a random number that is less than 3. Same rating we give you!";
        }
        
        return prediction;
        
    }
    
}
