package com.example.bike_commerce.services;

import com.example.bike_commerce.customers.entities.Bike;
import com.example.bike_commerce.customers.repositories.BikeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Configurable
public class BikeService {
    @Autowired
    BikeRepository bikeRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public List<Bike> retrieveBikes() {
        return bikeRepository.findAll();
    }

    @Transactional
    public Optional<Bike> retrieveABike(Long bikeId) {

        return bikeRepository.findById(bikeId);
    }

    public void deleteABike(Long bikeId) {
        bikeRepository.deleteById(bikeId);
    }

    @Transactional
    public void postBikeAd(Bike bikeData) {
        entityManager.createNativeQuery("INSERT INTO bikes(name, model, price, warranty_status) VALUES (?,?,?,?)")
                .setParameter(1, bikeData.getName())
                .setParameter(2, bikeData.getModel())
                .setParameter(3, bikeData.getPrice())
                .setParameter(4, bikeData.getWarranty_status())
                .executeUpdate();
    }

    @Transactional
    public void purchaseBike(Optional<Bike> bikeData, Long userId) {
            bikeData.ifPresent(bike -> entityManager.createNativeQuery("INSERT INTO bike_order(product_id, customer_id, price) VALUES (?,?,?)")
                .setParameter(1, bike.getId())
                .setParameter(2, userId.intValue())
                .setParameter(3, bike.getPrice())
                .executeUpdate());
    }

}