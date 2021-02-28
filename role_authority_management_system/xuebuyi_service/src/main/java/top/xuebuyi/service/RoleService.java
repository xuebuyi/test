package top.xuebuyi.service;

import top.xuebuyi.domain.Permission;
import top.xuebuyi.domain.Role;

import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-01-31 17:33
 */
public interface RoleService {
    List<Role> findAll();

    void save(Role role);

    Role findById(String roleId);

    List<Permission> findOtherPermissions(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);
}
