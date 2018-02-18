package com.lxt.core.timer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.*;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.util.Date;

import static org.quartz.JobBuilder.newJob;

/**
 * 定时任务动态配置管理类
 * 添加定时处理方法：定秒定次，定分定次，定小时定次，定秒、定分、定小时
 * 定corn表达式
 *
 * @author lixuetao
 * @version 1.0
 */
public class QuartzManager {

    private final static Log log = LogFactory.getLog(QuartzManager.class);
    static SchedulerFactoryBean sf = new SchedulerFactoryBean();

    /**
     * 添加hours小时执行一次，可执行count次的定时器
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     * @param jobClass
     * @param hours
     * @param count
     */
    public static void addJobToCountInHours(String jobName, String jobGroupName,
                                            String triggerName, String triggerGroupName,
                                            Class jobClass, int hours, int count){
        long milliseconds = hours * 3600000L;
        addJobInMilliseconds(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, milliseconds, count);
    }

    /**
     * 添加hours小时执行一次，可执行无数次的定时器
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     * @param jobClass
     * @param hours
     */
    public static void addJobInHours(String jobName, String jobGroupName,
                                       String triggerName, String triggerGroupName,
                                       Class jobClass, int hours){
        long milliseconds = hours * 3600000L;
        addJobInMilliseconds(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, milliseconds, 0);
    }

    /**
     * 添加minutes分钟执行一次，可执行count次的定时器
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     * @param jobClass
     * @param minutes
     * @param count
     */
    public static void addJobToCountInMinutes(String jobName, String jobGroupName,
                                            String triggerName, String triggerGroupName,
                                            Class jobClass, int minutes, int count){
        long milliseconds = minutes * 60000L;
        addJobInMilliseconds(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, milliseconds, count);
    }

    /**
     * 添加minutes分钟执行一次，可执行无数次的定时器
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     * @param jobClass
     * @param minutes
     */
    public static void addJobInMinutes(String jobName, String jobGroupName,
                                       String triggerName, String triggerGroupName,
                                       Class jobClass, int minutes){
        long milliseconds = minutes * 60000L;
        addJobInMilliseconds(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, milliseconds, 0);
    }

    /**
     * 添加seconds秒执行一次，可执行count次的定时器
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     * @param jobClass
     * @param seconds
     * @param count
     */
    public static void addJobToCountInSeconds(String jobName, String jobGroupName,
                                              String triggerName, String triggerGroupName,
                                              Class jobClass, int seconds, int count){
        long milliseconds = seconds * 1000L;
        addJobInMilliseconds(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, milliseconds, count);
    }

    /**
     * 添加seconds秒执行一次，可执行无数次的定时器
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     * @param jobClass
     * @param seconds
     */
    public static void addJobInseconds(String jobName, String jobGroupName,
                                       String triggerName, String triggerGroupName,
                                       Class jobClass, int seconds){
        long milliseconds = seconds * 1000L;
        addJobInMilliseconds(jobName, jobGroupName, triggerName, triggerGroupName, jobClass, milliseconds, 0);
    }

    /**
     * 按毫秒间隔添加定时任务，并可指定重复次数
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     * @param jobClass
     * @param milliseconds
     * @param count 重复次数，小于等于0，则不限制次数
     */
    public static void addJobInMilliseconds(String jobName, String jobGroupName,
                              String triggerName, String triggerGroupName,
                              Class jobClass, long milliseconds, int count) {
        try {
            Scheduler sched = sf.getScheduler();
            JobDetail job = newJob(jobClass).withIdentity(jobName, jobGroupName).build();// 任务名，任务组，任务执行类

            SimpleScheduleBuilder simpleSchedule = SimpleScheduleBuilder
                    .simpleSchedule()
                    .withIntervalInMilliseconds(milliseconds);
            if (count > 0){
                simpleSchedule.withRepeatCount(count);
            }

            // 触发器
            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroupName)
                    .startNow()
                    .withSchedule(simpleSchedule)
                    .build();
            Date ft = sched.scheduleJob(job, trigger);
            log.info(jobName + "启动于" + ft);
            // 启动
            if (!sched.isShutdown()) {
                sched.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 按cron表达式添加定时任务
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     * @param jobClass
     * @param cornTime
     */
    public static void addJobInCron(String jobName, String jobGroupName,
                                    String triggerName, String triggerGroupName,
                                    Class jobClass, String cornTime) {
        try {
            Scheduler sched = sf.getScheduler();
            JobDetail job = newJob(jobClass).withIdentity(jobName, jobGroupName).build();// 任务名，任务组，任务执行类

            CronScheduleBuilder cronSchedule = CronScheduleBuilder
                    .cronSchedule(cornTime);

            Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroupName)
                    .startNow()
                    .withSchedule(cronSchedule)
                    .build();

            Date ft = sched.scheduleJob(job, trigger);
            log.info(jobName + "启动于" + ft);
            // 启动
            if (!sched.isShutdown()) {
                sched.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 移除调度任务
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     */
    public static void removeJob(String jobName, String jobGroupName,
                                 String triggerName, String triggerGroupName){
        try{
            Scheduler scheduler = sf.getScheduler();
            TriggerKey triggerKey = new TriggerKey(triggerName, triggerGroupName);
            JobKey jobKey = new JobKey(jobName, jobGroupName);
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            scheduler.deleteJob(jobKey);
        }catch (SchedulerException e){
            e.printStackTrace();
        }
    }

    /**
     * 启动所有定时任务
     */
    public static void startJobs(){
        try{
            Scheduler scheduler = sf.getScheduler();
            scheduler.start();;
        }catch (SchedulerException e){
            e.printStackTrace();
        }
    }

    /**
     * 暂停所有定时任务
     */
    public static void shutdownJobs(){
        try{
            Scheduler scheduler = sf.getScheduler();
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
        }catch (SchedulerException e){
            e.printStackTrace();
        }
    }

}
