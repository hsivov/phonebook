package com.example.phonebook.entity;

public class Contact {

    public Contact() {};

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    private String name;

    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
