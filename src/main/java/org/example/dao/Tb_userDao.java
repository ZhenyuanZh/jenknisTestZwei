package org.example.dao;

import org.example.model.Tb_user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Tb_userDao extends JpaRepository<Tb_user, Integer>, JpaSpecificationExecutor<Tb_user> {

    /**
     * updatePasswordById
     * @param id id
     * @param newPhone newPhone
     */
    @Modifying
    @Query("update Tb_user t set t.phone=:newPhone where t.id=:id")
    void updatePhoneById(@Param("id") Integer id, @Param("newPhone") String newPhone);

    /**
     * deleteUserById
     * @param id id
     */
    @Modifying
    void deleteUserById(Integer id);
    @Modifying
    void deleteUserByName(String name);
    Tb_user getTb_userByName(String name);
}
