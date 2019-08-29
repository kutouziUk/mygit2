
import cn.ws.mapper.StudentDao;
import cn.ws.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StudentMain {

    InputStream in;
    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;
    StudentDao studentdao;

    @Before
    public void before() throws IOException {
        in = Resources.getResourceAsStream("MybatisConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession(true);
        studentdao = sqlSession.getMapper(StudentDao.class);
    }


    @Test
    public void findById(){
        Student student = studentdao.findById(1);
        System.out.println(student);
    }
    @Test
    public void findall(){
        List<Student> list = studentdao.findallbyuser();
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
