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
    private String prediction;

    public ManagedBean(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public ManagedBean() {
    }
    
    public void calculateFortune() {
        RandomFactor randomFactor = new RandomFactor();
        Translator translator = new Translator();
        int randomNumber = randomFactor.numberBetween1And10();
        prediction = translator.predictFuture(firstName, lastName, age, randomNumber);
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
        return prediction;
    }

    public void setFortune(String fortune) {
        this.prediction = fortune;
    }

    
    
}
