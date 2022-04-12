package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "clients")
@Getter
@Setter
public class Client {
    public Client() {
        this.orderList = new ArrayList<>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String lastName;
    @NotNull
    @NotEmpty
    private String street;
    @NotNull
    @NotEmpty
    private String city;
    @NotNull
    @NotEmpty
    private String email;
    @NotNull
    @JsonIgnore
    @OneToMany(mappedBy = "client", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Order> orderList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(lastName, client.lastName) && Objects.equals(street, client.street) && Objects.equals(city, client.city) && Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, street, city, email);
    }

    public void addOrder(Order order) {
        this.orderList.add(order);
    }

    @PrePersist
    public void prePersist() {
        if (orderList == null) {
            this.orderList = new ArrayList<>();
        }
    }
}
