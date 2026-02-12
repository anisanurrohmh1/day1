package com.mega.demo.repository;


import com.mega.demo.entity.Nasabah;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NasabahRepo extends JpaRepository<Nasabah, String> {
}