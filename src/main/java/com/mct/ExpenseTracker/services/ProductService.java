package com.mct.ExpenseTracker.services;

import com.mct.ExpenseTracker.models.Product;
import com.mct.ExpenseTracker.models.User;
import com.mct.ExpenseTracker.repos.iProductRepo;
import com.mct.ExpenseTracker.repos.iUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private iProductRepo expenseRepo ;

    @Autowired
    private iUserRepo userRepo ;
    public void addExpense(Product product) {

        User user  = userRepo.findById(product.getUser().getUser_id()).get();

        if(user == null){
            throw new IllegalStateException("User not exist");
        }

        product.setUser(user);

        expenseRepo.save(product);

    }

    public List<Product> getByDate(LocalDate date) {
        List<Product> allexpense = expenseRepo.findAll() ;

        List<Product> returnExp = new ArrayList<>();
        for(Product exp: allexpense){
            if(exp.getDate().equals(date)){
                returnExp.add(exp);
            }
        }
        return returnExp;
    }

    public String getTotalExpenseByMonth(String name , Month month) {
        List<Product> allexpense = expenseRepo.findAll() ;
        Double TotalExpense = 0.0;

        for(Product exp:allexpense){
            if(exp.getUser().getUser_name().equals(name) && exp.getDate().getMonth().equals(month)){
                TotalExpense = TotalExpense+exp.getPrice();
            }
        }

        return "Hello" + " " + name + " " + "Your Total Expense for the Month of " +  " " +
                month +  " " + "is" + " " + TotalExpense ;
    }

    public String updateExpenseById(Integer id, Product product) {
        Product product1 = expenseRepo.findById(id).get();
        if(product1 == null){
            throw new IllegalStateException("Invalid Expense Id");
        }
        product1.setTitle(product.getTitle());
        product1.setDescription(product.getDescription());
        product1.setPrice(product.getPrice());
        product1.setDate(product.getDate());

        expenseRepo.save(product1);

        return "Update Scussesfull";

    }

    public List<Product> getAllByName(String name) {
        List<Product> allexpense = expenseRepo.findAll() ;

        List<Product> returnExp = new ArrayList<>();
        for(Product exp: allexpense){
            if(exp.getUser().getUser_name().equals(name) ){
                returnExp.add(exp);
            }
        }
        return returnExp ;
    }

    public String deleteById(Integer expenseId) {

        expenseRepo.deleteById(expenseId);
        return  "Product Delete Scussesfully" ;
    }
}
