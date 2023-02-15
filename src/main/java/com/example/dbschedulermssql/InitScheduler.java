package com.example.dbschedulermssql;

import com.github.kagkarlsson.scheduler.Scheduler;
import com.github.kagkarlsson.scheduler.task.helper.PlainScheduleAndData;
import com.github.kagkarlsson.scheduler.task.helper.RecurringTaskWithPersistentSchedule;
import com.github.kagkarlsson.scheduler.task.schedule.Schedules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitScheduler {
    @Autowired
    private Scheduler scheduler;

    @Autowired
    private RecurringTaskWithPersistentSchedule<PlainScheduleAndData> task;

    @PostConstruct
    public void init() {
        scheduler.schedule(task.schedulableInstance("id",
                new PlainScheduleAndData(Schedules.cron("* * * * * *"), "dummy")));
    }
}
