package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product3;


@Repository
public interface ProductRepository extends JpaRepository<Product3, Long> {
}

