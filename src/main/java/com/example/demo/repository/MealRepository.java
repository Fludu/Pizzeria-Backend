package com.example.demo.repository;

import com.example.demo.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface MealRepository extends JpaRepository<Meal,Long> {
    Optional<Meal> findByName(String name);

}
