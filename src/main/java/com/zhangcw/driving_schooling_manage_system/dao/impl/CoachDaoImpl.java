package com.zhangcw.driving_schooling_manage_system.dao.impl;

import com.zhangcw.driving_schooling_manage_system.dao.CoachDao;
import com.zhangcw.driving_schooling_manage_system.entity.Coach;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachDaoImpl implements CoachDao {
    public SqlSession sqlSession;
    public CoachDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Coach queryUserById(String id) {
        return this.sqlSession.selectOne("CoachDao.queryUserById", id);
    }

    @Override
    public List<Coach> queryUserAll() {
        return this.sqlSession.selectList("CoachDao.queryUserAll");
    }

    @Override
    public void insertUser(Coach coach) {
        this.sqlSession.insert("CoachDao.insertUser", coach);
        this.sqlSession.commit();
    }

    @Override
    public void updateUser(Coach user) {
        this.sqlSession.update("CoachDao.updateUser", user);
        this.sqlSession.commit();
    }

    @Override
    public void deleteUser(String id) {
        this.sqlSession.delete("CoachDao.deleteUser", id);
        this.sqlSession.commit();
    }
}
