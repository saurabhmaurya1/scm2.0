package com.scm.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.scm.helpers.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.repositories.UserRepo;
import com.scm.services.UserService;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
       // User id we have to generate by our selves
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);

        //password encode

        return userRepo.save(user);
    }

    @Override
    public Optional<User> getUserByID(String id) {
        
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user2 = userRepo.findById(user.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user.getPhoneNumber());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnabled(user.isEnabled());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerifid(user.isPhoneVerifid());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());


        User save = userRepo.save(user2);
        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(String id) {
        User user2 = userRepo.findById(id).orElseThrow(()-> new RuntimeException("User Not Found"));
        userRepo.delete(user2);
    }

    @Override
    public boolean isUserExist(String userId) {
        User user2 = userRepo.findById(userId).orElse(null);
        return user2!=null ? true:false;

    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user2 = userRepo.findByEmail(email).orElse(null);
        return user2!=null ? true:false;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();

    }

}
