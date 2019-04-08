package com.example.demo.controllers;

import com.example.demo.domain.JordanUser;
import com.example.demo.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController{


    /**
     * The registration service which is used to save user information to the
     * database.
     */
    private final RegistrationService registrationService;

    /**
     * Constructor based dependency injection of the registration service
     *
     * @param registrationService
     */
    @Autowired
    private RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }


    /**
     * Controller method for responding to a GET request to the /register endpoint
     *
     * @return ModelAndView a view created from register.html backed by an JordanUser object
     */
    @RequestMapping(value ="/register", method = RequestMethod.GET)
    public ModelAndView showRegistrationForm(){
        return new ModelAndView("register", "jordanUser", new JordanUser());
    }

    /**
     * Controller method to handle a POST request to the /register endpoint
     *
     * @param jordanUser an object containing the data from the registration form
     * @return String a redirect to the profile page (which requires user login)
     */
    @RequestMapping(value ="/register", method = RequestMethod.POST)
    public String processRegistrationForm(JordanUser jordanUser){
        jordanUser.setEnabled(Boolean.TRUE);
        jordanUser.setAuthoritiy("ROLE_USER");
        registrationService.addUser(jordanUser);
        return "redirect:/profile";
    }


    /**
     * Controller method for responding to a GET request to the /users endpoint
     *
     * @return ModelAndView a view created from user.html
     */
    @RequestMapping(value="/users")
    public ModelAndView showUsers(){
        return new ModelAndView("/users", "users", registrationService.getUsers());
    }
}
