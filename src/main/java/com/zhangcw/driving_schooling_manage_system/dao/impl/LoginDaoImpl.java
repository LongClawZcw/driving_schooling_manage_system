package com.zhangcw.driving_schooling_manage_system.dao.impl;

import com.alibaba.fastjson.JSONObject;
import com.zhangcw.driving_schooling_manage_system.dao.LoginDao;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;


import java.util.HashMap;

/**
 * @Author:zhangchangwei
 * @Description:
 * @Date: Created in 11:07 2019/9/9
 * @Modified By:
 */
@Service
public class LoginDaoImpl implements LoginDao {
    public SqlSession sqlSession;
    public LoginDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public JSONObject getUser(String username, String password) {
        HashMap<String,Object> params = new HashMap<String,Object>();
        params.put("username",username);
        params.put("password",password);
        return this.sqlSession.selectOne("LoginDao.getUser", params);
    }
}
