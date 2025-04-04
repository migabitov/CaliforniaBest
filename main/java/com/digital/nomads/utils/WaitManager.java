package com.digital.nomads.utils;

import lombok.extern.slf4j.Slf4j;
import org.awaitility.Awaitility;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WaitManager {

    public static void pause(Integer milliseconds) {
        try {
            log.info("Waiting for {} milliseconds", milliseconds);
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void pauseInSeconds(Integer seconds) {
        try {
            log.info("Waiting for {} seconds", seconds);
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitUntil(long maxTimeout, long pollInterval, Callable<Boolean> action, String alias) {
        Awaitility
                .await().await(alias)
                .atMost(maxTimeout, TimeUnit.SECONDS).ignoreExceptions()
                .pollInSameThread().pollInterval(pollInterval, TimeUnit.SECONDS)
                .until(action);
    }

    public static boolean retryUntil(long maxTimeout, long pollInterval, Callable<Boolean> action, String alias) {
        try {
            Awaitility.await(alias)
                    .atMost(maxTimeout, TimeUnit.SECONDS)
                    .ignoreExceptions()
                    .pollInSameThread()
                    .pollInterval(pollInterval, TimeUnit.SECONDS)
                    .until(action);
            return true; // Успешно дождались
        } catch (Exception e) {
            return false; // Не дождались, истек таймаут
        }
    }
}
