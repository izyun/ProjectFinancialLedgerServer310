package com.example.projectFinancialLedgerServer310.component.useLocalMethod;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//@Component : 어디에서나 접근가능하여 class를 사용할 수 있도록 선언 = @Bean : Container라는 영역에서 대기하는 인스턴스
@Component
public class useTimeMethod {

    public static String timeData() {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        String logDate = dateTime.format(formatter);
        return logDate;
    }
    public static String currentYear() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY");
        String logYear = date.format(formatter);
        return logYear;
    }

    public static String currentMonth() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        String logMonth = date.format(formatter);
        return logMonth;
    }

    public static String currentDay() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        String logDay = date.format(formatter);
        return logDay;
    }

}
