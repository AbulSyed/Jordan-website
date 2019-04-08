package com.example.demo.domain;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * An Entity class representing an jordan user including login information. (Password is
 * set using BCrypt password encoder.
 */
@Entity
public class JordanUser {

    private String firstName;
    private String lastName;
    private String gender;
    private String dob;
    @Id
    private String email;
    private String password;
    private Boolean enabled;
    private String authoritiy;

    public JordanUser(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        setPassword(password);
    }

    public JordanUser(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getAuthoritiy() {
        return authoritiy;
    }

    public void setAuthoritiy(String authoritiy) {
        this.authoritiy = authoritiy;
    }
}
