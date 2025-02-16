package com.ec.ecommerce_base_backend.repositories;

import com.ec.ecommerce_base_backend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepositoryInterface extends JpaRepository<Product, Long> {

}
