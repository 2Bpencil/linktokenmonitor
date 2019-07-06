package com.tyf.linktokenmonitor.code.controller;

import com.tyf.linktokenmonitor.code.config.Constant;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/index")
public class IndexController {

    /**
     * 获取初始化数据
     * @param request
     * @param response
     */
    @RequestMapping(value = "getInitData",method = RequestMethod.POST)
    public void getTableJson(HttpServletRequest request, HttpServletResponse response){
        JSONArray array = JSONArray.fromObject(Constant.list);
        String json = array.toString();
        try {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
