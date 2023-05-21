package com.mct.ExpenseTracker.repos;

import com.mct.ExpenseTracker.models.AuthenticationToken;
import com.mct.ExpenseTracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iAuthRepo  extends JpaRepository<AuthenticationToken,Integer> {
    AuthenticationToken findByUser(User user);
}
