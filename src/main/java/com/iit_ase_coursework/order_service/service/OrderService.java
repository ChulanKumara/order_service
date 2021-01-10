package com.iit_ase_coursework.order_service.service;

import com.iit_ase_coursework.order_service.model.table_model.OrderDetail;
import com.iit_ase_coursework.order_service.model.table_model.OrderHeader;
import com.iit_ase_coursework.order_service.repository.OrderDetailRepository;
import com.iit_ase_coursework.order_service.repository.OrderHeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class OrderService implements IOrderService {
    @Autowired
    OrderHeaderRepository orderHeaderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Override
    public List<OrderHeader> getByCustomer(int customerId) {
        return this.orderHeaderRepository.findAll();
    }
    @Override
    public List<OrderHeader> get() {
        return this.orderHeaderRepository.findAll();
    }


    @Override
    public OrderHeader get(int orderId) {
        return  this.orderHeaderRepository.findById(orderId).get();
    }

    @Override
    public void delete(int orderId) {
        this.orderHeaderRepository.deleteById(orderId);
    }

    @Override
    @Transactional
    public int create(OrderHeader orderHeader) {

         this.orderHeaderRepository.save(orderHeader).getOrderHeaderID();
        this.orderDetailRepository.saveAll(orderHeader.getOrderDetail());
        return orderHeader.getOrderHeaderID();
    }

    @Override
    public void update(OrderHeader orderHeader) {
        this.orderHeaderRepository.save(orderHeader);
    }
}
