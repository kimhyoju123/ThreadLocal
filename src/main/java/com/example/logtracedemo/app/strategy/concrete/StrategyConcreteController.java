package com.example.logtracedemo.app.strategy.concrete;

import com.example.logtracedemo.app.service.OrderService;
import com.example.logtracedemo.app.strategy.Strategy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StrategyConcreteController implements Strategy {

    private final OrderService orderService;
    @Override
    public String call() {
        return orderService.getOrder();
    }
}
