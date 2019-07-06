package com.tyf.linktokenmonitor.code.config;
/**
 * @Auther: tyf
 * @Date: 2018/12/6 17:00
 * @Description:
 */

import com.tyf.linktokenmonitor.code.entity.AccountInfo;
import com.tyf.linktokenmonitor.code.entity.DataConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @description: 启动执行服务
 *
 * @author: Mr.Tan
 *
 * @create: 2018/12/6 17:00
 **/
@Component
@Order(value = 1)
public class Constant implements ApplicationRunner {

    private final static Logger logger = LoggerFactory.getLogger(Constant.class);

    public static List<AccountInfo> list = new ArrayList<>();

    @Autowired
    private DataConfig data;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String linktokens = data.getLinktokens();

        Stream.of(linktokens.split(";")).forEach(account->{
            AccountInfo accountInfo = new AccountInfo();
            accountInfo.setAccountNum(account.split("|")[1]);
            accountInfo.setName(account.split("|")[0]);
            list.add(accountInfo);

        } );
    }
}
