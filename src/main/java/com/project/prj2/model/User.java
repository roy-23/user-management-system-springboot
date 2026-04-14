package com.project.prj2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    public String role;

    public User(){

    }

    public User(String name, int age, String role){
        this.name=name;
        this.age=age;
        this.role=role;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public Long getId() {
        return id;
    }

    public String getRole(){
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
