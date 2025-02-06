package com.ec.ecommerce_base_backend.services;

import com.ec.ecommerce_base_backend.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInterface   {


    Product newProduct(Product product);

    /**
     *
     * @return List<Product>
     */
    List<Product> findAll();

    Optional<Product> findById(Long id);

    boolean deleteById(Long id);


}
