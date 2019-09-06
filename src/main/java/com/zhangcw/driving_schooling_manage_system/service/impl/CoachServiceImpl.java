package com.zhangcw.driving_schooling_manage_system.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zhangcw.driving_schooling_manage_system.dao.CoachDao;
import com.zhangcw.driving_schooling_manage_system.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachServiceImpl implements CoachService {
    @Autowired
    private CoachDao coachDao;

    @Override
    public JSONObject listUser(JSONObject jsonObject) {
        return null;
    }
}
