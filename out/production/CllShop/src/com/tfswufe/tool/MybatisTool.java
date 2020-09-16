package com.tfswufe.tool;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTool {
    private static SqlSessionFactory sf = null;

    static {
        //1.读取配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("resource/mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.构建SqlSession工厂
        sf = new SqlSessionFactoryBuilder().build(is);
    }

    public static SqlSession getSqlSession(){
        return sf.openSession(true);
    }

    public static void CloseSqlSession(SqlSession sqlSession){
        if (sqlSession != null){
            sqlSession.close();
        }else {
            System.out.println("啥也不是");
        }
    }
}
