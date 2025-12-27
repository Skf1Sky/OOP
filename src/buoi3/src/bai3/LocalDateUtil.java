package bai3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateUtil {
    private static final DateTimeFormatter FORMATTER_DD_MM_YYYY = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter FORMATTER_YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public static LocalDate fromString_ddMMyyyy(String date) {
        return LocalDate.parse(date, FORMATTER_DD_MM_YYYY);
    }

    public static LocalDate fromString_yyyyMMdd(String date) {
        return LocalDate.parse(date, FORMATTER_YYYY_MM_DD);
    }

    public static String toString_ddMMyyyy(LocalDate date) {
        return date.format(FORMATTER_DD_MM_YYYY);
    }

    public static String toString_yyyyMMdd(LocalDate date) {
        return date.format(FORMATTER_YYYY_MM_DD);
    }
}
