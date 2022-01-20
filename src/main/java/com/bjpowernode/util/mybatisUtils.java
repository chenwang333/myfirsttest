package com.bjpowernode.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * mybatis工具类
 */
public class mybatisUtils {
   private static SqlSessionFactory factory=null;
    static{
        //定义mybatis主配置文件名称
        String config = "mybatis.xml";


        try {
            //读取主配置文件
            InputStream in = Resources.getResourceAsStream(config);
            //获取SqlSessionFactory对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        if(factory!=null){
            sqlSession = factory.openSession();
        }

        return sqlSession;
    }
}
