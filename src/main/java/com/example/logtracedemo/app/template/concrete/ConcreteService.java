package com.example.logtracedemo.app.template.concrete;

import com.example.logtracedemo.app.template.AbstractTemplate;
import com.example.logtracedemo.common.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteService extends AbstractTemplate {
    public ConcreteService(LogTrace logTrace) {
        super(logTrace);
    }

    @Override
    protected String call() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            log.info("{}", e.getMessage());
        }

        return "getOrder";
    }
}
