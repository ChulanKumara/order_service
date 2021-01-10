package com.iit_ase_coursework.order_service.controller;

import com.iit_ase_coursework.order_service.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.iit_ase_coursework.order_service.model.business_model.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    IOrderService orderService;
    @PostMapping("/order")
    public void createOrder(@RequestBody OrderHeader order){
        this.orderService.create((com.iit_ase_coursework.order_service.model.table_model.OrderHeader)order.toTableModel());
    }
    @PatchMapping("/order")
    public void updateCustomer(@RequestBody OrderHeader order){
        this.orderService.create((com.iit_ase_coursework.order_service.model.table_model.OrderHeader)order.toTableModel());
    }


    @GetMapping("/order")
    public List<OrderHeader> getAllOrders(){
        List<OrderHeader> allOrders = new ArrayList<>();
        this.orderService.get().forEach(oh->{
            allOrders.add((OrderHeader) oh.toBusinessModel());
        });
        return  allOrders;
    }
    @GetMapping("/order/{orderId}")
    public OrderHeader getOrder(@PathVariable int orderId){
        return (OrderHeader) orderService.get(orderId).toBusinessModel();
    }

    @GetMapping("/order/cus/{customerId}")
    public List<OrderHeader> getOrderByCustomerId(@PathVariable int customerId){
        List<OrderHeader> allOrders = new ArrayList<>();
        this.orderService.getByCustomer(customerId).forEach(oh->{
            allOrders.add((OrderHeader) oh.toBusinessModel());
        });
        return  allOrders;
    }

    @DeleteMapping("/order/{orderId}")
    public void deleteCustomer(@PathVariable int orderId){
        orderService.delete(orderId);
    }
}
