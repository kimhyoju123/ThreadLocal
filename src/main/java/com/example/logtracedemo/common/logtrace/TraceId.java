package com.example.logtracedemo.common.logtrace;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TraceId {

    private String traceId;
    private int level;

    public TraceId() {
        this.traceId = UUID.randomUUID().toString().substring(0, 8);
        this.level = 0;
    }

    public void nextLevel() {
        this.level++;
    }

    public void previousLevel() {
        this.level--;
    }

}
