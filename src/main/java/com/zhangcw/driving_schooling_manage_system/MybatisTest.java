package com.zhangcw.driving_schooling_manage_system;

import com.zhangcw.driving_schooling_manage_system.entity.Coach;
import org.apache.ibatis.io.Resources;
import java.io.InputStream;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.apache.log4j.Logger;

public class MybatisTest {
    private static Logger logger = Logger.getLogger(MybatisTest.class);
    public static void main(String []args) throws  Exception{

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
//        构建sqlSessionFactory
        SqlSessionFactory  sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SQLSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            Coach coach = sqlSession.selectOne("myMapper.selectCoach",1);
//            logger.warn(coach.getCarNumber());
//            logger.info(coach.getCoachName());
//            logger.error(coach.getPhone());
            System.out.println(coach.getCoach_name());
        }finally {
            sqlSession.close();
        }
    }
}
