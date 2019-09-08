package com.zhangcw.driving_schooling_manage_system.dao;

import com.alibaba.fastjson.JSONObject;
import com.zhangcw.driving_schooling_manage_system.entity.Coach;


import java.util.List;

public interface CoachDao {

    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    public Coach queryUserById(String id);
    /**
     * 根据用户名查找用户是否存在
     * @param username
     */
    public int queryExistUsername(String username);
    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<Coach> queryUserAll();
    /**
     * 新增用户
     *
     * @param coach
     */
    public JSONObject insertUser(Coach coach);

    /**
     * 更新用户信息
     *
     * @param coach
     */
    public void updateUser(Coach coach);

    /**
     * 根据id删除用户信息
     *
     * @param id
     */
    public void deleteUser(String id);
}
