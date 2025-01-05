package com.Udaan.lms.service;

import com.Udaan.lms.model.Contact;
import com.Udaan.lms.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getContactsByRestaurantId(Long restaurantId) {
        return contactRepository.findByRestaurantId(restaurantId); 
    }

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}
