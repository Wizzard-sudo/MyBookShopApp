package com.example.MyBookShopApp.services.user;

import com.example.MyBookShopApp.dto.user.UserContact;
import com.example.MyBookShopApp.repository.user.UserContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserContactService {

    private final UserContactRepository userContactRepository;

    @Autowired
    public UserContactService(UserContactRepository userContactRepository) {
        this.userContactRepository = userContactRepository;
    }

    public UserContact getUserContactById(Integer id){
        return userContactRepository.findById(id).get();
    }
}
