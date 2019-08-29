import cn.ws.dao.RoleDao;
import cn.ws.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main1 {
    private InputStream in;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private RoleDao roledao;
    @Before
    public void before() throws IOException {
        in = Resources.getResourceAsStream("MybatisConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession(true);
        roledao = sqlSession.getMapper(RoleDao.class);
    }


    @Test
    public void findall(){
        //动态生成动态代理对象
        List<Role> list = roledao.findAll();
        System.out.println(list);
    }
    @Test
    public void inser()
    {
        Role role = new Role(null,"绝地科学家","绝对不开挂");
        roledao.insert(role);
    }

    @Test
    public void delete(){
        roledao.delete(17);
    }
}
