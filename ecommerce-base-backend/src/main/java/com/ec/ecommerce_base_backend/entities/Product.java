    package com.ec.ecommerce_base_backend.entities;

    import com.ec.ecommerce_base_backend.enumeration.State;
    import jakarta.persistence.*;
    import lombok.*;
    import lombok.experimental.FieldDefaults;

    import java.time.LocalDateTime;

    @Data  // create automatically getters, setters, toString, equals et hashCode
    @NoArgsConstructor  // generate constructor whitout args
    @AllArgsConstructor //  generate constructor whitout args
    @Builder // instanciation automaticly withouth ... new Object
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Entity
    @Table(name = "products")
    public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
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

        @Enumerated(EnumType.STRING)  // <-- Convertit l'ENUM en String dans la BDD
        @Column
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

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public int getStock() {
            return stock;
        }

        public void setStock(int stock) {
            this.stock = stock;
        }

        public float getWeight() {
            return weight;
        }

        public void setWeight(float weight) {
            this.weight = weight;
        }

        public LocalDateTime getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
        }

        public LocalDateTime getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
        }

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", price=" + price +
                    ", stock=" + stock +
                    ", weight=" + weight +
                    ", createdAt=" + createdAt +
                    ", updatedAt=" + updatedAt +
                    ", state=" + state +
                    '}';
        }
    }
