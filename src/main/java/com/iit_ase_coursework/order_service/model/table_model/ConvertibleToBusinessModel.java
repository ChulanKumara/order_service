package com.iit_ase_coursework.order_service.model.table_model;

import com.iit_ase_coursework.order_service.model.business_model.BusinessModel;

public interface ConvertibleToBusinessModel {
    public BusinessModel toBusinessModel();
}
