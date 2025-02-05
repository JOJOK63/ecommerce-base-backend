package com.ec.ecommerce_base_backend.services.imp;

import com.ec.ecommerce_base_backend.entities.Product;
import com.ec.ecommerce_base_backend.repositories.ProductRepositoryInterface;
import com.ec.ecommerce_base_backend.services.ProductServiceInterface;
import jakarta.validation.constraints.Null;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductRepositoryInterface productRepositoryInterface;

    @Override
    public List<Product> findAll() {
        return productRepositoryInterface.findAll();
    }

    /**
     *
     * @param id
     * @return Optional ( here to make a gestion of object if null or not )
     */
    @Override
    public Product findById(Long id){
        return productRepositoryInterface.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id){
        productRepositoryInterface.deleteById(id);
    }
}
