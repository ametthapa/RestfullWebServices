package com.amrit.rest.webservices.restfullwebservices.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity(name = "user_details")
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Size(min=2, message = "Name should have atleast 2 characters")
    @JsonProperty("user_name")
    private String name;
    @Past(message = "Birthdate should be in the past")
    private LocalDate brithDate;

    public User(int id, String name, LocalDate brithDate) {
        this.id = id;
        this.name = name;
        this.brithDate = brithDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(LocalDate brithDate) {
        this.brithDate = brithDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brithDate=" + brithDate +
                '}';
    }
}
