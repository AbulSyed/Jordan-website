package com.example.demo.controllers;

import com.example.demo.domain.CollatedUser;
import com.example.demo.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
    /**
     * The profile service which generates a "CollatedUser" object that contains references
     * to each of the domain objects (JordanUser & LoginHistory)
     *
     */
    private ProfileService profileService;

    /**
     * Constructor based dependency injection of the profile service.
     *
     * @param profileService
     */
    @Autowired
    public ProfileController(ProfileService profileService){
        this.profileService = profileService;
    }

    /**
     * Controller method to respond to GET requests to the /profile endpoint.
     *
     * @return ModelAndView an object that returns the profile.html view combined with the data
     * for the current logged in user (user info & login history)
     */
    @RequestMapping(value="/profile")
    public ModelAndView showProfile(){
        //Retrieves the email address of the currently logged in user.
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        CollatedUser user = profileService.getProfile(email);
        return new ModelAndView("profile", "collatedUser", user);
    }
}
