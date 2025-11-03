package com.example.order_service.controller;

import com.example.order_service.client.ProductClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {

    private ProductClient productClient;

    public OrdersController(ProductClient productClient){
        this.productClient=productClient;
    }

    @GetMapping
    public String get(){
        String responseFromProductService = productClient.get("Gojo");
        return "order service çalıştı. product service'ten gelen cevap: " + responseFromProductService;
    }
}
