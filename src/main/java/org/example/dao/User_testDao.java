package org.example.dao;

import org.example.model.User_test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author admin
 */
public interface User_testDao extends JpaRepository<User_test, Integer>, JpaSpecificationExecutor<User_test> {
    /**
     * findUserByUsernameAndPassword
     * @param name name
     * @param password password
     * @return User
     */
    User_test findUserByLoginNameAndPassword(String name, String password);

    User_test findUserByName(String name);

    /**
     * updatePasswordById
     * @param id id
     * @param newPassword newPassword
     */
    @Modifying
    @Query("update User_test u set u.password=:newPassword where u.id=:id")
    void updatePasswordById(@Param("id") Integer id, @Param("newPassword") String newPassword);

    /**
     * deleteUserById
     * @param id id
     */
    @Modifying
    void deleteUserById(Integer id);

    /**
     * findUserById
     * @param id id
     * @return User
     */
    User_test findUserById(Integer id);
}
