package cz.microshop.order.service;

import cz.microshop.order.model.Order;
import cz.microshop.order.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private IOrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> create(List<Order> orderList) {
        return orderRepository.saveAll(orderList);
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> findByUserId(Long userId) {
        return orderRepository.findAll();
    }

}
