package com.example.demo.services;

import com.example.demo.dao.HistoryRepository;
import com.example.demo.dao.JordanRepository;
import com.example.demo.domain.CollatedUser;
import com.example.demo.domain.LoginHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileServiceImpl implements ProfileService{

    /**
     * The repository for jordanUser data.
     */
    private JordanRepository jordanRepository;

    /**
     * The repository for login history.
     */
    private HistoryRepository historyRepository;


    /**
     * Constructor based dependency injection of repositories.
     *
     * @param jordanRepository the opera user repo
     */
    @Autowired
    public ProfileServiceImpl(JordanRepository jordanRepository, HistoryRepository historyRepository){
        this.jordanRepository= jordanRepository;
        this.historyRepository = historyRepository;
    }


    /**
     * The implemented method that collates all the current users information
     * into a single object that will back the profile.html view
     *
     * @param email the current user's email
     * @return CollatedUser a object that aggregates all the user's data.
     */
    @Override
    public CollatedUser getProfile(String email) {
        CollatedUser user = new CollatedUser();
        user.setJordanUser(jordanRepository.findById(email).orElseThrow(()-> new UsernameNotFoundException("No matching user found.")));
        List<LoginHistory> history = historyRepository.findAll()
                .stream().filter(loginHistory -> loginHistory.getEmail().equals(email))
                .collect(Collectors.toList());
        user.setLogins(history);

        return user;
    }
}
