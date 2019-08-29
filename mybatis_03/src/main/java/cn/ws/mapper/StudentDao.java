package cn.ws.mapper;

import cn.ws.domain.Student;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface StudentDao {
    @Select("select * from student where id=#{id}")
    Student findById(int id);
    @Select("select * from student")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "classoroom", property = "classoroom"),
            @Result(
                    property = "userlist",
                    column = "id",
                    javaType = List.class,
                    many=@Many(select="cn.ws.mapper.UserDao.findById")
            )
    })
    public List<Student> findallbyuser();
}
