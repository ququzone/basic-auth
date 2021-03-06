package com.github.ququzone.basicauth.service;

import com.github.ququzone.basicauth.model.*;
import com.github.ququzone.common.Page;

import java.util.List;

/**
 * auth service.
 *
 * @author Yang XuePing
 */
public interface AuthService {
    User login(String username, String password);

    boolean auditing(String userId, String pattern, ResourceMapping.RequestMethod method);

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

    void assignUserRole(String userId, String[] roles);

    Page<Role> rolePage(int page, int pageSize);

    void addRole(String name);

    Role getRole(String id);

    void updateRole(String id, String name);

    void deleteRole(String id);

    List<Resource> roleResources(String roleId);

    List<User> roleUsers(String roleId);

    Page<Resource> resourcePage(String q, int page, int pageSize);

    void addResource(String name, String pattern, ResourceMapping.RequestMethod method);

    Resource getResource(String id);

    void updateResource(String id, String name, String pattern, ResourceMapping.RequestMethod method);

    void deleteResource(String id);

    List<Role> resourceRoles(String id);

    void assignResourceRole(String id, String[] roles);

    List<Menu> getAllMenus();

    void addMenu(String name, String icon);

    Menu getMenu(String id);

    void updateMenu(String id, String name, String icon);

    void deleteMenu(String id);

    List<Resource> getUncheckedMenuResource(String menuId);

    void addMenuResource(String menuId, String resourceId);

    void deleteMenuResource(String menuId, String resourceId);

    void exchangeMenu(String previousId, String nextId);

    void exchangeMenuResource(String menuId, String previousId, String nextId);

    void discoverResource();
}
