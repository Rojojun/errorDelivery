package com.example.mydelivery.dto;

import com.example.mydelivery.model.Food;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FoodRequestDto {
    // 음식명
    @NotBlank(message = "Name cannot be empty")
    private String name;
    // 음식가격
    @NotBlank(message = "Price cannot be empty")
    private Long price;
    // 음식점 고유값

    public Food toEntity() {
        return Food.builder().name(name).price(price).build();
    }

//    public Food toEntity() {
//        return Food.builder().name(name).price(price).build();
//    }
}