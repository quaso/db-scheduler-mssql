DROP TABLE IF EXISTS ScheduledTasks
CREATE TABLE ScheduledTasks
(
    task_name            varchar(250) not null,
    task_instance        varchar(250) not null,
    task_data            nvarchar(max),
    --task_data            varbinary(max),
    execution_time       datetime     not null,
    picked               bit,
    picked_by            text,
    last_success         datetime,
    last_failure         datetime,
    consecutive_failures int,
    last_heartbeat       datetime,
    version              bigint       not null,
    primary key (task_name, task_instance)
);