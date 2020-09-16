package com.tfswufe.dao;

import com.tfswufe.entity.Bill;
import com.tfswufe.entity.User;
import com.tfswufe.mapper.BillMapper;
import com.tfswufe.mapper.UserMapper;
import com.tfswufe.tool.MybatisTool;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MybatisDao {
    /**登录*/
    public User LoginDao(User user){
        //1.得到SqlSession会话对象
        SqlSession sqlSession = MybatisTool.getSqlSession();
        //2.读取Mapper接口的字节码文件，得到mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //3.调用登录接口执行SQL语句
        User user1 = mapper.LoginMapper(user);
        //4.关闭操作
        MybatisTool.CloseSqlSession(sqlSession);
        return user1;
    }

    /**查询账单信息*/
    public List<Bill> SelectCheckDao(Bill bill){
        //1.得到SqlSession会话对象
        SqlSession sqlSession = MybatisTool.getSqlSession();
        //2.读取Mapper接口的字节码文件，得到mapper对象
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        //3.调用登录接口执行SQL语句
        List<Bill> list = mapper.SelectCheckMapper(bill);
        //4.关闭操作
        MybatisTool.CloseSqlSession(sqlSession);
        return list;
    }

    /**添加商品信息*/
    public int InsertCheckDao(Bill bill){
        //1.得到SqlSession会话对象
        SqlSession sqlSession = MybatisTool.getSqlSession();
        //2.读取Mapper接口的字节码文件，得到mapper对象
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);
        //3.调用登录接口执行SQL语句
        int i = mapper.InsertCheckMapper(bill);
        //4.关闭操作
        MybatisTool.CloseSqlSession(sqlSession);
        return i;
    }

}
