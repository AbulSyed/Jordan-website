package com.example.demo.domain;

import java.util.List;

/**
 * An Entity class representing all of the information relevant to a specific jordanUser including login history.
 *
 * */
public class CollatedUser {
    private JordanUser jordanUser;
    private List<LoginHistory> logins;

    public JordanUser getJordanUser() {
        return jordanUser;
    }

    public void setJordanUser(JordanUser jordanUser) {
        this.jordanUser = jordanUser;
    }

    public List<LoginHistory> getLogins() {
        return logins;
    }

    public void setLogins(List<LoginHistory> logins) {
        this.logins = logins;
    }


}
