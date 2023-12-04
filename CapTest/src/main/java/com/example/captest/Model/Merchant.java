package com.example.captest.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = " (must not be id empty)")
    private Integer id;

    @NotNull(message = " (must not be name empty)")
    @Size(min = 3,message = " (have to be more name than 3 length long).")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;


}
