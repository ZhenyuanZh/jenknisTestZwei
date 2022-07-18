package org.example.dao;

import org.example.model.UmsPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface UmsPermissionDao extends JpaRepository<UmsPermission, Integer>, JpaSpecificationExecutor<UmsPermission> {
    /**
     * findUserByUsernameAndPassword
     * @param name name
     * @param password password
     * @return User
     */

    UmsPermission findUmsPermissionByName(String name);

    /**
     * updatePasswordById
     * @param id id
     * @param newPassword newPassword

    @Modifying
    @Query("update UmsPermission u set u.password=:newPassword where u.id=:id")
    void updatePasswordById(@Param("id") Integer id, @Param("newPassword") String newPassword);
*/
    /**
     * deleteUserById
     * @param id id
     */
    @Modifying
    void deleteUmsPermissionById(Integer id);

    /**
     * findUserById
     * @param id id
     * @return User
     */
    UmsPermission findUmsPermissionById(Long id);
}
