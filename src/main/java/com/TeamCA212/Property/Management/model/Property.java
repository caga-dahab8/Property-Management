package com.TeamCA212.Property.Management.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String address;
    private String ownerName;
    private double rentalPrice;
    private String status;
}
