package com.example.captest.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor

public class Category {

    @Id
    @NotNull(message = "must not be id empty")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotNull(message = "must not be id empty")
    @Size(min = 4,message = "must be name more than 3 length long")
   @Column(columnDefinition = "varchar(20) not null")
    private  String name;

}
