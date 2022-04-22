package com.test.testapi.dao;

import java.time.LocalDate;

public class CustomerDAO {
    private long id; // Imagine as PK
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String telNumber;
    private String email; // Imagine as UK

    public CustomerDAO() {
    }

    public CustomerDAO(long id, String name, String surname,
            LocalDate birthDate, String telNumber, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.telNumber = telNumber;
        this.email = email;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getTelNumber() {
        return this.telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
