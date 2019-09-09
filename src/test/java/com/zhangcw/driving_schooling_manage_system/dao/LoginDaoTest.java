package com.zhangcw.driving_schooling_manage_system.dao;

import com.alibaba.fastjson.JSONObject;
import com.zhangcw.driving_schooling_manage_system.dao.impl.CoachDaoImpl;
import com.zhangcw.driving_schooling_manage_system.dao.impl.LoginDaoImpl;
import com.zhangcw.driving_schooling_manage_system.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * @Author:zhangchangwei
 * @Description:
 * @Date: Created in 11:46 2019/9/9
 * @Modified By:
 */
public class LoginDaoTest {
    public LoginDao loginDao;
    public SqlSession sqlSession;
    @Before
    public void setUp() throws Exception {
        // mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
        this.loginDao = new LoginDaoImpl(sqlSession);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getUser() {
        JSONObject res = new JSONObject();
        String username = "admin";
        String password = "123456";
        res = this.loginDao.getUser(username,password);
        System.out.print(res);
    }
}