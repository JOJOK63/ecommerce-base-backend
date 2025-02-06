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
        List<Product> products = productRepositoryInterface.findAll();
        System.out.println("liste dans le service : " + products);
        return products;
    }

    @Override
    public Product newProduct(Product product) {
        return productRepositoryInterface.save(product);
    }

    /**
     *
     * @param id
     * @return Optional ( here to make a gestion of object if null or not )
     */
    @Override
    public Optional<Product> findById(Long id) {
        return productRepositoryInterface.findById(id);
    }


    @Override
    public boolean deleteById(Long id) {
        if (productRepositoryInterface.existsById(id)) {
            productRepositoryInterface.deleteById(id);
            return true;
        }
        return false;
    }

}
