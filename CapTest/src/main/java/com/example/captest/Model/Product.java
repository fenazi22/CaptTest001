package com.example.captest.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @NotNull(message = "must not be empty")
    private  Integer id;

    @Column(columnDefinition = "varchar(20) not null")
    @NotNull(message = "must not be name empty")
   @Size(min = 3,message = "must  to be name more than 3 length long")
    private  String name;

    @Column(columnDefinition = "double ")
    @NotNull(message = "must not be  price empty")
    @PositiveOrZero(message = "must not be empty, must be positive number")
    private Double price;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "must not be categoryID empty")
    private  Integer categoryID;


}
