package com.example.demo.controller;

import com.example.demo.model.Meal;
import com.example.demo.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/meals")
public class MealController {
    @Autowired
    private MealService mealService;

    @GetMapping()
    public ResponseEntity<List<Meal>> getMeals() {
        List<Meal> allMeals = mealService.getAllMeals();
        return ResponseEntity.ok(allMeals);
    }

    @PostMapping()
    public ResponseEntity<Meal> addMeal(@RequestBody Meal meal) {
        Meal createdMeal = mealService.saveMeal(meal);
        return ResponseEntity.status(201).body(createdMeal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Meal> deleteMeal(@PathVariable Long id) {
        mealService.deleteMealById(id);
        return ResponseEntity.ok(mealService.getMealById(id));
    }

    @PutMapping()
    public ResponseEntity<Meal> updateMeal(@RequestBody Meal meal) {
        mealService.updateMeal(meal);
        return ResponseEntity.ok(meal);
    }


}
