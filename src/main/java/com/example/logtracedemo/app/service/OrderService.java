package com.example.logtracedemo.app.service;

import com.example.logtracedemo.common.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final LogTrace logTrace;

    public String getOrder() { // 디자인 패턴 적용 전
        logTrace.begin("OrderService.getOrder()");

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            log.info("{}", e.getMessage());
        }

        logTrace.end("OrderService.getOrder()");

        return "result";
    }

}
