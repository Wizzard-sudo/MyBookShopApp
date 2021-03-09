package com.example.MyBookShopApp.services.user;

import com.example.MyBookShopApp.dto.user.User;
import com.example.MyBookShopApp.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Integer id){
        return userRepository.findById(id).get();
    }
}
