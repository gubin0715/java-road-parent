package com.gubin.task.runner;

import com.gubin.task.task.TaskTestOne;
import com.gubin.task.task.TaskTestTwo;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class RunnerTaskEntity implements ApplicationRunner {

    @Resource
    private Scheduler scheduler;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        /**=====================定时任务=====================**/
        //任务名称
        String name = UUID.randomUUID().toString();
        //任务所属分组
        String group = TaskTestOne.class.getName();
        //执行规则
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0 0/1 * * * ?");
        //创建任务
        JobDetail jobDetail = JobBuilder.newJob(TaskTestOne.class).withIdentity(name, group).build();
        //创建任务触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(name, group).withSchedule(scheduleBuilder).build();
        //将触发器与任务绑定到调度器内
        scheduler.scheduleJob(jobDetail, trigger);


        /**=====================定时任务=====================**/
        //任务名称
        String name1 = UUID.randomUUID().toString();
        //任务所属分组
        String group1 = TaskTestTwo.class.getName();
        //执行规则
        CronScheduleBuilder scheduleBuilder1 = CronScheduleBuilder.cronSchedule("0 0/1 * * * ?");
        //创建任务
        JobDetail jobDetail1 = JobBuilder.newJob(TaskTestTwo.class).withIdentity(name1, group1).build();
        //创建任务触发器
        Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity(name1, group1).withSchedule(scheduleBuilder1).build();
        //将触发器与任务绑定到调度器内
        scheduler.scheduleJob(jobDetail1, trigger1);
    }
}
