package com.example.mydelivery.dto;

import com.example.mydelivery.model.Food;
import com.example.mydelivery.model.Restaurant;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class FoodRequestDto {

    private Long restaurantId;

    private Long id;
    // 음식명
    @NotBlank(message = "Name cannot be empty")
    private String name;
    // 음식가격
    @NotBlank(message = "Price cannot be empty")
    private Long price;
    // 음식점 고유값



   public Food toEntity() {
        return Food.builder()
                .name(this.name)
                .price(this.price)
                .build();
    }


}