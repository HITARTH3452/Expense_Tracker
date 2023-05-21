package com.mct.ExpenseTracker.repos;

import com.mct.ExpenseTracker.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iProductRepo extends JpaRepository<Product,Integer> {

}
