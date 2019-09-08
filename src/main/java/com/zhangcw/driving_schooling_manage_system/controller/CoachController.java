package com.zhangcw.driving_schooling_manage_system.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhangcw.driving_schooling_manage_system.entity.Coach;
import com.zhangcw.driving_schooling_manage_system.service.CoachService;
import com.zhangcw.driving_schooling_manage_system.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public List<Coach> listUser(HttpServletRequest request)  {
        return coachService.listUser();
    }
    @RequestMapping(value = "/getCoachById",method = RequestMethod.GET)
    public Coach getCoachById(HttpServletRequest request) {
        String id = request.getParameter("id");
        return coachService.getCoachById(id);
    }
    @RequestMapping(value = "/insertCoach",method = RequestMethod.POST)
    public void insertCoach(@RequestBody Coach coach) {
        coachService.intsertCoach(coach);
    }
    @RequestMapping(value = "/updateCoach",method = RequestMethod.POST)
    public void updateCoach(@RequestBody Coach coach) {
        coachService.updateCoach(coach);
    }
    @RequestMapping(value = "/deleteCoach",method = RequestMethod.GET)
    public void deleteCoach(String id) {
        coachService.deleteCoach(id);
    }
}
