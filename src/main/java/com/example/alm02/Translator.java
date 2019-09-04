package com.example.alm02;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Translator implements Serializable {

    private int factor = 0;
    private String firstName;
    private String lastName;
    private int age;
    private int randomNumber = 0;


    private List<String> goodFortunes = new ArrayList<>();
    private List<String> badFortunes = new ArrayList<>();
    private List<String> neutralFortunes = new ArrayList<>();

    public Translator(String firstName, String lastName, int age, int randomNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.randomNumber = randomNumber;
        factor = randomNumber;


        goodFortunes.add("Good1");
        goodFortunes.add("Good2");
        goodFortunes.add("Good3");
        goodFortunes.add("Good4");
        goodFortunes.add("Good5");
        goodFortunes.add("Good6");
        goodFortunes.add("Good7");

        badFortunes.add("Bad1");
        badFortunes.add("Bad2");
        badFortunes.add("Bad3");
        badFortunes.add("Bad4");
        badFortunes.add("Bad5");
        badFortunes.add("Bad6");
        badFortunes.add("Bad7");

        neutralFortunes.add("Neutral1");
        neutralFortunes.add("Neutral2");
        neutralFortunes.add("Neutral3");
        neutralFortunes.add("Neutral4");
        neutralFortunes.add("Neutral5");
        neutralFortunes.add("Neutral6");
        neutralFortunes.add("Neutral7");

    }

    public Translator() { }
    
    public String predictFuture() {
        String prediction = "Your life is void, it is.";

        factor += calculateFirstNameFactor();
        factor += calculateLastNameFactor();
        factor += calculateAgeFactor();

        int fortuneType =  decideFortuneType();

        if (fortuneType == 1) {
            prediction = readFortune(goodFortunes);
        }
        else if (fortuneType == 2) {
            prediction = readFortune(neutralFortunes);
        }
        else {
            prediction = readFortune(badFortunes);
        }

        factor = 0;
        return prediction;
        
    }

    public int calculateFirstNameFactor() {
        String firstChar = firstName.toLowerCase().substring(0,1);

            int factor = 0;
        if (Pattern.matches("[a-g]", firstChar)) {
            factor = 1;
        }
        else if (Pattern.matches("[h-o]", firstChar)) {
            factor = 2;
        }
        else {
            factor = 3;
        }
        return factor;
    }

    public int calculateLastNameFactor() {
        String firstChar = lastName.toLowerCase().substring(0,1);

        int factor = 0;
        if (Pattern.matches("[a-g]", firstChar)) {
            factor = 3;
        }

        else if (Pattern.matches("[h-o]", firstChar)) {
            factor = 2;
        }
        else {
            factor = 1;

        }

        return factor;
    }

    public int calculateAgeFactor() {
        int factor = 0;
        if (age < 10) {
            factor = 0;

        }

        else if (age >= 10 && age < 33) {
            factor = 1;

        }
        else if (age >= 33 && age < 100) {
            factor = 2;

        }
        else {
            factor = 50;
        }
        return factor;
    }



    public int decideFortuneType() {
        if (factor < 7) {
            return 1; //Good
        }
        else if (factor >= 7 && factor <= 21) {
            return 2; //Neutral
        }
        else {
            return 3; //BAD!!!
        }

    }

    public String readFortune(List<String> fortuneList ) {
        return fortuneList.get(factor%fortuneList.size());
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public List<String> getGoodFortunes() {
        return goodFortunes;
    }

    public void setGoodFortunes(List<String> goodFortunes) {
        this.goodFortunes = goodFortunes;
    }

    public List<String> getBadFortunes() {
        return badFortunes;
    }

    public void setBadFortunes(List<String> badFortunes) {
        this.badFortunes = badFortunes;
    }

    public List<String> getNeutralFortunes() {
        return neutralFortunes;
    }

    public void setNeutralFortunes(List<String> neutralFortunes) {
        this.neutralFortunes = neutralFortunes;
    }


}
