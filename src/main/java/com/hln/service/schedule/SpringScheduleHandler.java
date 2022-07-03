package com.hln.service.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *  原生定时任务框架先天缺陷 单机 如果挂了 后果严重  此时 独立调度服务应运而生
 * 1 不支持分片任务
 * 2 不支持生命周期统一管理
 * 3 不支持集群
 * 4 不支持失败重试
 * 5  不支持动态调整
 * 6 无报警机制
 * 7 任务数据统计难以实现
 *
 *
 * 独立调度服务 调度中心HA  执行器HA 动态配置
 * 执行器 任务一 任务二
 * 执行器 任务一 任务二
 *  调度中心 RPC Route Scheduled <--执行器
 */
//@Component
//@EnableScheduling
public class SpringScheduleHandler {

    @Scheduled(cron = "*/5 * * * * *")
    public void execute(){
        System.out.println("Spring 原生定时任务执行...");
    }
}
