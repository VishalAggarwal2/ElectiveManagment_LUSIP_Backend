package com.ElectiveManagment.ElectiveManagment.service.Impl;

import com.ElectiveManagment.ElectiveManagment.entity.User;
import com.ElectiveManagment.ElectiveManagment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> u = userRepository.findByFirstName(username);

        if(!u.isEmpty()){
         UserDetails ud=   org.springframework.security.core.userdetails.
                    User.builder().username(u.get().getFirstName())
                    .password(u.get().getPassword()).roles(u.get().getRoles().toArray(new String[0])).build();
         return ud;

        }


        return null;
    }
}
