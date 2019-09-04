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
    

    public ManagedBean(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public ManagedBean() {
    }

    public void calculateFortune() {

        RandomFactor randomFactor = new RandomFactor();
        int randomNumber = randomFactor.numberBetween1And10();
        Translator translator = new Translator(firstName, lastName, age, randomNumber);
        fortune = translator.predictFuture();
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

}
