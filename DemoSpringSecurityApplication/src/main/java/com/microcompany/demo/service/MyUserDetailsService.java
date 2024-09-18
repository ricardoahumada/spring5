package com.microcompany.demo.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    public MyUserDetailsService() {
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        TODO: uncomment
        if (!username.equals("juan"))
            throw new UsernameNotFoundException("User with username - " + username + " not found");
        return new User("juan", "juanpass", new ArrayList<>());
//        return null; // TODO: remove when uncomment
    }

}
