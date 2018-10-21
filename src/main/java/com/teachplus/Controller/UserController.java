package com.teachplus.Controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.teachplus.Entity.LoginForm;
import com.teachplus.Entity.User;
import com.teachplus.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(produces = { "application/json" })
    public ResponseEntity getAllUsers() {
        Collection<User> allUsers = userService.getAllUsers();

        if (allUsers == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(allUsers);
    }

    @GetMapping(value="/teachers", produces = { "application/json" })
    public ResponseEntity getAllTeachers() {
        Collection<User> allTeachers = userService.getAllUsersByRole("teacher");

        if (allTeachers == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(allTeachers);
    }

    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity getUserById(@PathVariable("id") long id) {
        User user = userService.getUserById(id);

        if (user == null) {
           return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/{id}/children", produces = { "application/json" })
    public ResponseEntity getChildren(@PathVariable("id") long id) {
        Collection<User> children = userService.getChildrenById(id);

        if (children == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(children);
    }

    @PostMapping(value = "/{id}/children", consumes = { "application/json" }, produces = { "application/json" })
    public void addChildren(@PathVariable("id") long id, @RequestBody List<User> children) {
        userService.addChildren(id, children);
    }

    @PostMapping(value="/login", consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity getUserByCredentials(@RequestBody LoginForm loginForm) {
        User user = userService.getUserByCredentials(loginForm.getWorkspace(), loginForm.getEmail(), loginForm.getPassword());

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(user);
    }

    @PostMapping(consumes = { "application/json" }, produces = { "application/json" })
    public ResponseEntity addUser(@RequestBody User user) {
        User savedUser = userService.addUser(user);
        return ResponseEntity.ok().body(savedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
    }


}
