package com.example.bike_commerce.services;

import com.example.bike_commerce.customers.entities.Bike;
import com.example.bike_commerce.customers.entities.Order;
import com.example.bike_commerce.customers.repositories.OrderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Configurable
public class OrderService {
    public OrderService() {}

    @Autowired
    OrderRepository orderRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<Order> retrieveOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public List<Order>  getOrdersForUser(Long userId) {
        TypedQuery<Order> query = entityManager.createQuery("SELECT o FROM Order o WHERE o.customer_id=:userId", Order.class);
        query.setParameter("userId", userId.intValue());
        return query.getResultList();
    }
}