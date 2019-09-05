package com.example.alm02;

import java.io.Serializable;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Translator implements Serializable {

    private int factor = 0;
    private String firstName;
    private String lastName;
    private int age;
    private int randomNumber;

    private List<String> goodFortunes = new ArrayList<>();
    private List<String> badFortunes = new ArrayList<>();
    private List<String> neutralFortunes = new ArrayList<>();

    public Translator(String firstName, String lastName, int age, int randomNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.randomNumber = randomNumber;
        factor = randomNumber;

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

    public Translator() {
        goodFortunes.add("Stop eating now. Food poisoning is no fun.");
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

    public String predictFuture() {
        String prediction = "Your life is void, it is.";

        factor += calculateFirstNameFactor();
        factor += calculateLastNameFactor();
        factor += calculateAgeFactor();

        int fortuneType = decideFortuneType();

        if (fortuneType == 1) {
            prediction = readFortune(goodFortunes);
        } else if (fortuneType == 2) {
            prediction = readFortune(neutralFortunes);
        } else {
            prediction = readFortune(badFortunes);
        }

        return prediction;

    }

    public int calculateFirstNameFactor() {


        String firstChar = firstName.toLowerCase().substring(0, 1);


        int factor = 0;
        if (Pattern.matches("[a-g]", firstChar)) {
            factor = 1;
        } else if (Pattern.matches("[h-o]", firstChar)) {
            factor = 2;
        } else {
            factor = 3;
        }
        return factor;
    }

    public int calculateLastNameFactor() {
        String firstChar = lastName.toLowerCase().substring(0, 1);

        int factor = 0;
        if (Pattern.matches("[a-g]", firstChar)) {
            factor = 3;
        } else if (Pattern.matches("[h-o]", firstChar)) {
            factor = 2;
        } else {
            factor = 1;

        }

        return factor;
    }

    public int calculateAgeFactor() {
        ValueRange range1 = ValueRange.of(10, 32);
        ValueRange range2 = ValueRange.of(33, 99);
        int factor = 0;
        if (age < 10) {
            factor = 0;

        } else if (range1.isValidIntValue(age)) {
            factor = 1;

        } else if (range2.isValidIntValue(age)) {
            factor = 2;

        } else {
            factor = 50;
        }
        return factor;
    }

    public int decideFortuneType() {
        ValueRange range = ValueRange.of(7, 20);
        if (factor < 7) {
            return 1; //Good
        } else if (range.isValidIntValue(factor)) {
            return 2; //Neutral
        } else {
            return 3; //BAD!!!
        }

    }

    public String readFortune(List<String> fortuneList) {
        return fortuneList.get(factor % fortuneList.size());
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
