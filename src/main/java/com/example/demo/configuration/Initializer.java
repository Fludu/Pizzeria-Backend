package com.example.demo.configuration;

import com.example.demo.model.Meal;
import com.example.demo.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Initializer {
    @Autowired
    private MealService mealService;

    @PostConstruct
    public void postConstruct() {
        createMeals();
    }

    public void createMeals() {
        Meal meal=createMeal("Peperoni",29.99,"sos pomidorowy, oregano, pepperoni");
        Meal meal1=createMeal("Salami",29.99,"sos pomidorowy, oregano, salami");
        Meal meal2=createMeal("Capriciosa",29.99,"sos pomidorowy, oregano, szynka,cebula,ser");
        Meal meal3=createMeal("Wiejska",29.99,"sos pomidorowy, oregano, kielbasa wiejska");
        Meal meal4=createMeal("Margarita",29.99,"sos pomidorowy, oregano, pepperoni");
        mealService.saveMeal(meal);
        mealService.saveMeal(meal1);
        mealService.saveMeal(meal2);
        mealService.saveMeal(meal3);
        mealService.saveMeal(meal4);

    }

    public Meal createMeal(String name, double price, String ingredients) {
        return new Meal(name, price, ingredients);
    }
}
