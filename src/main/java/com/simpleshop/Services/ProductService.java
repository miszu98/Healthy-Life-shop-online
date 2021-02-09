package com.simpleshop.Services;

import com.simpleshop.Models.Product;
import com.simpleshop.Repositories.ProductsRepo;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class ProductService {

    private ProductsRepo productsRepo;

    public ProductService(ProductsRepo productsRepo) {
        this.productsRepo = productsRepo;
    }

    public void addProduct(Product product) {
        productsRepo.save(product);
    }

    public void deleteProduct(Product product) {
        productsRepo.delete(product);
    }

    public List<Product> getAllProducts() {
        return productsRepo.findAll();
    }


    public Product findProductById(Long id) {
        return productsRepo.findProductById(id);
    }

}
