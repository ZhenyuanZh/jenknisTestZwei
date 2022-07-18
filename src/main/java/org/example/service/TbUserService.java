package org.example.service;


import org.example.model.Tb_user;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TbUserService {
    boolean updatePhone(Integer id, String newPhone);



    void saveTb_user(Tb_user tb_user);

    void deleteTb_userById(Integer id);
    void deleteTb_userByName(String name);
    Tb_user getTb_userByName(String name);
}
