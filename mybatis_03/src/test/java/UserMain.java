import cn.ws.mapper.UserDao;
import cn.ws.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMain {
    InputStream in;
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;
    UserDao userdao;

    @Before
    public void before() throws IOException {
        in = Resources.getResourceAsStream("MybatisConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession(true);
        userdao = sqlSession.getMapper(UserDao.class);
    }

    @Test
    public void findall(){
        List<User> list = userdao.findall();
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void select_user_role() {
        List<User> users = userdao.select_u_s();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void select_user_and_role() {
        List<User> users = userdao.select_u_and_s();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void findById(){
        User byId = userdao.findById(1);
        System.out.println(byId);
    }
}
