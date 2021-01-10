package com.iit_ase_coursework.order_service.model.business_model;



import com.iit_ase_coursework.order_service.model.table_model.TableModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderHeader implements BusinessModel {
    int orderHeaderID;
    java.util.Date orderTimeStamp;
    Customer customer;
    List<OrderDetail> orderDetails;
    ShippingDetail shippingDetail;
    public int getOrderHeaderID() {
        return orderHeaderID;
    }

    public void setOrderHeaderID(int orderHeaderID) {
        this.orderHeaderID = orderHeaderID;
    }

    public Date getOrderTimeStamp() {
        return orderTimeStamp;
    }

    public void setOrderTimeStamp(Date orderTimeStamp) {
        this.orderTimeStamp = orderTimeStamp;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public ShippingDetail getShippingDetail() {
        return shippingDetail;
    }

    public void setShippingDetail(ShippingDetail shippingDetail) {
        this.shippingDetail = shippingDetail;
    }

    public OrderHeader(int orderHeaderID, Date orderTimeStamp, Customer customer, List<OrderDetail> orderDetails, ShippingDetail shippingDetail) {
        this.orderHeaderID = orderHeaderID;
        this.orderTimeStamp = orderTimeStamp;
        this.customer = customer;
        this.orderDetails = orderDetails;
        this.shippingDetail = shippingDetail;
    }

    @Override
    public TableModel toTableModel() {
      List<com.iit_ase_coursework.order_service.model.table_model.OrderDetail> orderDetails = new ArrayList<>()  ;
      this.orderDetails.forEach(od->{
          com.iit_ase_coursework.order_service.model.table_model.OrderDetail tb = (com.iit_ase_coursework.order_service.model.table_model.OrderDetail) od.toTableModel();
          orderDetails.add(tb);
      });
      return  new com.iit_ase_coursework.order_service.model.table_model.OrderHeader(this.orderHeaderID,this.orderTimeStamp,this.customer.getCustomerId(),orderDetails,this.shippingDetail.detailId);
    }
}
