package com.Udaan.lms.service;

import com.Udaan.lms.model.KeyAccManager;
import com.Udaan.lms.model.Restaurant;
import com.Udaan.lms.repository.KAMRepository;
import com.Udaan.lms.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KAMService {

    @Autowired
    private KAMRepository kamRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    public KeyAccManager saveKAM(KeyAccManager kam) {
        return kamRepository.save(kam);
    }

    public List<KeyAccManager> getAllKAMs() {
        return kamRepository.findAll();
    }

    public KeyAccManager getKAMById(Long id) {
        return kamRepository.findById(id).orElse(null);
    }

    public void deleteKAM(Long id) {
        kamRepository.deleteById(id);
    }

    public Restaurant updateKAMForRestaurant(Long restaurantId, Long kamId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        KeyAccManager kam = kamRepository.findById(kamId).orElse(null);
        if (restaurant != null && kam != null) {
            restaurant.setKam(kam);
            return restaurantRepository.save(restaurant);
        }
        return null;
    }
}
