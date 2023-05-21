package com.mct.ExpenseTracker.controllers;

import com.mct.ExpenseTracker.models.Product;
import com.mct.ExpenseTracker.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(value = "/expense")
public class ProductController {

    @Autowired
    private ProductService productService;


    // Adding Expenses
    @PostMapping(value = "/addExpense")
    public void addExpense(@Valid @RequestBody Product product)
    {
        productService.addExpense(product);
    }


    //getting all products on a particular date
    @GetMapping(value = "/products/{date}")
    public List<Product> getExpenseByDate(@PathVariable LocalDate date)
    {
        return productService.getByDate(date);
    }

    //getting Monthly expense report using user Name  and total expense of the month

    @GetMapping(value = "/total/expense/{name}/{month}")
    public String getTotalExpenseByMonth(@PathVariable String name , @PathVariable Month month)
    {
        return productService.getTotalExpenseByMonth(name ,month);
    }

    //updating the expense

    @PutMapping(value = "/update/expense/{id}")
    public String updateExpense(@PathVariable Integer id,@RequestBody Product product)
    {
        return   productService.updateExpenseById(id, product);
    }

    //getting all expenses using name

    @GetMapping(value = "getByName/expense/{name}")
    public List<Product> getAllByName(@PathVariable String name){
        return productService.getAllByName(name);
    }

    @DeleteMapping(value = "/deleteById/{expenseId}")
    public String deleteByName(@PathVariable Integer expenseId)
    {
        return   productService.deleteById(expenseId);
    }


}
