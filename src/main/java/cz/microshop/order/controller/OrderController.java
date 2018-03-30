package cz.microshop.order.controller;

import cz.microshop.order.model.Order;
import cz.microshop.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<ArrayList<Order>> createOrder(@RequestBody ArrayList<Order> orderList)   {
        return new ResponseEntity<ArrayList<Order>>((ArrayList<Order>) orderService.create(orderList), HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<Order> save(@RequestBody Order cart)   {
        return new ResponseEntity<>((Order) orderService.save(cart), HttpStatus.OK);
    }
/*
    @RequestMapping(value = "/find", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Cart> find(@RequestParam Long id)   {
        return new ResponseEntity<>(cartService.find(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/findByUserId", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Cart> find(@RequestParam Long id)   {
        return new ResponseEntity<>(cartService.find(id), HttpStatus.OK);
    }*/

}
