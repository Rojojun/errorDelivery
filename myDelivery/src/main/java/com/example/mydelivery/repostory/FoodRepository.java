package com.example.mydelivery.repostory;

import com.example.mydelivery.model.Food;
import com.example.mydelivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food,Long> {

    @Query("select f.name from Food f where f.restaurant.id = :restaurantId")
    List<String> findFoodNameByRestaurantId(Long restaurantId);

    List<Food> findAllByRestaurantId(Long restaurantId);
}
