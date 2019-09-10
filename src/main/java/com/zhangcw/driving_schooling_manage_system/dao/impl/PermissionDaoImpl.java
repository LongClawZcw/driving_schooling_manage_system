package com.zhangcw.driving_schooling_manage_system.dao.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhangcw.driving_schooling_manage_system.dao.PermissionDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Author:zhangchangwei
 * @Description:
 * @Date: Created in 22:39 2019/9/9
 * @Modified By:
 */
@Service
public class PermissionDaoImpl implements PermissionDao {
    public SqlSession sqlSession;
    public PermissionDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<JSONObject> getUserPermission(String username) {
        return  this.sqlSession.selectList("PermissionDao.getUserPermission",username);
    }

    @Override
    public Set<String> getAllMenu() {
        return null;
    }

    @Override
    public Set<String> getAllPermission() {
        return null;
    }
}
