package com.example.bike_commerce.customers.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "bike_order")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_id")
    private int product_id;

    @Column(name = "customer_id")
    private int customer_id;

    @Column(name = "date_created")
    private Date date_created;

    public Long getId() {
        return id;
    }

    public Date getDateCreated() {
        return date_created;
    }

    public int getCustomerId() {
        return customer_id;
    }

    public int getProductId() {
        return product_id;
    }

    // SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setDateCreated(Date dateCreated) {
        this.date_created = dateCreated;
    }

    public void setCustomerId(int customer_id) {
        this.customer_id = customer_id;
    }

    public void setProductId(int product_id) {
        this.product_id = product_id;
    }
}