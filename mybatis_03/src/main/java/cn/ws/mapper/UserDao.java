package cn.ws.mapper;

import cn.ws.domain.Student;
import cn.ws.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Select("select * from user")
    public List<User> findall();

    @Insert("insert into user values(#{id},#{username},#{password},#{age},#{sid})")
    public void insert(User user);

    @Delete("delete from user where id=#{id}")
    public void delete(int id);

    //一对一
    @Select("select * ,s.id stid from user u ,student s where u.sid=s.id")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "age", property = "age"),
            @Result(column = "sid", property = "sid"),
            @Result(column = "stid",property = "student.id"),
            @Result(column = "classroom",property = "student.classroom")

    })
    public List<User>  select_u_s();

    //一对一
    @Select("select * from user")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "age", property = "age"),
            @Result(column = "sid", property = "sid"),
            @Result(
                    property = "student",
                    column = "sid",
                    javaType = Student.class,
                    one =@One(select ="cn.ws.mapper.StudentDao.findById")
            )
    })
    public List<User> select_u_and_s();


    @Select("select * from user where sid=#{id}")
    public User findById(int id);
}
