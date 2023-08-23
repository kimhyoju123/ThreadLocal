package com.example.logtracedemo.app.service;

import com.example.logtracedemo.app.strategy.Context;
import com.example.logtracedemo.app.strategy.InterfaceParamContext;
import com.example.logtracedemo.app.strategy.Strategy;
import com.example.logtracedemo.app.strategy.concrete.StrategyConcreteController;
import com.example.logtracedemo.app.strategy.concrete.StrategyConcreteService;
import com.example.logtracedemo.app.template.AbstractTemplate;
import com.example.logtracedemo.app.template.concrete.ConcreteService;
import com.example.logtracedemo.common.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final LogTrace logTrace;

    public String getOrder() {

        // Strategy 인터페이스를 파라미터 받는 전략패턴 == 템플릿 콜백 패턴
        InterfaceParamContext context = new InterfaceParamContext(logTrace);
        return context.execute("OrderService.getOrder()", () -> {
            return "getOrder";
        });

    }

}
