package com.example.mydelivery.service;

import com.example.mydelivery.dto.FoodRequestDto;
import com.example.mydelivery.dto.RestaurantRequestDto;
import com.example.mydelivery.model.Food;
import com.example.mydelivery.model.Restaurant;
import com.example.mydelivery.repostory.FoodRepository;
import com.example.mydelivery.repostory.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant createRestaurant(RestaurantRequestDto requestDto) {
        Restaurant restaurant = new Restaurant(requestDto);
        restaurantRepository.save(restaurant);

        return restaurant;
    }

    // 상품을 찾아랏!
    public List<Restaurant> getRestaurant() {return restaurantRepository.findAll();}
}
