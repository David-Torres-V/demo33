package com.example.demo.service;

import com.example.demo.binding.User;

import java.util.List;

public interface UserService {

    public String upsert(User user);

    public User getById(Integer id);

    public List<User> getAll();
}
