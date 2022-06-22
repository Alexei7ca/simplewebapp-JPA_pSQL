package com.mastery.java.task.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "gender")
    private Gender gender;

    public Employee() {
        super();
    }

    public Employee(String firstName, Gender gender) {
        super();
        this.firstName = firstName;
        this.gender = gender;
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", gender=" + gender + "]";
    }

}