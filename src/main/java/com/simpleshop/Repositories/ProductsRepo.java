package com.simpleshop.Repositories;

import com.simpleshop.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductsRepo extends JpaRepository<Product, Long> {

    Product findProductById(Long id);
}
