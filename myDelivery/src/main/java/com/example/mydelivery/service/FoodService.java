package com.example.mydelivery.service;

import com.example.mydelivery.dto.FoodRequestDto;
import com.example.mydelivery.model.Food;
import com.example.mydelivery.model.Restaurant;
import com.example.mydelivery.repostory.FoodRepository;
import com.example.mydelivery.repostory.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository, RestaurantRepository restaurantRepository) {
        this.foodRepository = foodRepository;
        this.restaurantRepository = restaurantRepository;
    }

    // 음식 등록
    public void createFood(List<FoodRequestDto> requestDto, Long restaurantId) {

        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow( () -> new RuntimeException( "등록되지 않은 레스토랑입니다." ) );
                //.orElseThrow(RuntimeException::new);

        List<String> foodListByRestaurantId = foodRepository.findFoodNameByRestaurantId(restaurantId);//이미 등록된 푸드리스트조회

        // 신규로 등록된 푸드리스트 네임에 대한 벨리데이션 체크를 위해 따로 list로 뺌
        List<String> requestFoodNames = new ArrayList<>();
        for (FoodRequestDto foodRequestDto : requestDto) {
            requestFoodNames.add(foodRequestDto.getName());
        }

        // 신규로 등록될 푸드들의 네임 중복체크
        for (int i = 0; i < requestFoodNames.size(); i++) {
            String foodName1 = requestFoodNames.get(i);
            for (int j = 0; j < requestFoodNames.size(); j++) {
                if (i == j) {
                    continue;
                }
                String foodName2 = requestFoodNames.get(j);
                if (foodName1.equals(foodName2)) { //신규로 등록될 푸드중에 중복된 네임이 있으면 에러처리
                    throw new RuntimeException("요청된 음식리스트 중에 중복된 음식이 있습니다.");
                }
            }
        }

        for (FoodRequestDto foodRequestDto : requestDto) {
            Long requestFoodPrice = foodRequestDto.getPrice();
            String requestFoodName = foodRequestDto.getName();

            //이미 등록된 푸드와 신규로 등록될 푸드명 비교
            for (String foodNameByRestaurantId : foodListByRestaurantId) {
                if (requestFoodName.equals(foodNameByRestaurantId)) {
                    throw new RuntimeException("이미 등록된 음식입니다.");
                }
            }

            //가격
            if (requestFoodPrice < 100 || requestFoodPrice > 1000000) {
                throw new RuntimeException("가아아아아격.");
            }

            //최소주문가격 체크
            // int price = foodPrice;

            if ((requestFoodPrice % 100) != 0) {
                throw new RuntimeException("최소 주문가격을 확인해 주세요.");
            }

            Food food = foodRequestDto.toEntity();
            food.registRestaurant(restaurant);
            foodRepository.save(food);
        }
    }

    @Transactional(readOnly = true)
    public List<Food> getFood(Long restaurantId) {
        List<Food> foods = foodRepository.findAllByRestaurantId(restaurantId);
        return foods;
    }
}


//    public Food createFood(FoodRequestDto requestDto, Long restaurantId){
//        Food food = foodRepository.findById(restaurantId);
//        List<String> saveFoodNameListByRestaruantId =foodRepository.
//                foodRepository.save(food);
//
//        return food;
