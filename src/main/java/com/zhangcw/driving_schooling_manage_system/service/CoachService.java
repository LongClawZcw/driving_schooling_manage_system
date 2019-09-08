package com.zhangcw.driving_schooling_manage_system.service;

import com.alibaba.fastjson.JSONObject;
import com.zhangcw.driving_schooling_manage_system.entity.Coach;

import java.util.List;

public interface CoachService {
    /**
     * 用户列表
     */
    List<Coach> listUser();
    /**
     * 获取指定ID教练对象
     */
    Coach getCoachById(String id);

    /**
     * 插入对象
     */
    JSONObject intsertCoach(Coach coach);

    /**
     *更新用户信息
     * @param coach
     */
    void updateCoach(Coach coach);
    /**
     *删除用户信息
     * @param id
     */
    void deleteCoach(String id);
}
