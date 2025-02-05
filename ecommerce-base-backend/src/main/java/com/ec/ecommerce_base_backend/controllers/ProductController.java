package com.ec.ecommerce_base_backend.controllers;

import com.ec.ecommerce_base_backend.entities.Product;
import com.ec.ecommerce_base_backend.repositories.ProductRepositoryInterface;
import com.ec.ecommerce_base_backend.services.ProductServiceInterface;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServiceInterface serviceInterface;


    @GetMapping("/")
    public List<Product> getAll(){
        System.out.println(serviceInterface.findAll());
        return serviceInterface.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> getOne(@PathVariable Long id){
        return new ResponseEntity<>( serviceInterface.findById(id), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        serviceInterface.deleteById(id);
    }

}
