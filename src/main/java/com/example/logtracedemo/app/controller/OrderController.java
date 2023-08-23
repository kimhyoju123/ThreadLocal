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
//        logTrace.begin("OrderController.getOrder()");
//
//        String result = orderService.getOrder();
//
//        logTrace.end("OrderController.getOrder()");
//
//        return result;

        // 템플릿 메소드 패턴
//        AbstractTemplate abstractTemplate = new ConcreteController(logTrace, orderService);
//        return abstractTemplate.execute("OrderController.getOrder()");

        // 익명 클래스로 템플릿 메소드 패턴
//        AbstractTemplate abstractTemplate = new AbstractTemplate(logTrace) {
//            @Override
//            protected String call() {
//                return orderService.getOrder();
//            }
//        };
//        return abstractTemplate.execute("OrderController.getOrder()");

        // 전략 패턴
//        Strategy strategy = new StrategyConcreteController(orderService);
        // 익명 클래스
//        Strategy strategy = new Strategy() {
//            @Override
//            public String call() {
//                return orderService.getOrder();
//            }
//        };
        // 람다식
//        Strategy strategy = () -> {
//            return orderService.getOrder();
//        };
//        Context context = new Context(logTrace, strategy);
//        return context.execute("OrderController.getOrder()");

        // Strategy 인터페이스를 파라미터 받는 전략패턴 == 템플릿 콜백 패턴
        InterfaceParamContext context = new InterfaceParamContext(logTrace);
        return context.execute("OrderController.getOrder()", () -> {
            return orderService.getOrder();
        });

    }

}
