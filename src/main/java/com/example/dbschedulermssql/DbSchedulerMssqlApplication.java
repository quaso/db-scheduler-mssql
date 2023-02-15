package com.example.dbschedulermssql;

import com.github.kagkarlsson.scheduler.task.helper.PlainScheduleAndData;
import com.github.kagkarlsson.scheduler.task.helper.RecurringTaskWithPersistentSchedule;
import com.github.kagkarlsson.scheduler.task.helper.Tasks;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DbSchedulerMssqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbSchedulerMssqlApplication.class, args);
    }

    @Bean
    RecurringTaskWithPersistentSchedule<PlainScheduleAndData> task() {
        return Tasks.recurringWithPersistentSchedule("someTask", PlainScheduleAndData.class).execute(
                (taskInstance, executionContext) -> System.out.println(taskInstance.getData().getData())
        );
    }
}
