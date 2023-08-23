package com.spoj.online_judge.User.entity;

import com.spoj.online_judge.Roles.Service.RolesService;
import com.spoj.online_judge.User.service.UserService;
import com.spoj.online_judge.UserRole.Repository.UserRoleRepository;
import com.spoj.online_judge.UserRole.Service.UserRolesService;
import com.spoj.online_judge.entity.Role;
import com.spoj.online_judge.entity.UserRole;
import com.spoj.online_judge.exception.customExceptiom.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean enabled ;
    @Autowired
    private UserRolesService userRolesService;

    @Autowired
    private UserService userService;

    @Autowired
    private RolesService rolesService;

    public CustomUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, boolean enabled) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
    }

    public CustomUserDetails() {
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        User user = userService.findByUserName(username);
        if (user==null){
            throw new UserNotFoundException("user doesn't exists with username: "+username);
        }
        int userId = user.getId();
        //getting all the roles id associated with user
        List<UserRole> userRoles = userRolesService.findUserRolesByUserId(userId);
        //store all the role id associated with user
        List<Integer> userRolesId = new ArrayList<>();
        for (UserRole ur:userRoles){
            userRolesId.add(ur.getRoleId());
        }
        // getting all the roles name associated with those role id

        Set<Authority> authoritySet = new HashSet<>();
        for (int roleId:userRolesId){
            Role role = rolesService.getRoleById(roleId).orElseThrow(()-> new UserNotFoundException("role doesn't exist by id: "+roleId));
            authoritySet.add(new Authority(role.getRole()));
        }



        return authoritySet;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
