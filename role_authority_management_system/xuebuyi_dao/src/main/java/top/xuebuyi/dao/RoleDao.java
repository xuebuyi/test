package top.xuebuyi.dao;

import org.apache.ibatis.annotations.*;
import top.xuebuyi.domain.Permission;
import top.xuebuyi.domain.Role;

import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-01-28 0:58
 */
public interface RoleDao {

    //根据用户id查询所有角色
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results(id = "RoleMap", value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "top.xuebuyi.dao.PermissionDao.findPermissionByRoleId")),
    })
    public List<Role> findRoleByUserId(String userId);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id=#{roleId}")
    @ResultMap("RoleMap")
    Role findById(String roleId);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(String roleId);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
