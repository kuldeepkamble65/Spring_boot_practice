package com.example.sheduleDemo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduledTaskService {

//    @Scheduled(fixedRate = 5000)
//    public void execute() {
//        // some logic that will be executed on a schedule
//        System.out.println("Code is being executed..."+System.currentTimeMillis());
//    }



  //  private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

//    @Scheduled(fixedRate = 5000, initialDelay = 4000)
//    public void execute() throws InterruptedException {
//        // some logic that will be executed on a schedule
//        System.out.println("Code is being executed... Time: " + formatter.format(LocalDateTime.now()));
//
//    }

    // To run every 5 minutes.
//    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
//
//    @Scheduled(cron = "0 */5 * * * *")
//    public void execute() {
//        // Some logic that will be executed on a schedule
//        System.out.println("Code is being executed... Time: " + formatter.format(LocalDateTime.now()));
//    }

    // To run every 2 hours.
//    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
//
//    @Scheduled(cron = "0 0 */2 * * ?")
//    public void execute() {
//        // Some logic that will be executed every 2 hours
//        System.out.println("Code is being executed... Time: " + formatter.format(LocalDateTime.now()));
//    }

    // Every 10 th day of Month.
//    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
//
//    @Scheduled(cron = "0 0 0 10 * ?")
//    public void execute() {
//        // Some logic that will be executed on the 10th day of every month
//        System.out.println("Code is being executed... Time: " + formatter.format(LocalDateTime.now()));
//    }


    // On 10th-17th day of month.
//    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
//
//    @Scheduled(cron = "0 0 0 10-17 * ?")
//    public void execute() {
//        // Some logic that will be executed from the 10th to the 17th day of every month
//        System.out.println("Code is being executed... Time: " + formatter.format(LocalDateTime.now()));
//    }

    // On 24th APR of every year.
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

    @Scheduled(cron = "0 0 0 24 4 ?")
    public void execute() {
        // Some logic that will be executed on the 24th of April every year
        System.out.println("Code is being executed... Time: " + formatter.format(LocalDateTime.now()));
    }

}
