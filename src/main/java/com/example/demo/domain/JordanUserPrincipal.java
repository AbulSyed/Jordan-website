package com.example.demo.domain;

import java.nio.file.attribute.UserPrincipal;

/**
 * An JordanUserPrincipal represents the current user in the user details service.
 */
public class JordanUserPrincipal implements UserPrincipal {

    private JordanUser jordanUser;

    public JordanUserPrincipal(JordanUser jordanUser){
        this.jordanUser = jordanUser;
    }

    @Override
    public String getName() {
        return jordanUser.getEmail();
    }
}
