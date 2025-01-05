package com.Udaan.lms.service;

import com.Udaan.lms.model.Interaction;
import com.Udaan.lms.repository.InteractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InteractionService {

    @Autowired
    private InteractionRepository interactionRepository;

    public List<Interaction> getInteractionsByRestaurantId(Long restaurantId) {
        return interactionRepository.findAll(); 
    }

    public Interaction saveInteraction(Interaction interaction) {
        return interactionRepository.save(interaction);
    }

    public void deleteInteraction(Long id) {
        interactionRepository.deleteById(id);
    }
}
