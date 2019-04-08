package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller to handle GET requests to the home and pages
 */

@Controller
public class JordanController {

    /**
     * Controller method to handle a GET request to the / endpoint (homepage)
     * @return ModelAndView returns a view constructed from index.html
     */
    @RequestMapping(value = "/")
    public ModelAndView showHome(){
        return new ModelAndView("index");
    }

    /**
     * Controller method to handle a GET request to the /product endpoint
     * @return ModelAndView returns a view constructed from product.html
     */
    @RequestMapping(value = "/product")
    public ModelAndView showProduct(){
        return new ModelAndView("product");
    }

    /**
     * Controller method to handle a GET request to the /signin endpoint
     * @return ModelAndView returns a view constructed from signin.html
     */

    @RequestMapping(value = "/signin")
    public ModelAndView showSignin(){
        return new ModelAndView("signin");
    }

    /**
     * Controller method to handle a GET request to the /forum endpoint
     * @return ModelAndView returns a view constructed from forum.html
     */

    @RequestMapping(value = "/forum")
    public ModelAndView showForum(){
        return new ModelAndView("forum");
    }

    /**
     * Controller method to handle a GET request to the /concord endpoint
     * @return ModelAndView returns a view constructed from concord.html
     */
    @RequestMapping(value = "/concord")
    public ModelAndView showConcord(){
        return new ModelAndView("concord");
    }

    /**
     * Controller method to handle a GET request to the /spacejam endpoint
     * @return ModelAndView returns a view constructed from spacejam.html
     */
    @RequestMapping(value = "/SpaceJam")
    public ModelAndView showSpaceJam(){
        return new ModelAndView("SpaceJam");
    }

    /**
     * Controller method to handle a GET request to the /columbia endpoint
     * @return ModelAndView returns a view constructed from columbia.html
     */
    @RequestMapping(value = "/Columbia")
    public ModelAndView showColumbia(){
        return new ModelAndView("Columbia");
    }

    /**
     * Controller method to handle a GET request to the /72-10 endpoint
     * @return ModelAndView returns a view constructed from 72-10.html
     */
    @RequestMapping(value = "/72-10")
    public ModelAndView show7210(){
        return new ModelAndView("72-10");
    }

    /**
     * Controller method to handle a GET request to the /bred endpoint
     * @return ModelAndView returns a view constructed from bred.html
     */
    @RequestMapping(value = "/Bred")
    public ModelAndView showBred(){
        return new ModelAndView("Bred");
    }

    /**
     * Controller method to handle a GET request to the /gammablue endpoint
     * @return ModelAndView returns a view constructed from gammablue.html
     */
    @RequestMapping(value = "/GammaBlue")
    public ModelAndView showGammaBlue(){
        return new ModelAndView("GammaBlue");
    }

}
