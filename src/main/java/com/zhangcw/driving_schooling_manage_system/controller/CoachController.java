package com.zhangcw.driving_schooling_manage_system.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhangcw.driving_schooling_manage_system.entity.Coach;
import com.zhangcw.driving_schooling_manage_system.service.CoachService;
import com.zhangcw.driving_schooling_manage_system.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author zhangchangwei
 * @description: 教练模块Controller
 * @date
 */
@RestController
@RequestMapping("/coach")
public class CoachController {
    @Autowired
    private CoachService coachService;
    /**
     * 查询教练列表
     *
     */
//    @RequiresPermissions("user:list")
    @RequestMapping(value = "/listCoach",method = RequestMethod.GET)
    public List<Coach> listUser(HttpServletRequest request) throws IOException {
        return coachService.listUser();
    }
}
