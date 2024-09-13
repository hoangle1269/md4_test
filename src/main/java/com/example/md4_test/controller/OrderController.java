package com.example.md4_test.controller;

import com.example.md4_test.model.Order;
import com.example.md4_test.model.Product;
import com.example.md4_test.model.ProductType;
import com.example.md4_test.service.IOrderService;
import com.example.md4_test.service.IProductService;
import com.example.md4_test.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductTypeService productTypeService;

    @GetMapping
    public String findAll(@PageableDefault(value = 5) Pageable pageable, Model model) {
        Page<Order> orders = orderService.findAll(pageable);
        model.addAttribute("orders", orders);
        return "orders/list";
    }

    @GetMapping("/{id}/edit")
    public String editOrder(@PathVariable("id") Long id, Model model) {
        Order order = orderService.findById(id);
        if (order == null) {
            // Handle order not found
            return "redirect:/orders";
        }
        List<Product> products = productService.findAll();
        List<ProductType> productTypes = productTypeService.findAll();
        model.addAttribute("order", order);
        model.addAttribute("products", products);
        model.addAttribute("productTypes", productTypes);
        return "orders/edit";
    }

//    @PostMapping("/{id}/update")
//    public String updateOrder(@PathVariable("id") Long id, @ModelAttribute @Valid Order order, BindingResult result) {
//        if (result.hasErrors()) {
//            return "orders/edit";
//        }
//
//        Order existingOrder = orderService.findById(id);
//        if (existingOrder != null) {
//            existingOrder.setPurchaseDate(order.getPurchaseDate());
//            existingOrder.setQuantity(order.getQuantity());
//            existingOrder.setProduct(order.getProduct());
//            orderService.updateOrder(existingOrder);
//        }
//        return "redirect:/orders";
//    }


//    @PostMapping("/{id}/update")
//    public String updateOrder(@PathVariable("id") Long id, @ModelAttribute Order order) {
//        Order existingOrder = orderService.findById(id);
//        if (existingOrder != null) {
//            existingOrder.setPurchaseDate(order.getPurchaseDate());
//            existingOrder.setQuantity(order.getQuantity());
//            existingOrder.setProduct(order.getProduct());
//            orderService.updateOrder(existingOrder);
//        }
//        return "redirect:/orders";
//    }

    @PostMapping("/{id}/update")
    public String updateOrder(@PathVariable("id") Long id, @ModelAttribute Order order) {
        Order existingOrder = orderService.findById(id);
        if (existingOrder != null) {
            existingOrder.setPurchaseDate(order.getPurchaseDate());
            existingOrder.setQuantity(order.getQuantity());
            existingOrder.setProduct(order.getProduct());
            orderService.updateOrder(existingOrder);
        }
        return "redirect:/orders";
    }


    @GetMapping("/create")
    public String createOrderForm(Model model) {
        Order order = new Order();
        List<Product> products = productService.findAll();
        List<ProductType> productTypes = productTypeService.findAll();
        model.addAttribute("order", order);
        model.addAttribute("products", products);
        model.addAttribute("productTypes", productTypes);
        return "orders/create";
    }

    @PostMapping("/create")
    public String createOrder(@ModelAttribute Order order) {
        orderService.saveOrder(order);
        return "redirect:/orders";
    }

}
