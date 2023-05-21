package com.mct.ExpenseTracker.repos;

import com.mct.ExpenseTracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iUserRepo extends JpaRepository<User,Integer> {


    User findFirstByUserEmail(String userEmail);
}
