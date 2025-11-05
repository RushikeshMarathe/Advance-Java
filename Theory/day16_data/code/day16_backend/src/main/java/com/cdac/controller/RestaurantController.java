package com.cdac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdac.dao.RestaurantDao;
import com.cdac.entities.Restaurant;
import com.cdac.service.RestaurantService;

@RestController
@RequestMapping("/restauants")
public class RestaurantController {

    private final RestaurantDao restaurantDao;
	@Autowired
	private RestaurantService restaurantService;

    RestaurantController(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }
	
//	@GetMapping("/restaurant")
	public ResponseEntity<?> getRestaurants(){
		
		/*
		 * Project Tips for REST compliant resp
		 * instead of sending response body, send entire resp packet
		 * 
		 * 
		 * Use ResponseEntity class - to send resp packet
		 * 
		 * In case of no available restaurants
		 * -SC-204
		 * 
		 * In case of available restaurants
		 * -SC 200, resp body - List
		 */
		 
		List<Restaurant> allOpenRestaurants = restaurantService.getAllOpenRestaurants();
		
		if(allOpenRestaurants.isEmpty())
		{
			//sts code SC
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			//SC 204
		}else {
			//non empty
			return ResponseEntity.ok(allOpenRestaurants);
			//SC 200, body -list
		}
	}
	
	
	

	/*
	 * Desc - add new restaurant
	 * URL = http://host:port/restaurants
	 * Method - POST
	 * Response - Success - SC 201 + success mesg
	 * SC 400 + err messg
	 * 
	 * 
	 */
	
	@PostMapping
	public ResponseEntity<?> addNewRestaurant(@RequestBody Restaurant newRestaurant
											  )
	{
		try {
			String message = restaurantService.addRestaurant(newRestaurant);
			// => success
			return ResponseEntity.status(HttpStatus.CREATED).body(message);
			
		}catch(RuntimeException e) {
			System.out.println("err "+ e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
	
	
	/*
	 * Desc - delete existing restaurant.
	 * URL - http://host:port/restaurants/ Mehtod - POST
	 * Resp - success - SC 201 + success mesg
	 * SC 400
	 */
	
	@DeleteMapping("/{restaurantId}")
	public ResponseEntity<?> deleteRestaurantDetails(@PathVariable Long restaurantId)
	{
		System.out.println("in delete details"+restaurantId);
		
		try {
			return ResponseEntity.ok(
			restaurantService.deleteDetails(restaurantId));
			
		}catch(RuntimeException e)
		{
			System.out.println("err"+e);
			return ResponseEntity.notFound().build();
		}
//		return null;
	}
	
	
	@PutMapping
	public ResponseEntity<?> modifyRetaurantDetails(@RequestBody Restaurant restaurantToUpdate)
	{
		
		try {
			if(restaurantDao.existsById(restaurantToUpdate.getId()))
			{
				
			}else {
				
			}
		}catch(RuntimeException e)
		{
			System.out.println(e);
		}
		
	}
	
}
