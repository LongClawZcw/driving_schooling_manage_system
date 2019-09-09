package com.zhangcw.driving_schooling_manage_system.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author:zhangchangwei
 * @Description: 登录模块接口
 * @Date: Created in 10:45 2019/9/9
 * @Modified By:
 */
public interface LoginService {
    /**
     * 登录表单提交
     */
    JSONObject authLogin(JSONObject jsonObject);
    /**
     * 根据用户名和密码查询对应的用户
     *
     * @param username 用户名
     * @param password 密码
     */
    JSONObject getUser(String username, String password);

    /**
     * 查询当前登录用户的权限等信息
     */
    JSONObject getInfo();

    /**
     * 退出登录
     */
    JSONObject logout();
}
