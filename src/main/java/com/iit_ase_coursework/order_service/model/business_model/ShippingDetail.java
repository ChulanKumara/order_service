package com.iit_ase_coursework.order_service.model.business_model;


public class ShippingDetail {

    int detailId;
    String addressLine1;
    String addressLine2;
    String addressLine3;
    String country;
    String zipCode;
    String contactNo;
    int customerId;

    public int getdetailId() {
        return detailId;
    }


    public String getAddressLine1() {
        return addressLine1;
    }


    public String getAddressLine2() {
        return addressLine2;
    }

 
    public String getAddressLine3() {
        return addressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        this.addressLine3 = addressLine3;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int getcustomerId() {
        return customerId;
    }

    public void setcustomerId(int customerId) {
        this.customerId = customerId;
    }

    public ShippingDetail() {
    }

    public ShippingDetail(int detailId) {
        this.detailId = detailId;
    }
}
