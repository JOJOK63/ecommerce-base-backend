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

    @PostMapping("/new")
    public ResponseEntity<Product> newProduct(@RequestBody Product product) {
        System.out.println("coucou");
        System.out.println(product);
        Product savedProduct = serviceInterface.newProduct(product);
        System.out.println(savedProduct.toString());
        return ResponseEntity.status(201).body(savedProduct);
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = serviceInterface.findAll();
        System.out.println( " la liste dans le controller : " + products.toString());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getOne(@PathVariable Long id) {
        return serviceInterface.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        boolean deleted = serviceInterface.deleteById(id);
        if (deleted) {
            //return ResponseEntity.noContent().build(); // 204 No Content
            return ResponseEntity.status(200).body("Produit" + id +  "supprimé avec succés !");
        } else {
            //return ResponseEntity.notFound().build(); // 404 Not Found
            return ResponseEntity.status(404).body("Produit non trouvé !");
        }
    }
}
