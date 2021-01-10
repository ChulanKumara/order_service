package com.iit_ase_coursework.order_service.service;
import com.iit_ase_coursework.order_service.model.table_model.OrderHeader;

import java.util.List;

public interface IOrderService {
    public List<OrderHeader> get();
    public OrderHeader get(int orderId);
    public void delete(int orderId);
    public int create(OrderHeader orderHeader);
    public void  update(OrderHeader orderHeader);
    public List<OrderHeader> getByCustomer(int customerID);

}
