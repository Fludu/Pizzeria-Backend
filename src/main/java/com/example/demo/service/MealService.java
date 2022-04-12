package com.example.demo.service;

import com.example.demo.model.Meal;
import com.example.demo.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MealService {
    private final MealRepository mealRepository;

    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    public void deleteMealById(Long id) {
        mealRepository.deleteById(id);
    }

    public Meal saveMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public void updateMeal(Meal meal) {
        mealRepository.save(meal);
    }

    public Meal getMealById(Long id){
        return mealRepository.findById(id).orElse(null);
    }

}
