package top.xuebuyi.service;

import top.xuebuyi.domain.Permission;

import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-01-31 17:52
 */
public interface PermissionService {
    List<Permission> findAll();

    void save(Permission permission);
}
