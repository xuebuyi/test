package top.xuebuyi.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import top.xuebuyi.domain.Role;
import top.xuebuyi.domain.UserInfo;

import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-01-27 21:53
 */
public interface UserService extends UserDetailsService {
    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);

    List<Role> findOtherRoles(String userId);

    void addRoleToUser(String userId, String[] roleIds);
}
