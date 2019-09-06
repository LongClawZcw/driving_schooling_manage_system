package com.zhangcw.driving_schooling_manage_system.dao;

import com.zhangcw.driving_schooling_manage_system.dao.impl.CoachDaoImpl;
import com.zhangcw.driving_schooling_manage_system.entity.Coach;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.util.List;

public class CoachDaoTest {
    public CoachDao coachDao;
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
        this.coachDao = new CoachDaoImpl(sqlSession);
    }

    @Test
    public void queryUserById() {
        System.out.println(this.coachDao.queryUserById("1"));
    }

    @Test
    public void queryUserAll() {
        List<Coach> userList = this.coachDao.queryUserAll();
        for (Coach user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void insertUser() {
        Coach coach = new Coach();
        coach.setCoach_id("N8677");
        coach.setAge(45);
        coach.setCar_number("S2223454");
        coach.setCoach_name("王五");
        coach.setPhone("15244779621");
        coach.setPicture_url("jdkslajdlasjf");
        this.coachDao.insertUser(coach);
        this.sqlSession.commit();
    }

    @Test
    public void updateUser() {
        Coach coach = new Coach();
        coach.setCoach_id("N1234");
        coach.setAge(34);
        coach.setCar_number("粤A12345");
        coach.setCoach_name("张三");
        coach.setPhone("15256552233");
        coach.setPicture_url("师大");
        coach.setId(1);
        this.coachDao.updateUser(coach);
        this.sqlSession.commit();
    }

    @Test
    public void deleteUser() {
        this.coachDao.deleteUser("4");
        this.sqlSession.commit();
    }
}