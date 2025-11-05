package com.cdac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ResourceAlreadyExists;
import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dao.RestaurantDao;
import com.cdac.entities.Restaurant;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	private RestaurantDao restaurantDao;

	@Override
	public List<Restaurant> getAllOpenRestaurants() {
		
		return restaurantDao.findByStatusTrue();
		//return restaurantDao.findByStatus(true);
	}

	@Override
	public String addRestaurant(Restaurant newRestaurant) {
		//checks if restaurant with same name already exists!!
		if(restaurantDao.existsByName(newRestaurant.getName()))
		{
			//dup restaurant name
//			return "restaurant with the same name already exists!!!";  //removing only for status code to add
			throw new ResourceAlreadyExists("Duplicate Restaurant!..");
		}
		
		//=> new restaurant name -> set status : true
		newRestaurant.setStatus(true);
		//save the details
		Restaurant persistentRestaurant = restaurantDao.save(newRestaurant);
		
		return "Added new Restaurant with ID="+persistentRestaurant.getId();
	}

	@Override
	public String deleteDetails(Long restaurantId) {

		//validate restaurant id
		
		Restaurant restaurant = restaurantDao.findById(restaurantId)
				.orElseThrow(()-> new ResourceNotFoundException("Invalid restaurant id!..."));
		//=> restaurant : persistent
		//setter - status :false
		//restaurantDao.deleteById(restaurantId);
		restaurant.setStatus(false);
		return "soft deleted restaurant details";
		//no exc -> tx.commit() -> DML - update -> session close
		
	}

	public String updateDetails(Restaurant restaurantToUpdate)
	{
		
		
		
		return "";
	}
	
	
	
	

}
