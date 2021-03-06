package com.zhangcw.driving_schooling_manage_system.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhangcw.driving_schooling_manage_system.dao.LoginDao;
import com.zhangcw.driving_schooling_manage_system.dao.PermissionDao;
import com.zhangcw.driving_schooling_manage_system.dao.impl.LoginDaoImpl;
import com.zhangcw.driving_schooling_manage_system.dao.impl.PermissionDaoImpl;
import com.zhangcw.driving_schooling_manage_system.service.LoginService;
import com.zhangcw.driving_schooling_manage_system.util.CommonUtil;
import com.zhangcw.driving_schooling_manage_system.util.constants.Constants;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author:zhangchangwei
 * @Description: 登录模块接口实现
 * @Date: Created in 10:47 2019/9/9
 * @Modified By:
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Autowired
    private PermissionDao permissionDao;
    public SqlSession sqlSession;


    public LoginServiceImpl(){
        String resource = "mybatis-config.xml";
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
        this.loginDao = new LoginDaoImpl(sqlSession);
        this.permissionDao = new PermissionDaoImpl(sqlSession);
    }
    @Override
    public JSONObject authLogin(JSONObject jsonObject) {
        String username = jsonObject.getString("username");
        String password = jsonObject.getString("password");
        JSONObject info = new JSONObject();
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            currentUser.login(token);
            info.put("result", "success");
        } catch (AuthenticationException e) {
            info.put("result", "账号或密码不存在");
        }
        return CommonUtil.successJson(info);
    }
    /**
     * 根据用户名和密码查询对应的用户
     */
    @Override
    public JSONObject getUser(String username, String password) {
//        return loginDao.getUser(username, password);
        LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
        return loginServiceImpl.loginDao.getUser(username,password);
    }

    /**
     * 查询当前登录用户的权限等信息
     */
    @Override
    public JSONObject getInfo() {
        //从session获取用户信息
        Session session = SecurityUtils.getSubject().getSession();
        JSONObject userInfo = (JSONObject) session.getAttribute(Constants.SESSION_USER_INFO);
        String username = userInfo.getString("username");
        JSONObject info = new JSONObject();
        LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
        List<JSONObject> userPermission = loginServiceImpl.permissionDao.getUserPermission(username);
        session.setAttribute(Constants.SESSION_USER_PERMISSION, userPermission);
        info.put("userPermission", userPermission);
        return CommonUtil.successJson(info);
    }
    /**
     * 退出登录
     */
    @Override
    public JSONObject logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
        } catch (Exception e) {
        }
        return CommonUtil.successJson();
    }
}
