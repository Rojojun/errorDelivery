package com.example.mydelivery.repostory;

import com.example.mydelivery.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food,Long> {

    List<Food> findAllByRestaurantId(Long restaurantId);
    @Query("select f.name from Food f where f.restaurant.id = :restaurantId")
    List<String> findFoodNameByRestaurantId(Long restaurantId);
}
