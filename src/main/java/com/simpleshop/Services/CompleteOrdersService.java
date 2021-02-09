package com.simpleshop.Services;

import com.simpleshop.Models.CompleteOrder;
import com.simpleshop.Repositories.CompleteOrdersRepo;
import org.springframework.stereotype.Service;

@Service
public class CompleteOrdersService {

    private CompleteOrdersRepo completeOrdersRepo;

    public CompleteOrdersService(CompleteOrdersRepo completeOrdersRepo) {
        this.completeOrdersRepo = completeOrdersRepo;
    }

    public void addCompleteOrder(CompleteOrder completeOrder) {
        completeOrdersRepo.save(completeOrder);
    }



}
