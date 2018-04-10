package cz.microshop.order.service;

import cz.microshop.order.model.Order;
import cz.microshop.order.repository.OrderItemRepository;
import cz.microshop.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> create(List<Order> orderList) {
        return orderRepository.saveAll(orderList);
    }

    public Order save(Order order) {
        if (order.getOrderId() != null) {
            Order dbOrder = find(order.getOrderId());
            if (dbOrder != null) order.setId(dbOrder.getId());
        }
        if (order.getOrderId() == null) order.setOrderId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        return orderRepository.save(order);
    }

    public Order find(Long id) {
        return orderRepository.findByOrderId(id);
    }

    public List<Order> findByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
