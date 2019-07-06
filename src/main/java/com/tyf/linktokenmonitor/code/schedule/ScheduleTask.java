package com.tyf.linktokenmonitor.code.schedule;

import com.tyf.linktokenmonitor.code.config.Constant;
import com.tyf.linktokenmonitor.code.entity.AccountInfo;
import com.tyf.linktokenmonitor.code.entity.DataConfig;
import com.tyf.linktokenmonitor.code.websocket.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduleTask {






    //3.添加定时任务
    @Scheduled(initialDelay=3000, fixedRate=5000)
    private void configureTasks() {



        Constant.list.forEach(ai->{

            try {
                WebSocketServer.sendInfo("aaa");
            } catch (IOException e) {
                e.printStackTrace();
            }


        });




    }

}
