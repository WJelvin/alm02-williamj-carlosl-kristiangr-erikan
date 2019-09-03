package com.example.alm02;

import java.io.Serializable;

public class Person implements Serializable{
    
    private String firstName;
    private String lastName;
    private int age;

    //Constructor
    public Person( String firstName, String lastName,int age) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {}

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
    
}
