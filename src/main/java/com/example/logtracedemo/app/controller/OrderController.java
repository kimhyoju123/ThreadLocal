package com.example.logtracedemo.app.controller;

import com.example.logtracedemo.app.service.OrderService;
import com.example.logtracedemo.app.strategy.Context;
import com.example.logtracedemo.app.strategy.InterfaceParamContext;
import com.example.logtracedemo.app.strategy.Strategy;
import com.example.logtracedemo.app.strategy.concrete.StrategyConcreteController;
import com.example.logtracedemo.app.template.AbstractTemplate;
import com.example.logtracedemo.app.template.concrete.ConcreteController;
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

        // Strategy 인터페이스를 파라미터 받는 전략패턴 == 템플릿 콜백 패턴
        InterfaceParamContext context = new InterfaceParamContext(logTrace);
        return context.execute("OrderController.getOrder()", () -> {
            return orderService.getOrder();
        });

    }

}
