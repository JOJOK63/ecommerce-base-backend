package com.ec.ecommerce_base_backend.entities;

import com.ec.ecommerce_base_backend.enumeration.State;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@Data   // create automatically getters, setters, toString, equals et hashCode
@NoArgsConstructor  // generate constructor whitout args
@AllArgsConstructor //  generate constructor whitout args
@Builder // instanciation automaticly withouth ... new Object
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column
    String name;

    @Column
    String description;

    @Column
    float price;

    @Column
    int stock;

    @Column
    float weight;

    @Column
    LocalDateTime createdAt;

    @Column
    LocalDateTime updatedAt;

    State state;

    /*
    * Images
    * Category
    * Comments
    * Rating
    * */

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
