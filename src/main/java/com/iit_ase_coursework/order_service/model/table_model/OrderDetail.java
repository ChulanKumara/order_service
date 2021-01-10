package com.iit_ase_coursework.order_service.model.table_model;

import com.iit_ase_coursework.order_service.model.business_model.BusinessModel;
import com.iit_ase_coursework.order_service.model.business_model.Product;

import javax.persistence.*;
@Entity
@Table(name = "tb_order_detrails")
public class OrderDetail implements TableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int orderDetailId;
    int productId;
    int quantity;
    @ManyToOne(cascade = CascadeType.ALL)
    OrderHeader orderHeader;

    public OrderDetail() {
    }

    public OrderDetail(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public OrderDetail(int orderDetailId, int productId, int quantity,OrderHeader orderHeader) {
        this.orderDetailId = orderDetailId;
        this.productId = productId;
        this.quantity = quantity;
        this.orderHeader = orderHeader;
    }

    @Override
    public BusinessModel toBusinessModel() {
        return new com.iit_ase_coursework.order_service.model.business_model.OrderDetail(this.orderDetailId,
                new Product(this.productId),this.quantity,this.orderHeader.orderHeaderID);

    }
}
