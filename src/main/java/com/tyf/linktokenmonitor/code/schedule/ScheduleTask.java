package com.tyf.linktokenmonitor.code.schedule;

import com.tyf.linktokenmonitor.code.config.Constant;
import com.tyf.linktokenmonitor.code.entity.AccountInfo;
import com.tyf.linktokenmonitor.code.utils.HttpClientUtil;
import com.tyf.linktokenmonitor.code.utils.MusicUtil;
import com.tyf.linktokenmonitor.code.websocket.WebSocketServer;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduleTask {


    //3.添加定时任务
    @Scheduled(initialDelay=10000, fixedRate=10000)
    private void configureTasks() {

        for (AccountInfo ai :Constant.list) {
            String transactionRecords = HttpClientUtil.getDataByAddr(ai.getAccountNum(),0);
            JSONObject transactionRecordsObj = JSONObject.fromObject(transactionRecords);
            JSONArray transactionRecordsArr = (JSONArray)((JSONObject)transactionRecordsObj.get("data")).get("records");
            JSONObject lastTransaction = (JSONObject)transactionRecordsArr.get(0);
            ai.setAmount(lastTransaction.get("amount").toString());
            ai.setTransTime(lastTransaction.get("trans_time").toString());
            if(ai.getAccountNum().equals(lastTransaction.get("from").toString())){
                ai.setExpenditureIncomeState("转出");
            }
            String accountInfo = HttpClientUtil.getDataByAddr(ai.getAccountNum(),1);
            JSONObject accountInfoObj = JSONObject.fromObject(accountInfo);
            if(ai.getTotalAmount().equals(((JSONObject)accountInfoObj.get("data")).get("balance").toString())){
                ai.setWarn("0");
            }else{
                ai.setWarn("1");
                new MusicUtil().play();
            }
            ai.setTotalAmount(((JSONObject)accountInfoObj.get("data")).get("balance").toString());

            try {
                WebSocketServer.sendInfo(JSONObject.fromObject(ai).toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
