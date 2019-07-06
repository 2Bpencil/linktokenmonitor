package com.tyf.linktokenmonitor.code.utils;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.io.IOException;

public class HttpClientUtil {
    /**
     *
     * @param addr  账户信息
     * @param type  查询类型  0 交易记录   1 余额
     * @return
     */
    public static String getDataByAddr(String addr ,int type){
        String data = "";
        // 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        String url = "https://explorer.lianxiangcloud.com/xylbrowser/getAccountInfo?address="+addr+"&t="+System.currentTimeMillis();
        if(type == 0){
            url = "https://explorer.lianxiangcloud.com/xylbrowser/getAccountTransactions?page=1&page_size=10&addr="+addr;
        }
        // 创建Get请求
        HttpGet httpGet = new HttpGet(url);
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Get请求
            response = httpClient.execute(httpGet);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();
            if (responseEntity != null) {
                data = EntityUtils.toString(responseEntity);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public static void main(String[] args) {
        System.out.println(getDataByAddr("0x90bdf09b3f5718b752939424789d26c23657b1d0",0));//
        System.out.println(getDataByAddr("0x90bdf09b3f5718b752939424789d26c23657b1d0",1));//
    }

}
