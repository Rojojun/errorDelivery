package com.example.mydelivery.repostory;

import com.example.mydelivery.model.Restaurant;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
