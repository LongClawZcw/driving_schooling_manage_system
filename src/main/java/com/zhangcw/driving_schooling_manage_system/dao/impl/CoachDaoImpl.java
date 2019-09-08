package com.zhangcw.driving_schooling_manage_system.dao.impl;

import com.alibaba.fastjson.JSONObject;
import com.zhangcw.driving_schooling_manage_system.dao.CoachDao;
import com.zhangcw.driving_schooling_manage_system.entity.Coach;
import com.zhangcw.driving_schooling_manage_system.util.CommonUtil;
import com.zhangcw.driving_schooling_manage_system.util.constants.ErrorEnum;
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
    public  int queryExistUsername(String username) {
        try{
            return this.sqlSession.selectOne("CoachDao.queryExistUsername", username);
        }catch (Exception e) {
            return 0;
        }
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
    public JSONObject insertUser(Coach coach) {
        JSONObject info = new JSONObject();
        int exist = -1;
        try{
            exist = this.sqlSession.selectOne("CoachDao.queryExistUsername", coach.getCoach_name());
        }catch (Exception e){
            exist = 0;
        }
        if(exist>0){
            return CommonUtil.errorJson(ErrorEnum.E_10009);
        }
        try{
            this.sqlSession.insert("CoachDao.insertUser", coach);
            this.sqlSession.commit();
            info.put("result","success");

        }catch (Exception e){
            info.put("result","database error");
        }
        return CommonUtil.successJson(info);
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
