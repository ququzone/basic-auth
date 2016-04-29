package com.github.ququzone.basicauth.service;

import com.github.ququzone.basicauth.model.Menu;
import com.github.ququzone.basicauth.model.Role;
import com.github.ququzone.basicauth.model.User;
import com.github.ququzone.basicauth.model.UserVO;
import com.github.ququzone.common.Page;

import java.util.List;

/**
 * auth service.
 *
 * @author Yang XuePing
 */
public interface AuthService {
    User login(String username, String password);

    boolean auditing(String userId, String pattern);

    UserVO getUserVO(String userId);

    List<Menu> getUserMenus(String userId);

    void settingUser(String userId, String displayName, boolean changePassword, String originPassword, String password);

    Page<UserVO> userPage(int page, int pageSize);

    void addUser(String username, String displayName, String password);

    void updateUser(String id, String username, String displayName, String password);

    void disableUser(String id);

    void enableUser(String id);

    List<Role> roles();

    List<Role> userRoles(String userId);

    void assignRole(String userId, String[] roles);

    Page<Role> rolePage(int page, int pageSize);

    void addRole(String name);
}
