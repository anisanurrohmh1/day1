package com.mega.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private  String id;

    @Column(nullable = false)
    private String name;

    private String address;

    public Branch(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
