package com.example.logtracedemo.common.logtrace;

public interface LogTrace {
    TraceId begin(String message);
    void end(String message);
}
