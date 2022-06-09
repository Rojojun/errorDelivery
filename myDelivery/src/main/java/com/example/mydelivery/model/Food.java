package com.example.mydelivery.model;

import com.example.mydelivery.dto.FoodRequestDto;
import com.example.mydelivery.dto.RestaurantRequestDto;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor // for builder
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Food {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;



    @Builder
    public Food ( String name, long price) {
        this.name = name;
        this.price = price;
    }



    public void registRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }


}