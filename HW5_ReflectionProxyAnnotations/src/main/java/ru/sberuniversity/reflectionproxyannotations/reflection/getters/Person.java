package ru.sberuniversity.reflectionproxyannotations.reflection.getters;

import java.text.DateFormat;

public class Person {
    private String name;
    private String surname;
    private Integer age;
    private DateFormat birthDay;
    private String ender;
    private Integer phoneNumber;

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getSurname() {
        return surname;
    }

    private void setSurname(String surname) {
        this.surname = surname;
    }

    private Integer getAge() {
        return age;
    }

    private void setAge(Integer age) {
        this.age = age;
    }

    private DateFormat getBirthDay() {
        return birthDay;
    }

    private void setBirthDay(DateFormat birthDay) {
        this.birthDay = birthDay;
    }

    private String getEnder() {
        return ender;
    }

    private void setEnder(String ender) {
        this.ender = ender;
    }

    private Integer getPhoneNumber() {
        return phoneNumber;
    }

    private void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", birthDay=" + birthDay +
                ", ender='" + ender + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
