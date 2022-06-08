package com.example.mydelivery.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class RestaurantRequestDto {

    private Long id;
    // 가게이름
    @NotBlank(message = "STORE NAME cannot be empty")
    private String name;
    // 주문 최저가
    @NotBlank(message = "MINIMUM ORDER PRICE cannot be empty")
    @Range(min = 1000, max = 100000, message = "Range of ORDER PRICE is from 1,000 to 100,000")
    private Long minOrderPrice;
    // 배달비
    @NotBlank(message = "DELIVERY FEE cannot be empty")
    @Range(min = 0, max = 10000, message = "Range of ORDER PRICE is from 1,000 to 100,000")
    private Long deliveryFee;

    public void minOrderUnitIs100(){
        Long minOrderPrice = this.minOrderPrice;

        if ((minOrderPrice % 100) != 0) {
            System.out.println("ERROR 100");
        }
    }

    public void deliveryFeeUnitIs500(){
        Long deliveryFee = this.deliveryFee;

        if ((deliveryFee % 500) != 0) {
            System.out.println("ERROR 500");
        }
    }
}
