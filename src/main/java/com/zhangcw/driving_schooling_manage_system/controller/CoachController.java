package com.zhangcw.driving_schooling_manage_system.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhangcw.driving_schooling_manage_system.service.CoachService;
import com.zhangcw.driving_schooling_manage_system.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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
    @GetMapping("/list")
    public JSONObject listUser(HttpServletRequest request) {
        return coachService.listUser(CommonUtil.request2Json(request));
    }
}
