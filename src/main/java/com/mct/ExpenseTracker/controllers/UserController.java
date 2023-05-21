package com.mct.ExpenseTracker.controllers;

import com.mct.ExpenseTracker.dto.SignInInput;
import com.mct.ExpenseTracker.dto.SignInOutput;
import com.mct.ExpenseTracker.dto.SignUpInput;
import com.mct.ExpenseTracker.dto.SignUpOutput;
import com.mct.ExpenseTracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    //Regestering or Signing Up User

    @PostMapping(value = "/signup")
    public SignUpOutput signup(@Valid @RequestBody SignUpInput signUpInput){
        return userService.signup(signUpInput);
    }

    //User Sign In

    @PutMapping(value = "/signin")
    public SignInOutput signin(@RequestBody SignInInput signInInput){
        return userService.signin(signInInput);
    }

}
