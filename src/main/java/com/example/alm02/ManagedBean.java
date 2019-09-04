package com.example.alm02;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "controllerBean")
@SessionScoped
public class ManagedBean implements Serializable {

    private String firstName;
    private String lastName;
    private int age;
    private String fortune;
    private int randomNumber;
    Translator translator = new Translator();
    RandomFactor randomFactor = new RandomFactor();

    public ManagedBean(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        randomNumber = randomFactor.numberBetween1And10();
    }

    public ManagedBean() {
        randomNumber = randomFactor.numberBetween1And10();
    }

    public void calculateFortune() {
        fortune = translator.predictFuture(firstName, lastName, age, randomNumber);
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

    public String getFortune() {
        return fortune;
    }

    public void setFortune(String fortune) {
        this.fortune = fortune;
    }

    public int getRandomNumber() {
        return randomNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public Translator getTranslator() {
        return translator;
    }

    public void setTranslator(Translator translator) {
        this.translator = translator;
    }

    public RandomFactor getRandomFactor() {
        return randomFactor;
    }

    public void setRandomFactor(RandomFactor randomFactor) {
        this.randomFactor = randomFactor;
    }
}
