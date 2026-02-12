package com.mega.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "products")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    private Double price;

    @ManyToOne()
    @JoinColumn(name = "branch_id")
    private Branch branch;

    public Product(String name, Double price, Branch branch) {
        this.name = name;
        this.price = price;
        this.branch = branch;
    }

}