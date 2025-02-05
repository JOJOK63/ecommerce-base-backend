package com.ec.ecommerce_base_backend.services;

import com.ec.ecommerce_base_backend.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceInterface   {
    /**
     *
     * @return List<Product>
     */
    List<Product> findAll();

    Product findById(Long id);

    void deleteById(Long id);
}
