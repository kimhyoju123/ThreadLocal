package com.example.logtracedemo.common.logtrace;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ThreadLocalLogTrace implements LogTrace {
//    private TraceId traceIdHolder;
    private ThreadLocal<TraceId> traceIdHolder = new ThreadLocal<>();

    @Override
    public TraceId begin(String message) {
        if (traceIdHolder.get() == null) {
            traceIdHolder.set(new TraceId());
        } else {
            traceIdHolder.get().nextLevel();
        }

        log.info("[{}] {} {}", traceIdHolder.get().getTraceId(), addSpace("--->", traceIdHolder.get().getLevel()), message);

        return traceIdHolder.get();
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
        log.info("[{}] {} {}", traceIdHolder.get().getTraceId(), addSpace("<---", traceIdHolder.get().getLevel()), message);

        if (traceIdHolder.get().getLevel() == 0) {
            traceIdHolder.remove();
        } else {
            traceIdHolder.get().previousLevel();
        }
    }
}
