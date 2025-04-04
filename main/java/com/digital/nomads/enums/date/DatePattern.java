package com.digital.nomads.enums.date;

import lombok.Getter;

@Getter
public enum DatePattern {
    ENTRY_POINT_PATTERN("yyyy.MM.dd HH:mm:ss.SSS"),
    TEST_RAIL_PATTERN("yyyy-MM-dd HH:mm:ss.SSS"),
    DEFAULT_PATTERN("yyyy/MM/dd"),
    WEBHOOK_PATTERN("yyyy-MM-dd"),
    WEBHOOK_PATTERN3("yyyy-MM-dd HH:mm:ss"),
    WEBHOOK_PATTERN2("yyyyMMdd"),
    TIME_PATTERN("HH::mm::ss"),
    IB_PATTERN("dd/MM/yyyy"),
    BIFROST_PATTERN("yyyy.MM.dd"),
    PATTERN_WITHOUT_SSS("yyyy.MM.dd HH:mm:ss"),
    ;

    private final String value;

    DatePattern(String value) {
        this.value = value;
    }
}