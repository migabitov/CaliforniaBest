package com.digital.nomads.utils.date_time;


import com.digital.nomads.enums.date.DatePattern;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    /**
     * Возвращает сегодняшнюю дату в заданном текстовом формате.
     */
    public static String getTodayDateFormatted(DatePattern pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern.getValue());
        return LocalDate.now().format(formatter);
    }

    /**
     * Возвращает дату, отстоящую от текущей на заданное количество лет, в заданном текстовом формате.
     */
    public static String getFutureDateFormatted(DatePattern pattern, int years) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern.getValue());
        return LocalDate.now().plusYears(years).format(formatter);
    }

    /**
     * Возвращает строковое представление даты в заданном текстовом формате.
     */
    public static String formatDate(LocalDate localDate, DatePattern pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern.getValue());
        return localDate.format(formatter);
    }

    /**
     * Преобразует строку с датой из одного текстового формата в другой.
     */
    public static String convertDateFormat(String date, DatePattern inputPattern, DatePattern outputPattern) {
        // Форматтер для входного формата
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputPattern.getValue());

        // Парсим дату (используем LocalDate для даты без времени)
        LocalDateTime localDateTime = LocalDateTime.parse(date, inputFormatter);

        // Форматтер для выходного формата
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputPattern.getValue());

        // Преобразуем в новый формат
        return localDateTime.format(outputFormatter);
    }
}
