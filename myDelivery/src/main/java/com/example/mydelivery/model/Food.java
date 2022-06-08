package com.example.mydelivery.model;

import com.example.mydelivery.dto.FoodRequestDto;
import com.example.mydelivery.dto.RestaurantRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class Food {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Restaurant restaurant;

    public Food(FoodRequestDto requestDto) {
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }

    @Builder
    public Food (String name, Long price, Restaurant restaurant) {
        this.name = name;
        this.price = price;
    }

    public void registRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}