package com.example.demo.config;

import com.example.demo.services.JordanUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Custom user details service that also records user login
     * history in the database.
     */
    private JordanUserDetails jordanUserDetails;


    /**
     * Constructor based dependency injection of custom user details service.
     *
     * @param jordanUserDetails
     */
    @Autowired
    public SecurityConfig(JordanUserDetails jordanUserDetails){
        this.jordanUserDetails = jordanUserDetails;
    }

    /**
     * Authentication service
     * @param auth
     * @throws Exception
     */

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenticationProvider());
    }

    /**
     * Only provides access to profile, users, sign in and forum pages
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/profile", "/users", "/signin", "/forum" )
                .authenticated()
                .and()
                .formLogin();


        http.csrf().disable();
        http.headers().frameOptions().disable();

    }

    /**
     * Method to construct an authentication provided which uses the  custom user details
     * service so it can be supplied to the auth object (together with a BCrypt password
     * encoder. Method is called when configuring authentication.
     *
     * @return DaoAuthenticationProvider an authentication provider that contains the custom
     * user details service and password encoder.
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider
                = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(jordanUserDetails);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        return authProvider;
    }
}
