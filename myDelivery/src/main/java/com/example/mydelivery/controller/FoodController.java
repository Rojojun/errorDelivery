package com.example.mydelivery.controller;

import com.example.mydelivery.dto.FoodRequestDto;
import com.example.mydelivery.model.Food;
import com.example.mydelivery.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodController {

    private final FoodService foodService;

    @Autowired
    public FoodController(FoodService foodService) {this.foodService = foodService;}

    // 음식점에 음식 등록
    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void createFood(@RequestBody List<FoodRequestDto> requestDto, @PathVariable Long restaurantId) {
        foodService.createFood(requestDto, restaurantId);
        //응답보내기
    }

    // 음식점에 음식 조회
    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> getFood(@PathVariable Long restaurantId) {
        return foodService.getFood(restaurantId);
    }
}
