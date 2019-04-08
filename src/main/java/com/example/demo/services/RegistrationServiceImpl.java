package com.example.demo.services;

import com.example.demo.dao.JordanRepository;
import com.example.demo.domain.JordanUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RegistrationServiceImpl implements RegistrationService{


    private JordanUser currentUser;
    private JordanRepository jordanRepository;

    /**
     * Creates existing users
     *
     * @param jordanRepository
     */
    @Autowired
    public RegistrationServiceImpl(JordanRepository jordanRepository){
        this.jordanRepository = jordanRepository;
    }

    @Override
    public List<JordanUser> getUsers() {
        return jordanRepository.findAll();
    }

    @Override
    public void addUser(JordanUser user) {
        currentUser = user;
        jordanRepository.save(user);
    }

    @Override
    public JordanUser getCurrentUser() {
        return currentUser;
    }

    @Override
    public int getNumberOfUsers() {
        return (int) jordanRepository.count();
    }
}
