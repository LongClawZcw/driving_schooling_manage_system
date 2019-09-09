package com.zhangcw.driving_schooling_manage_system.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhangcw.driving_schooling_manage_system.service.LoginService;
import com.zhangcw.driving_schooling_manage_system.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:zhangchangwei
 * @Description: 用于用户登录
 * @Date: Created in 10:35 2019/9/9
 * @Modified By:
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    /**
     * 登录
     */
    @PostMapping("/auth")
    public JSONObject authLogin(@RequestBody JSONObject requestJson){
        CommonUtil.hasAllRequired(requestJson, "username,password");
        return loginService.authLogin(requestJson);
    }
    /**
     * 查询当前登录用户的信息
     */
    @PostMapping("/getInfo")
    public JSONObject getInfo() {
        return loginService.getInfo();
    }
    /**
     * 登出
     */
    @PostMapping("/logout")
    public JSONObject logout(){
        return loginService.logout();
    }
}
