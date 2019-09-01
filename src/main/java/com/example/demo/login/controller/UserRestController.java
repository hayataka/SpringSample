package com.example.demo.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.service.RestService;

@RestController
public class UserRestController {

    @Autowired
    RestService service;

    @GetMapping("/rest/get")
    public List<User> getUserMany() {
        return service.selectMany();
    }

    @GetMapping("/rest/get/{id:.+}")
    public User getUserOne(@PathVariable("id") String userId) {
        return service.selectOne(userId);
    }

    String createResult(boolean result) {
        String str = (result) ? "{\"result\":\"ok\"}" : "{\"result\":\"error\"}";
        return str;
    }

    @PostMapping("/rest/insert")
    public String postUserOne(@RequestBody User user) {
        boolean result = service.insert(user);
        String str = createResult(result);
        return str;
    }

    @PutMapping("/rest/update")
    public String putUserOne(@RequestBody User user) {

        boolean result = service.update(user);
        String str = createResult(result);
        return str;
    }

    @DeleteMapping("/rest/delete/{id:.+}")
    public String deleteUserOne(@PathVariable("id") String userId) {
        boolean result = service.delete(userId);
        String str = createResult(result);
        return str;
    }
}
