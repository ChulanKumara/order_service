package com.iit_ase_coursework.order_service.repository;

import com.iit_ase_coursework.order_service.model.table_model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {

}
