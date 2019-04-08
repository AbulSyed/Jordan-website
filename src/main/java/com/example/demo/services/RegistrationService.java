package com.example.demo.services;

import com.example.demo.domain.JordanUser;

import java.util.List;

/**
 * Registration service interface that specifies a method to save user information to the database.
 */
public interface RegistrationService {


    List<JordanUser> getUsers();
    void addUser(JordanUser user);
    JordanUser getCurrentUser();
    int getNumberOfUsers();
}
