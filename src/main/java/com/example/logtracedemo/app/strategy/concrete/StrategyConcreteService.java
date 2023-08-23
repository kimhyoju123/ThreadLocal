package com.example.logtracedemo.app.strategy.concrete;

import com.example.logtracedemo.app.strategy.Strategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyConcreteService implements Strategy {
    @Override
    public String call() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            log.info("{}", e.getMessage());
        }

        return "getOrder";
    }
}
