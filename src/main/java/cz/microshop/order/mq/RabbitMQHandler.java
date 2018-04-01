package cz.microshop.order.mq;

import cz.microshop.order.model.Order;
import cz.microshop.order.model.OrderStatus;
import cz.microshop.order.model.PaymentSuccess;
import cz.microshop.order.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by xnovm on 01.04.2018.
 */
@Service
public class RabbitMQHandler {

    @Autowired
    OrderService orderService;

    @RabbitListener(queues = "rabbit-foo")
    public void receiveString(PaymentSuccess data) {
        System.out.println("receiving rabbit message : " + data);
        Order order = orderService.find(data.getOrderId());
        if (order != null) {
            order.setStatus(OrderStatus.FINISHED);
            orderService.save(order);
        }
    }
}
