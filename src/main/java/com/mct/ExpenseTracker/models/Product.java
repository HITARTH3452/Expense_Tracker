package com.mct.ExpenseTracker.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer expenseId ;

    @NotEmpty
    private String title ;

    @NotEmpty
    private String description;

    @NotEmpty
    private Double price;
    private LocalDate date;


    @ManyToOne
    @JoinColumn(name = "fk_user")
    private User user ;

}
