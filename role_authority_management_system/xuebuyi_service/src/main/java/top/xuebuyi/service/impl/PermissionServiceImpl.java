package top.xuebuyi.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.xuebuyi.dao.PermissionDao;
import top.xuebuyi.domain.Permission;
import top.xuebuyi.service.PermissionService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-01-31 17:53
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Resource
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
