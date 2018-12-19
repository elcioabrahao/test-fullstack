package com.test.api.controller;


import com.test.exception.ResourceNotFoundException;
import com.test.model.entity.User;
import com.test.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/api/user")
    public List<User> getUsers(){
        List<User> users = this.userService.getAllUsers();
        return users;
    }

    @GetMapping("/api/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        User user = userService.findUserById(userId);
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/api/user")
    public User createUser(@Valid @RequestBody User user) throws ResourceNotFoundException{
        return userService.saveUser(user);
    }


    @PutMapping("/api/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                           @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        return ResponseEntity.ok(userService.updateUser(userDetails,userId));
    }


    @DeleteMapping("/api/user/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {

        User user = userService.deleteUser(userId);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
