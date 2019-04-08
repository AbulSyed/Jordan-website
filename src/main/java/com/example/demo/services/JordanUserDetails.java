package com.example.demo.services;

import com.example.demo.dao.HistoryRepository;
import com.example.demo.dao.JordanRepository;
import com.example.demo.domain.JordanUser;
import com.example.demo.domain.LoginHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Custom authentication service which includes recording login history
 * each time a user is authenticated.
 */
@Service
public class JordanUserDetails implements UserDetailsService {
    /**
     * The repository for jordan user data.
     */
    private JordanRepository jordanRepository;
    /**
     * The repository for login history
     */
    private HistoryRepository historyRepository;

    /**
     * Construct based dependency injection of repositories.
     *
     * @param jordanRepository the opera user repo
     * @param historyRepository the login history repo
     */
    @Autowired
    public JordanUserDetails(JordanRepository jordanRepository, HistoryRepository historyRepository){
        this.jordanRepository = jordanRepository;
        this.historyRepository = historyRepository;
    }

    /**
     * The override fo the UserDetailsService method that validates a user. The methods finds the
     * user in the database based on the String s provided by the users login credentials (their email
     * address)
     *
     * @param s user's email address provided when logging in.
     * @return UserDetails an object representing the user including their password, account status and roles
     * @throws UsernameNotFoundException if the user cannot be found in the database
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        JordanUser jordanUser = jordanRepository.findById(s).orElseThrow(()-> new UsernameNotFoundException("No matching user."));
        //if the first line does not throw the exception the login history
        //object will be constructed and saved to the database.
        LoginHistory loginHistory = new LoginHistory();
        loginHistory.setEmail(jordanUser.getEmail());
        loginHistory.setTime(LocalDateTime.now());
        historyRepository.save(loginHistory);
        //and a UserDetails object will be constructed and returned.
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(jordanUser.getAuthoritiy()));
        return new User
                (jordanUser.getEmail(), jordanUser.getPassword(), jordanUser.getEnabled(),
                        true, true, true, authorities);

    }
}
