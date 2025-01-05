package com.Udaan.lms.controller;

import com.Udaan.lms.model.KeyAccManager;
import com.Udaan.lms.model.Restaurant;
import com.Udaan.lms.service.KAMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/kams")
public class KAMController {

    @Autowired
    private KAMService kamService;

    @PostMapping
    public KeyAccManager createKAM(@RequestBody KeyAccManager kam) {
        return kamService.saveKAM(kam);
    }

    @GetMapping("/{id}")
    public KeyAccManager getKAMById(@PathVariable Long id) {
        return kamService.getKAMById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteKAM(@PathVariable Long id) {
        kamService.deleteKAM(id);
    }

    @PutMapping("/restaurant/{restaurantId}/kam/{kamId}")
    public Restaurant updateKAMForRestaurant(@PathVariable Long restaurantId, @PathVariable Long kamId) {
        return kamService.updateKAMForRestaurant(restaurantId, kamId);
    }
}
