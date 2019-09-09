package com.zhangcw.driving_schooling_manage_system.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * @Author:zhangchangwei
 * @Description: 用户权限接口
 * @Date: Created in 22:38 2019/9/9
 * @Modified By:
 */
public interface PermissionDao {
    /**
     * 查询用户的角色 菜单 权限
     */
    JSONObject getUserPermission(String username);

    /**
     * 查询所有的菜单
     */
    Set<String> getAllMenu();

    /**
     * 查询所有的权限
     */
    Set<String> getAllPermission();
}
