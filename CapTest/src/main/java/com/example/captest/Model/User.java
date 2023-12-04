package com.example.captest.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {


    @Id
    @NotNull(message = "must not be id empty")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(columnDefinition = "varchar(20) not null")
    @NotNull(message = "(must not be username empty)")
    @Size(min = 5, message = "(have to be more than 5 length long)")
    private String username;

    @Column(columnDefinition = "varchar(30) not null")
    @NotNull(message = "(must not be password empty)")
    @Size(min = 6, message = "(have to be more than 5 length long)")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d).+$", message = "have to be more than 6 length long, must have \n" +
            "characters and digits")
    private String password;

    @Column(columnDefinition = "varchar(30) not null")
    @NotNull(message = "(must not be empty, )")
    @Email(message = "(must be valid email)")
    private String email;

    @Column(columnDefinition = "varchar(20) not null check(role = 'Admin' or role = 'admin' or role = 'Customer' or role ='customer' )")
    @NotNull(message = "(must not be role empty)")
    @Pattern(regexp = "(Admin|admin|Customer|customer)", message = "have to be in ( “Admin”,”Customer”)")
    private String role;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "(must not be empty)")
    @PositiveOrZero(message = "have to be positive")
    private Integer balance;


}
