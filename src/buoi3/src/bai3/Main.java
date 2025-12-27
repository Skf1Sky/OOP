package bai3;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String dateStr1 = "25/12/2025";
        LocalDate date1 = LocalDateUtil.fromString_ddMMyyyy(dateStr1);
        System.out.println("Parsed from dd/MM/yyyy: " + date1);

        String dateStr2 = "2025/12/26";
        LocalDate date2 = LocalDateUtil.fromString_yyyyMMdd(dateStr2);
        System.out.println("Parsed from yyyy/MM/dd: " + date2);

        LocalDate currentDate = LocalDate.now();
        System.out.println("Current date object: " + currentDate);

        String formatted1 = LocalDateUtil.toString_ddMMyyyy(currentDate);
        System.out.println("Formatted to dd/MM/yyyy: " + formatted1);

        String formatted2 = LocalDateUtil.toString_yyyyMMdd(currentDate);
        System.out.println("Formatted to yyyy/MM/dd: " + formatted2);
    }
}