package com.digital.nomads.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class RetryManager {
    public static <T> T run(int retries, int waitInSeconds, Supplier<T> call) {
        var count = 0;
        while (count < retries) {
            log.warn("Attempt to execute request: {}", count);
            try {
                return call.get();
            } catch (Exception e) {
                log.error("Attempt to execute request failed with message:");
                log.error(e.getMessage());
                count++;
                WaitManager.pauseInSeconds(waitInSeconds);
            }
        }
        throw new IllegalArgumentException("Timed out waiting for " + retries + " retries");
    }
}