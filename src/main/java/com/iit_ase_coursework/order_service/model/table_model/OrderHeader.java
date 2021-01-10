package com.iit_ase_coursework.order_service.model.table_model;

import com.iit_ase_coursework.order_service.model.business_model.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_order_header")
public class OrderHeader implements TableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int orderHeaderID;
    @Basic(optional = false)
    @Column(name = "orderTimeStamp", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    java.util.Date orderTimeStamp;
     int customerID;
     int shippingDetailId;
    @OneToMany(mappedBy = "orderHeader")
    List<OrderDetail> orderDetail;

    public OrderHeader(int orderHeaderID ,Date orderTimeStamp, int customerID,List<OrderDetail> orderDetail,int shippingDetailId) {
        this.orderTimeStamp = orderTimeStamp;
        this.customerID = customerID;
        this.orderHeaderID=orderHeaderID;
        this.shippingDetailId = shippingDetailId;
        this.orderDetail =orderDetail;

    }

    public OrderHeader() {
    }
    public OrderHeader(int orderHeaderID) {
        this.orderHeaderID = orderHeaderID;
    }

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

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public List<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(List<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }

    @Override
    public BusinessModel toBusinessModel() {
        List<com.iit_ase_coursework.order_service.model.business_model.OrderDetail> orderDetails = new ArrayList<>();
        this.orderDetail.forEach(od->{
            orderDetails.add((com.iit_ase_coursework.order_service.model.business_model.OrderDetail)od.toBusinessModel());
        });
        com.iit_ase_coursework.order_service.model.business_model.OrderHeader orderHeader =
                new com.iit_ase_coursework.order_service.model.business_model.OrderHeader(this.orderHeaderID,this.orderTimeStamp
                        ,new Customer(this.customerID,""),orderDetails,new ShippingDetail(this.shippingDetailId));
        //orderHeader.setCustomer(new Customer(this.customerID,""));

        return orderHeader ;
    }
}

