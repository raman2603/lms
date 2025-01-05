package com.Udaan.lms.controller;

import com.Udaan.lms.dto.RestaurantDTO;
import com.Udaan.lms.model.Restaurant;
import com.Udaan.lms.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class RestaurantControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RestaurantService restaurantService;

    @BeforeEach
    public void setup() {
        // Initialize test data
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Test Restaurant");
        restaurant.setAddress("123 Test Street");
        restaurant.setLeadStatus("New");
        restaurantService.saveRestaurant(restaurant);

        // Configure TestRestTemplate with basic authentication
        restTemplate = restTemplate.withBasicAuth("john_doe", "password");
    }

    @SuppressWarnings("null")
    @Test
    public void testGetAllRestaurantsShouldReturnListOfRestaurants() {
        ResponseEntity<RestaurantDTO[]> response = restTemplate.getForEntity("/api/restaurants/all", RestaurantDTO[].class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotEmpty();
        assertThat(response.getBody()[0].getName()).isEqualTo("Test Restaurant");
    }

    @SuppressWarnings("null")
    @Test
    public void testGetRestaurantByIdShouldReturnRestaurant() {
        ResponseEntity<RestaurantDTO> response = restTemplate.getForEntity("/api/restaurants/2", RestaurantDTO.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("Test Restaurant");
    }

    @SuppressWarnings("null")
    @Test
    public void testCreateRestaurantShouldReturnCreatedRestaurant() {
        Restaurant newRestaurant = new Restaurant();
        newRestaurant.setName("New Restaurant");
        newRestaurant.setAddress("456 New Street");
        newRestaurant.setLeadStatus("Active");

        ResponseEntity<RestaurantDTO> response = restTemplate.postForEntity("/api/restaurants", newRestaurant, RestaurantDTO.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getName()).isEqualTo("New Restaurant");
    }

}
