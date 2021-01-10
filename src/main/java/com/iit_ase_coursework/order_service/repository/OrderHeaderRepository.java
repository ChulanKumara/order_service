package com.iit_ase_coursework.order_service.repository;

import com.iit_ase_coursework.order_service.model.table_model.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderHeaderRepository extends JpaRepository<OrderHeader,Integer> {
    @Query("SELECT o FROM OrderHeader o WHERE o.customerID=:customerId")
    List<OrderHeader> getByCustomer(@Param("customerId") int customerId);
}
