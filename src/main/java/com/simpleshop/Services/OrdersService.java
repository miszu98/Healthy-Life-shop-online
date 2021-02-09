package com.simpleshop.Services;

import com.simpleshop.Models.Orders;
import com.simpleshop.Repositories.OrdersRepo;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


import java.security.Principal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

@Service
public class OrdersService {

    private OrdersRepo ordersRepo;
    private UserService userService;

    public OrdersService(OrdersRepo ordersRepo, UserService userService) {
        this.ordersRepo = ordersRepo;
        this.userService = userService;
    }

    public List<Orders> getAllOrders() {
        return ordersRepo.findAll();
    }

    public void addOrder(Orders orders) {
        ordersRepo.save(orders);
    }

    public List<Orders> ordersFromUser(Long id) {
        return ordersRepo.findOrdersByAuthorID(id);
    }

    public void howMuchItemsInBasket(Principal principal, Model model) {
        try {
            model.addAttribute("len", ordersFromUser(userService.getIdActualLoggedUser(principal)).size());
        } catch (NullPointerException ex) {
            model.addAttribute("len", 0);
        }
    }

    public double totalPriceInCart(Principal principal) {
        double total = 0;

        for (Orders order : ordersFromUser(userService.getIdActualLoggedUser(principal))) {
            if (order.getType().equals("kg")) {
                total += order.getProduct().getPricePerKg() * order.getQuantity();
            } else {
                total += order.getProduct().getPricePerOne() * order.getQuantity();
            }
        }
        return total;
    }

    public String formatTotalPriceInCart(Principal principal) {
        return NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(totalPriceInCart(principal));
    }

    public void calculateTotal(Principal principal, Model model) {
        try {
            model.addAttribute("total", formatTotalPriceInCart(principal));
        } catch (NullPointerException ex) {
            model.addAttribute("total", NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(0));
        }
    }

    public void deleteOrderById(Principal principal, Long id) {
        for (Orders x : getAllOrders()) {
            if (x.getAuthorID().equals(userService.getIdActualLoggedUser(principal)) && x.getId().equals(id)) {
                ordersRepo.delete(x);
            }
        }
    }

    public void clearBasket(List<Orders> productsFromBasket) {
        for (Orders x : productsFromBasket) {
            ordersRepo.delete(x);
        }
    }



}
