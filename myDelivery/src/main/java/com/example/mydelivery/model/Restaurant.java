package com.example.mydelivery.model;

import com.example.mydelivery.dto.RestaurantRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Restaurant {

    // ID 자동 생성 및 증가
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 입력 값을 받아와야함!!!
    // 중복 값은 안되요!!
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Long min_order_price;

    @Column(nullable = false)
    private Long delivery_fee;

    // 가게를 등록할 때 이용~~!!
    public Restaurant(RestaurantRequestDto requestDto) {
        this.name = requestDto.getName();
        this.min_order_price = requestDto.getMinOrderPrice();
        this.delivery_fee = requestDto.getDeliveryFee();
    }
}
