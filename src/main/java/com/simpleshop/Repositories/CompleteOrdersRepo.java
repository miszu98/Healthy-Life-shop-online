package com.simpleshop.Repositories;

import com.simpleshop.Models.CompleteOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompleteOrdersRepo extends JpaRepository<CompleteOrder, Long> {
}
