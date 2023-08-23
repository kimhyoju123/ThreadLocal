package com.example.logtracedemo.app.strategy;

import com.example.logtracedemo.common.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InterfaceParamContext {

    private final LogTrace logTrace;

    public String execute(String message, Strategy strategy) {
        logTrace.begin(message);

        String result = strategy.call();

        logTrace.end(message);

        return result;
    }

}
