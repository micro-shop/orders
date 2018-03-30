package cz.microshop.order.repository;

import cz.microshop.order.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface IOrderRepository extends MongoRepository<Order, Long> {
}
