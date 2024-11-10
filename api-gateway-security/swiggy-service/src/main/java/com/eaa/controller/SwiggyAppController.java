package com.eaa.controller;

import com.eaa.dto.OrderResponseDTO;
import com.eaa.service.SwiggyAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/swiggy")
public class SwiggyAppController {

    @Autowired
    private SwiggyAppService service;

    @GetMapping("/home")
    public String greetingMessage() {
        return service.greeting();
    }

    @GetMapping("/{orderId}")
    public OrderResponseDTO checkOrderStatus(@PathVariable String orderId, @RequestHeader("loggedInUser") String username) {
        System.out.println("logged in user details : - " +username);
        return service.checkOrderStatus(orderId);
    }
}
