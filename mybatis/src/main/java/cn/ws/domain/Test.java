package cn.ws.domain;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        //加载核心配置文件
        InputStream in  = Resources.getResourceAsStream("MybatisConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Role> list = (List)sqlSession.selectList("userDao.findall");
        System.out.println(list);
        Role role = new Role(null,"绝地科学家","绝对不开挂");
        int i = sqlSession.insert("userDao.add",role);
        System.out.println("i= " + i );
        sqlSession.commit();
        sqlSession.close();
    }
}
