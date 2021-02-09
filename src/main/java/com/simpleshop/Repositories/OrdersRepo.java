package com.simpleshop.Repositories;

import com.simpleshop.Models.Orders;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Long> {

    List<Orders> findOrdersByAuthorID(Long id);

}
