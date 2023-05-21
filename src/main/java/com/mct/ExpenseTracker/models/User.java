package com.mct.ExpenseTracker.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @NotEmpty
    @NotNull
    private String user_name;

    @Email
    private String userEmail;
    private String user_password;

    public User(String user_name, String userEmail, String user_password) {
        this.user_name = user_name;
        this.userEmail = userEmail;
        this.user_password = user_password;
    }

}
