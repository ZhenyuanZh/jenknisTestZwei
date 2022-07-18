package org.example.service;

import org.example.model.UmsPermission;
import org.example.model.User_test;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    /**
     * login
     * @param name name
     * @param password password
     * @return user
     */
    String login(String name, String password);

    /**
     * updatePassword
     * @param oldPass oldPass
     * @param newPass newPass
     * @return boolean
     */
    boolean updatePassword(String oldPass, String newPass);

    List<User_test> getUser(HttpServletRequest request);

    void updateUser(User_test user) throws Exception;

    void saveUser(User_test user);

    void deleteUserById(Integer id);

    User_test getUserById(Integer id);

    User_test getUserByName(String name);

    void updateLoginTime(User_test user) throws Exception;

    List<UmsPermission> getPermissionList(Integer id);
}
