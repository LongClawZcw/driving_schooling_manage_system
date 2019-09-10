//package com.zhangcw.driving_schooling_manage_system.service.impl;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.zhangcw.driving_schooling_manage_system.dao.PermissionDao;
//import com.zhangcw.driving_schooling_manage_system.service.PermissionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Set;
//
///**
// * @Author:zhangchangwei
// * @Description:
// * @Date: Created in 22:33 2019/9/9
// * @Modified By:
// */
//@Service
//public class PermissionServiceImpl implements PermissionService {
//
//    @Autowired
//    private PermissionDao permissionDao;
//
//    /**
//     * 查询某用户的 角色  菜单列表   权限列表
//     */
//    @Override
//    public JSONArray getUserPermission(String username) {
//        JSONArray userPermission = getUserPermissionFromDB(username);
//        return userPermission;
//    }
//
////    /**
////     * 从数据库查询用户权限信息
////     */
////    private JSONArray getUserPermissionFromDB(String username) {
////        JSONArray userPermission = permissionDao.getUserPermission(username);
////        //管理员角色ID为1
////        int adminRoleId = 1;
////        //如果是管理员
////        String roleIdKey = "roleId";
////        if (adminRoleId == userPermission.getIntValue(roleIdKey)) {
////            //查询所有菜单  所有权限
////            Set<String> menuList = permissionDao.getAllMenu();
////            Set<String> permissionList = permissionDao.getAllPermission();
////            userPermission.put("menuList", menuList);
////            userPermission.put("permissionList", permissionList);
////        }
////        return userPermission;
////    }
//}
