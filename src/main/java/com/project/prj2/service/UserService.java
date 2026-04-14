package com.project.prj2.service;

import com.project.prj2.dto.UserDto;
import com.project.prj2.exception.UserNotFoundException;
import com.project.prj2.model.User;
import com.project.prj2.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<UserDto> getAllUsers(){
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDto( user.getId(), user.getName(), user.getAge(), user.getRole() ))
                .toList();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("User not found"));
    }

    public User updateExistingUser(Long id, @Valid UserDto dto) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundException("User not found"));

        user.setName(dto.getName());
        user.setAge(dto.getAge());

        return userRepository.save(user);
    }

    public List<UserDto> searchUser(String name){
        return userRepository.findByNameIgnoreCase(name)
                .stream()
                .map(user -> new UserDto(user.getId(), user.getName(), user.getAge(), user.getRole()))
                .toList();
    }

    public List<UserDto> sortUsers(String field){
        return userRepository.findAll(Sort.by(field))
                .stream()
                .map(user -> new UserDto(user.getId(), user.getName(), user.getAge(), user.getRole()))
                .toList();
    }

    public Page<User> getUsersWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }



}
