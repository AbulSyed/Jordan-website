package com.example.demo.services;

import com.example.demo.domain.CollatedUser;

/**
 * Profile service interface that specifies a method to return a CollatedUser.
 */
public interface ProfileService {
    CollatedUser getProfile(String email);
}
