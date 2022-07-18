package org.example.dao;

import org.example.model.UserPermissionRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface UserPermissionRelationDao extends JpaRepository<UserPermissionRelation, Integer>, JpaSpecificationExecutor<UserPermissionRelation> {
    /**
     * findUserByUsernameAndPassword
     * @param name name
     * @param password password
     * @return User
     */



    /**
     * updatePasswordById
     * @param id id
     * @param newPassword newPassword

    @Modifying
    @Query("update User_test u set u.password=:newPassword where u.id=:id")
    void updatePasswordById(@Param("id") Integer id, @Param("newPassword") String newPassword);
*/
    /**
     * deleteUserById
     * @param id id
     */
    @Modifying
    void deleteUserPermissionRelationById(Integer id);

    /**
     * findUserById
     * @param id id
     * @return User
     */
    List<UserPermissionRelation> findUserPermissionRelationByUserId(Integer id);
}
