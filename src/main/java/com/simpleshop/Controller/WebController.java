package com.simpleshop.Controller;

import com.simpleshop.Models.*;
import com.simpleshop.Services.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.validation.Valid;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class WebController {

    private UserService userService;
    private ProductService productService;
    private PasswordEncoder passwordEncoder;
    private OrdersService ordersService;
    private MailSenderService mailSenderService;
    private CompleteOrdersService completeOrdersService;

    public WebController(CompleteOrdersService  completeOrdersService, MailSenderService mailSenderService, UserService userService, ProductService productService, PasswordEncoder passwordEncoder, OrdersService ordersService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.productService = productService;
        this.ordersService = ordersService;
        this.mailSenderService = mailSenderService;
        this.completeOrdersService = completeOrdersService;
    }


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "login";
    }

    @GetMapping("/main")
    public String mainPage(Model model, Principal principal) {

        ordersService.calculateTotal(principal, model);
        ordersService.howMuchItemsInBasket(principal, model);

        model.addAttribute("order", new Orders());

        model.addAttribute("products", productService.getAllProducts().subList(0, 3));

        model.addAttribute("firstSlide1", productService.getAllProducts().get(0));
        model.addAttribute("firstSlide2", productService.getAllProducts().get(1));
        model.addAttribute("firstSlide3", productService.getAllProducts().get(2));

        model.addAttribute("secondSlide1", productService.getAllProducts().get(3));
        model.addAttribute("secondSlide2", productService.getAllProducts().get(4));
        model.addAttribute("secondSlide3", productService.getAllProducts().get(5));

        return "main";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDTO());
        return "register";
    }

    @GetMapping("/basket")
    public String getBasket(Model model, Principal principal) {
        ordersService.calculateTotal(principal, model);
        model.addAttribute("len", ordersService.ordersFromUser(userService.getIdActualLoggedUser(principal)).size());
        model.addAttribute("basket", ordersService.ordersFromUser(userService.getIdActualLoggedUser(principal)));
        return "basket";
    }

    @GetMapping("/filtered/{category}")
    public String get(@PathVariable String category, Model model, Principal principal) {
        ordersService.calculateTotal(principal, model);
        List<Product> filtered = productService.getAllProducts().stream().filter(i -> i.getCategory().equals(category)).collect(Collectors.toList());
        model.addAttribute("order", new Orders());
        model.addAttribute("fetched", filtered);
        ordersService.howMuchItemsInBasket(principal, model);
        return "filtered";
    }

    @GetMapping("/shop")
    public String getShop(Principal principal, Model model) {
        ordersService.calculateTotal(principal, model);
        ordersService.howMuchItemsInBasket(principal, model);
        model.addAttribute("order", new Orders());
        model.addAttribute("all", productService.getAllProducts());
        return "shop";
    }

    @PostMapping("/reg")
    public String reg(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult bindingResult) throws MessagingException {

        if (bindingResult.hasErrors()) {
            return "register";
        }
        User user = new User(userDTO.getUsername(), userDTO.getPassword(), "ROLE_USER", userDTO.getEmail(), userDTO.getPhoneNumber(), userDTO.getCode());
        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);

//        mailSenderService.sendMail(new Email(user.getEmail(), "Healthy Life - Welcome in our shop online"));
        return "redirect:/login";
    }

    @PostMapping("/addToCart")
    public String addTo(@RequestParam("id") Long id, @RequestParam("type") String type, @RequestParam("quantity") int quantity,  Principal principal) {
        var order = new Orders();
        order.setAuthorID(userService.findByUsername(principal.getName()).get().getId());
        order.setProduct(productService.findProductById(id));
        order.setType(type);
        order.setQuantity(quantity);
        ordersService.addOrder(order);
        return "redirect:/main";
    }

    @GetMapping("/payment")
    public String getPaymentPage(Model model, Principal principal) {
        ordersService.calculateTotal(principal, model);
        ordersService.howMuchItemsInBasket(principal, model);
        model.addAttribute("completeorder", new CompleteOrder());
        model.addAttribute("itemsToBuy", ordersService.ordersFromUser(userService.getIdActualLoggedUser(principal)));
        if (ordersService.totalPriceInCart(principal) > 0.00) {
            return "payment";
        }
        else {
            return "redirect:/basket";
        }
    }

    @PostMapping("/remove")
    public String removeItemFromBasket(@RequestParam("id") Long id, Principal principal) {
        ordersService.deleteOrderById(principal, id);
        return "redirect:/basket";
    }

    @PostMapping("/buy")
    public String buy(CompleteOrder completeOrder, Principal principal) throws MessagingException {
        completeOrder.setEmail(userService.findByUsername(principal.getName()).get().getEmail());

        StringBuilder items = new StringBuilder();
        String product;
        for (Orders x : ordersService.ordersFromUser(userService.getIdActualLoggedUser(principal))) {
            if (x.getType().equals("kg")) {
                product = x.getProduct().getName() + " " + "x" +  x.getQuantity() + " " +  x.getKgFormatPrice() + "\n";
                items.append(product);
            } else {
                product = x.getProduct().getName() + " " + "x" +  x.getQuantity() + " " +  x.getOneFormatPrice() + "\n";
                items.append(product);
            }
        }

        mailSenderService.sendMailWithOrder(new Email(completeOrder.getEmail(), "Healthy Life - your order",
                "<h1>Welcome</h1> " +
                        "<h3>we inform you that your order will be delivered within the next few days</h3>" +
                        "<h2>Your products: </h2>" +
                        items.toString()
        ));

        completeOrdersService.addCompleteOrder(completeOrder);
        ordersService.clearBasket(ordersService.ordersFromUser(userService.getIdActualLoggedUser(principal)));

        return "redirect:/main";
    }


}
