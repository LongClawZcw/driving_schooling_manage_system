package com.zhangcw.driving_schooling_manage_system.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author:zhangchangwei
 * @Description:
 * @Date: Created in 22:28 2019/9/9
 * @Modified By:
 */
public interface PermissionService {
    /**
     * 查询用户的角色 菜单列表 权限列表
     */
    JSONArray getUserPermission(String username);
}
