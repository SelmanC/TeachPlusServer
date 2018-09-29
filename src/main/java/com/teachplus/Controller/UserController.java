package com.teachplus.Controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.teachplus.Entity.User;
import com.teachplus.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity getUserById(@PathVariable("id") long id) {
        User user = userService.getUserById(id);

        if (user == null) {
           return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(user);
    }


}
