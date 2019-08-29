package cn.ws.dao;

import cn.ws.domain.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;


import java.util.List;


public interface RoleDao {

    @Select("select * from sys_role")
    List<Role> findAll();
    @Delete("delete from sys_role where id=#{id}")
    void delete(int id);
    @Insert("insert into sys_role values(#{id},#{roleName},#{roleDesc})")
    void insert(Role role);
}
