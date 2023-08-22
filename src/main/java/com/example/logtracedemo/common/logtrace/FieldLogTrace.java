package com.example.logtracedemo.common.logtrace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
//@Component
public class FieldLogTrace implements LogTrace {

    private TraceId traceIdHolder;

    @Override
    public TraceId begin(String message) {
        if (traceIdHolder == null) {
            traceIdHolder = new TraceId();
        } else {
            traceIdHolder.nextLevel();
        }

        log.info("[{}] {} {}", traceIdHolder.getTraceId(), addSpace("--->", traceIdHolder.getLevel()), message);

        return traceIdHolder;
    }

    private Object addSpace(String prefix, int level) {
        StringBuilder builder = new StringBuilder();
        for (int i=0; i <= level; i++) {
            builder.append(i==level ? "|" + prefix : "|    ");
        }
        return builder;
    }

    @Override
    public void end(String message) {
        log.info("[{}] {} {}", traceIdHolder.getTraceId(), addSpace("<---", traceIdHolder.getLevel()), message);

        if (traceIdHolder.getLevel() == 0) {
            traceIdHolder = null;
        } else {
            traceIdHolder.previousLevel();
        }

    }
}
