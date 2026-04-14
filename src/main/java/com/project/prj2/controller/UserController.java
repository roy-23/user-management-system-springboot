package com.project.prj2.controller;

import com.project.prj2.dto.ApiResponse;
import com.project.prj2.dto.UserDto;
import com.project.prj2.model.User;
import com.project.prj2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/users")
    public ApiResponse<List<UserDto>> getUsers(){
        return new ApiResponse<>("Users fetched successfully",
            userService.getAllUsers());
    }

    @PostMapping("/users")
    public ApiResponse<User> createUser(@RequestBody @Valid UserDto user){
        return new ApiResponse<>("User created successfully",
                userService.saveUser(new User(user.getName(),user.getAge(), user.getRole())));
    }

    @GetMapping("/users/{id}")
    public ApiResponse<User> getUser(@PathVariable Long id){
        return new ApiResponse<>("User fetched successfully" ,
                userService.getUserById(id));
    }

    @DeleteMapping("/users/{id}")
    public ApiResponse<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ApiResponse<>("User deleted successfully", null);
    }

    @GetMapping("/users/count")
    public ApiResponse<Integer> countUsers(){
        return new ApiResponse<>("User count is : ",
                userService.getAllUsers().size());
    }

    @PutMapping("/users/{id}")
    public ApiResponse<User> updateUser(@PathVariable Long id, @RequestBody @Valid UserDto dto){
        return new ApiResponse<>("User details updated",
                userService.updateExistingUser(id,dto));
    }

    @GetMapping("users/search")
    public List<UserDto> searchUser(@RequestParam String name){
        return userService.searchUser(name);
    }

    @GetMapping("users/sort")
    public List<UserDto> sortUsers(@RequestParam String field){
        return userService.sortUsers(field);
    }


    @GetMapping("/users/page")
    public Page<User> getUsers(
            @RequestParam int page,
            @RequestParam int size) {

        return userService.getUsersWithPagination(page, size);
    }
}
