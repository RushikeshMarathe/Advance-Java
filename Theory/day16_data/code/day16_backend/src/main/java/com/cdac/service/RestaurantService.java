package com.cdac.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cdac.entities.Restaurant;

public interface RestaurantService {
	
	 List<Restaurant> getAllOpenRestaurants();
	 

	 String addRestaurant(Restaurant newRestaurant);


	 
 String deleteDetails(Long restaurantId);

}
