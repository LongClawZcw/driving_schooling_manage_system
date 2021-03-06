package com.zhangcw.driving_schooling_manage_system.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.zhangcw.driving_schooling_manage_system.dao.CoachDao;
import com.zhangcw.driving_schooling_manage_system.dao.impl.CoachDaoImpl;
import com.zhangcw.driving_schooling_manage_system.entity.Coach;
import com.zhangcw.driving_schooling_manage_system.service.CoachService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class CoachServiceImpl implements CoachService  {
    @Autowired
    private CoachDao coachDao;
    public SqlSession sqlSession;

    public  CoachServiceImpl(){
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        this.sqlSession = sqlSessionFactory.openSession(false);
        this.coachDao = new CoachDaoImpl(sqlSession);
    }
    @Override
    public List<Coach> listUser()  {
        CoachServiceImpl coachService = new CoachServiceImpl();
        return coachService.coachDao.queryUserAll();
    }

    @Override
    public Coach getCoachById(String id) {
        CoachServiceImpl coachService = new CoachServiceImpl();
        return coachService.coachDao.queryUserById(id);
    }

    @Override
    public JSONObject intsertCoach(Coach coach) {
        CoachServiceImpl coachService = new CoachServiceImpl();
        return coachService.coachDao.insertUser(coach);
    }

    @Override
    public void updateCoach(Coach coach) {
        CoachServiceImpl coachService = new CoachServiceImpl();
        coachService.coachDao.updateUser(coach);
    }

    @Override
    public void deleteCoach(String id) {
        CoachServiceImpl coachService = new CoachServiceImpl();
        coachService.coachDao.deleteUser(id);
    }

}
