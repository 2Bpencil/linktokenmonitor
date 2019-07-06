package com.tyf.linktokenmonitor.code.schedule;

import com.tyf.linktokenmonitor.code.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduleTask {

    @Autowired
    private WebSocketServer webSocketServer;

    //3.添加定时任务
    @Scheduled(initialDelay=3000, fixedRate=5000)
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        try {
            webSocketServer.sendMessage("aaa");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
