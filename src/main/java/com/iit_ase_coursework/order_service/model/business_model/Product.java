package com.iit_ase_coursework.order_service.model.business_model;



public class Product {

    int productId;
    String productName;
    String productCategory;
    String productDescription;
    int quantityLeft;
    double sellingPrice;

    public Product(int productId, String productName, String productCategory, String productDescription, int quantityLeft, double sellingPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.quantityLeft = quantityLeft;
        this.sellingPrice = sellingPrice;
    }
    public Product(int productId) {
        this.productId = productId;

    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }


    public String getProductCategory() {
        return productCategory;
    }


    public String getProductDescription() {
        return productDescription;
    }


    public int getQuantityLeft() {
        return quantityLeft;
    }


    public double getSellingPrice() {
        return sellingPrice;
    }

}
