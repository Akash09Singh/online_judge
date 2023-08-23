package com.spoj.online_judge.User.service;

import com.spoj.online_judge.User.entity.CustomUserDetails;
import com.spoj.online_judge.User.entity.User;
import com.spoj.online_judge.exception.customExceptiom.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UserNotFoundException {
        User user =  userService.findByUserName(username);
        if (user==null) throw new UserNotFoundException("username doesn't exist");
        CustomUserDetails userDetails = new CustomUserDetails(user.getUsername(), user.getPassword(),null,user.isEnable() );
        return userDetails;

    }
}
