package com.zhangcw.driving_schooling_manage_system.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:zhangchangwei
 * @Description:
 * @Date: Created in 11:05 2019/9/9
 * @Modified By:
 */
public interface LoginDao {
    /**
     * 根据用户名和密码查询对应的用户
     */
    JSONObject getUser(@Param("username") String username, @Param("password") String password);
}
