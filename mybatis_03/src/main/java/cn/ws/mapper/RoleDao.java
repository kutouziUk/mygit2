package cn.ws.mapper;

import cn.ws.domain.Log;
import cn.ws.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface RoleDao {
    @Select("")
    List<Role> findall();
    List<Role> findById(int[] id);
    Role findone(int id);
    List<Role> findcondition(Role role);
    void insert(Role role);
    List<Log> findlogall();
}
