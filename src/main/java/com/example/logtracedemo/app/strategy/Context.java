package com.example.logtracedemo.app.strategy;

import com.example.logtracedemo.common.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Context {

    private final LogTrace logTrace;
    private final Strategy strategy;

    public String execute(String message) {
        logTrace.begin(message);

        String result = strategy.call();

        logTrace.end(message);

        return result;
    }


}
