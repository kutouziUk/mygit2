import cn.ws.mapper.RoleDao;
import cn.ws.domain.Log;
import cn.ws.domain.Role;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class RoleMain {
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
    public void findall() {
        //动态生成动态代理对象
        Page page = PageHelper.startPage(2, 3);
        List<Role> list = roledao.findall();
        PageInfo<Role> pageInfo = new PageInfo<Role>(list);
//        List<Role> list1 = pageInfo.getList();
//        System.out.println("list1 :" + list1);
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示长度："+pageInfo.getPageSize());
        System.out.println("是否第一页："+pageInfo.isIsFirstPage());
        System.out.println("是否最后一页："+pageInfo.isIsLastPage());
        System.out.println("pageendrow:" + pageInfo.getEndRow());
        System.out.println("pagestartrow" + pageInfo.getStartRow());
//        System.out.println(list);
    }

    @Test
    public  void findById(){
        int[] ids = {1,2,3};
        List<Role> list = roledao.findById(ids);
        System.out.println(list);
    }

    @Test
    public  void findcondition(){
        Role role = new Role();
        System.out.println("roleid = " + role.getId());
        role.setRoleName("院长");
        List<Role> list = roledao.findcondition(role);
        System.out.println(list);
    }

    @Test
    public  void findone(){
        Role role = roledao.findone(1);
        System.out.println(role);
    }



    @Test
    public  void findlogall(){
//        System.out.println(new Date().getTime());
        List<Log> list = roledao.findlogall();
        for (Log log : list) {
            System.out.println(log);
        }
    }
//
//
//    @Test
//    public void inser() {
//        Role role = new Role(null, "绝地科学家", "绝对不开挂");
//
//    }
//
//    @Test
//    public void delete() {
////            roledao.delete(17);
//    }
}

