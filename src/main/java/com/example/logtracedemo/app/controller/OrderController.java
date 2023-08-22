package com.example.logtracedemo.app.controller;

import com.example.logtracedemo.app.service.OrderService;
import com.example.logtracedemo.common.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final LogTrace logTrace;

    @GetMapping("/")
    public String getOrder() {
        logTrace.begin("OrderController.getOrder()");

        String result = orderService.getOrder();

        logTrace.end("OrderController.getOrder()");

        return result;
    }

}
