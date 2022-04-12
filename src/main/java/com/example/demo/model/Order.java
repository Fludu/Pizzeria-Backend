package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.Getter;

import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "orders_meals",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id", referencedColumnName = "id")
    )
    private List<Meal> meals;

    public Order() {
        this.meals = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    private Client client;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;


    @PreRemove
    public void preRemove() {
        this.client = null;
        this.meals = new ArrayList<>();
    }

    @PrePersist
    public void prePersist() {
        this.date = new Date();
    }


}
