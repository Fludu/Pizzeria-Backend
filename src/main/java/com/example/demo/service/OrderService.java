package com.example.demo.service;

import com.example.demo.model.Client;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ClientService clientService;
    private final OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    public Order saveOrder(Order order) {
        Client client = clientService.getExact(order.getClient());
        order.setClient(client);
        client.addOrder(order);
        order.getMeals().forEach(meal -> meal.addFoodOrder(order));
        return orderRepository.save(order);
    }

    public void updateOrder(Order order) {
        orderRepository.save(order);
    }


    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }


}
