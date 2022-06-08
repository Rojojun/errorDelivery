package com.example.mydelivery.controller;

import com.example.mydelivery.dto.FoodRequestDto;
import com.example.mydelivery.dto.RestaurantRequestDto;
import com.example.mydelivery.model.Food;
import com.example.mydelivery.model.Restaurant;
import com.example.mydelivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) { this.restaurantService = restaurantService; }

    // 신규 음식점 등록
    @PostMapping("/restaurant/register")
    public Restaurant createRestaurant(@RequestBody RestaurantRequestDto requestDto) {
        Restaurant restaurant = restaurantService.createRestaurant(requestDto);

        // 응답 보내기
        return restaurant;
    }

    // 음식점 확인

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurant() {
        List<Restaurant> restaurants = restaurantService.getRestaurant();
        return restaurants;
    }
}
