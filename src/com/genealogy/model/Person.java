package com.genealogy.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private String parentName;

    public Person(String name, Gender gender, LocalDate birthDate, String parentName) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.parentName = parentName;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getParentName() {
        return parentName;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Gender: " + gender + ", BirthDate: " + birthDate + ", Parent: " + parentName;
    }
}