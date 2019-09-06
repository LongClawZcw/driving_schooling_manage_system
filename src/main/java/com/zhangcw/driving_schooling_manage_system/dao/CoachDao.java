package com.zhangcw.driving_schooling_manage_system.dao;

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
     * 查询所有用户信息
     *
     * @return
     */
    public List<Coach> queryUserAll();

    /**
     * 新增用户
     *
     * @param user
     */
    public void insertUser(Coach user);

    /**
     * 更新用户信息
     *
     * @param user
     */
    public void updateUser(Coach user);

    /**
     * 根据id删除用户信息
     *
     * @param id
     */
    public void deleteUser(String id);
}
