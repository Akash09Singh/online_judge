package com.spoj.online_judge.User.controller;
import com.spoj.online_judge.User.entity.User;
import com.spoj.online_judge.User.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User newUser) throws Exception {

        String[] userRoles = {"USER"};
        User userCreated = userService.registerUser(newUser, userRoles);
        return new ResponseEntity<>(userCreated, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String username, @RequestParam String password) throws Exception {
        User loggedInUser = userService.logIn(username, password);
        return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<User>> findAll(){
        List<User> allUser = userService.findAll();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }
    //find user by username
    @GetMapping("/{username}")
    public ResponseEntity<User> findByUserName(@PathVariable String username){
        User user = userService.findByUserName(username);
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }

    //find user by username
    @GetMapping("/current-user")
    public ResponseEntity<User> findCurrentUser(Principal principal){
        String username = principal.getName();
        System.out.println("username: "+ username);
        User user = userService.findByUserName(username);
        System.out.println(user.toString());
        return new ResponseEntity<>(user, HttpStatus.FOUND);
    }
    //delete user by id
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteByUserId(@PathVariable int userId){
        String username = userService.deleteByUserId(userId);
        return new ResponseEntity<>(username+" deleted",HttpStatus.OK);
    }


}
