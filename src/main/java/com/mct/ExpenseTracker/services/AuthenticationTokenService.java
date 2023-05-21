package com.mct.ExpenseTracker.services;

import com.mct.ExpenseTracker.models.AuthenticationToken;
import com.mct.ExpenseTracker.models.User;
import com.mct.ExpenseTracker.repos.iAuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationTokenService {

    @Autowired
    private iAuthRepo authRepo ;

    public void save(AuthenticationToken token) {

        authRepo.save(token);
    }

    public AuthenticationToken getToken(User user) {

        return authRepo.findByUser(user);
    }
}
