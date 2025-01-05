package com.Udaan.lms.controller;

import com.Udaan.lms.model.Interaction;
import com.Udaan.lms.service.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interactions")
public class InteractionController {

    @Autowired
    private InteractionService interactionService;

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Interaction>> getInteractionsByRestaurantId(@PathVariable Long restaurantId) {
        List<Interaction> interactions = interactionService.getInteractionsByRestaurantId(restaurantId);
        if (interactions.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(interactions);
    }

    @PostMapping
    public ResponseEntity<Interaction> createInteraction(@RequestBody Interaction interaction) {
        try {
            Interaction savedInteraction = interactionService.saveInteraction(interaction);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedInteraction);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInteraction(@PathVariable Long id) {
        try {
            interactionService.deleteInteraction(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
