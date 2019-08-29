import cn.ws.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;



public class Main {
    private InputStream in;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    @Before
    public void before() throws IOException {
        System.out.println("资源初始化");
        in  = Resources.getResourceAsStream("MybatisConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @After
    public void after(){
        System.out.println("释放资源");
        sqlSession.close();
    }

    @Test
    public void findall() throws IOException {
        List<Role> list = (List)sqlSession.selectList("userDao.findall");
        System.out.println(list);
    }

    @Test
    public void insert(){
        Role role = new Role(null,"绝地科学家","绝对不开挂");
        int i = sqlSession.insert("userDao.add",role);
    }

    @Test
    public void delete(){
        sqlSession.delete("userDao.delete",13);
    }
}
