package com.example.bike_commerce.customers.repositories;

import com.example.bike_commerce.customers.entities.Customer;
import com.example.bike_commerce.customers.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {
//    @Query(value = "SELECT * FROM bike_order INNER JOIN service_user ON bike_order WHERE service_user.id=?", nativeQuery = true)
//    List<Order> findOrdersByUserId(Long id);

//      @Query(value = "SELECT * FROM bike_order WHERE bike_order.customer_id = :userId", nativeQuery = true)
//      List<Order> findOrdersByUserId(@Param("userId")Long userId);
}