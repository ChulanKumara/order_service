package com.iit_ase_coursework.order_service.model.business_model;

import com.iit_ase_coursework.order_service.model.table_model.TableModel;

public interface ConvertibleToTableModel {
    public TableModel toTableModel();
}
