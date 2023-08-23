package com.example.logtracedemo.app.template;

import com.example.logtracedemo.common.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractTemplate {

    private final LogTrace logTrace;

    // 템플릿 메소드
    public String execute(String message) {
        logTrace.begin(message);

        String result = call();

        logTrace.end(message);

        return result;
    }

    protected abstract String call();

}
