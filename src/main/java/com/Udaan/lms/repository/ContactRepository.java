package com.Udaan.lms.repository;

import com.Udaan.lms.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByRestaurantId(Long restaurantId);
}
