package com.project.prj2.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class UserDto {

    private Long id;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Min(value = 0, message = "Age cannot be negative")
    private int age;

    private String role;



    public UserDto(Long id, String name, int age, String role){
        this.id = id;
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRole(){
        return role;
    }
}
