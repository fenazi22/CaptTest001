package com.example.captest.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MerchantStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "(must not be id empty)")
    private  Integer id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "(must not be productID empty)")
    private Integer productid;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "(must not be merchantID empty)")
    private Integer merchantid;

    @Column(columnDefinition = "int not null")
    @NotNull(message = "(must not be productID empty)")
    @Min(value = 10,message = "(have to be stock more than 10 at start)")
    private int  stock;





}
