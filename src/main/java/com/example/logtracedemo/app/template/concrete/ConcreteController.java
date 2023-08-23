package com.example.logtracedemo.app.template.concrete;

import com.example.logtracedemo.app.service.OrderService;
import com.example.logtracedemo.app.template.AbstractTemplate;
import com.example.logtracedemo.common.logtrace.LogTrace;

public class ConcreteController extends AbstractTemplate {

    private final OrderService orderService;

    public ConcreteController(LogTrace logTrace, OrderService orderService) {
        super(logTrace);
        this.orderService = orderService;
    }

    @Override
    protected String call() {
        return orderService.getOrder();
    }
}
