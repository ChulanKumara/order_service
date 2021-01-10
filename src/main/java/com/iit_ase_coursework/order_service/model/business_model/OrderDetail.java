package com.iit_ase_coursework.order_service.model.business_model;

import com.iit_ase_coursework.order_service.model.table_model.TableModel;

public class OrderDetail implements BusinessModel {
    int orderDetailId;
    Product product;
    int quantity;
    int orderHeaderId;
    public int getOrderDetailId() {
        return orderDetailId;
    }


    public Product getProduct() {
        return product;
    }

    public void setProductId(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public OrderDetail(int orderDetailId, Product product,int quantity,int orderHeaderId) {
        this.orderDetailId = orderDetailId;
        this.product = product;
        this.quantity = quantity;
        this.orderHeaderId = orderHeaderId;
    }

    @Override
    public TableModel toTableModel() {
        return new com.iit_ase_coursework.order_service.model.table_model.OrderDetail(this.orderDetailId,this.product.productId,this.quantity
                ,new com.iit_ase_coursework.order_service.model.table_model.OrderHeader(this.orderHeaderId));
    }
}
