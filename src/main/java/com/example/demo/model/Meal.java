package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "meals")
@Getter
@Setter
public class Meal {

    public Meal() {
        this(0l, "", 0, "",new ArrayList<>());
    }
    public Meal(String name,double price,String ingredients){
        this(0l,name,price,ingredients,new ArrayList<>());
    }

    public Meal(Long id, String name, double price, String ingredients) {
        this(id, name, price, ingredients, new ArrayList<>());
    }

    public Meal(Long id, String name, double price, String ingredients, List<Order> orders) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.orders = orders;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private String name;

    private double price;
    @NotNull
    @NotEmpty
    private String ingredients;
    @NotNull
    @JsonIgnore
    @ManyToMany(mappedBy = "meals", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Order> orders;


    public void addFoodOrder(Order order){
        orders.add(order);
    }

}
