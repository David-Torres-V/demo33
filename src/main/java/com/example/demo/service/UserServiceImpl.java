package com.example.demo.service;

import com.example.demo.binding.User;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public String upsert(User user) {
        userRepository.save(user);
        return "success";
    }

    @Override
    public User getById(Integer id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

}
