package org.example.service.impl;

import org.example.dao.ProductDao;
import org.example.dao.Tb_userDao;
import org.example.model.Tb_user;
import org.example.service.TbUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service("tb_userService")
@Transactional(rollbackOn = Exception.class)
public class TbUserServiceImpl implements TbUserService {
    @Resource(name="tb_userDao")
    private Tb_userDao tb_userDao;
    @Override
    public boolean updatePhone(Integer id, String newPhone) {
        tb_userDao.updatePhoneById(id,newPhone);
        return true;
    }

    @Override
    public void saveTb_user(Tb_user tb_user) {
        tb_userDao.save(tb_user);
    }

    @Override
    public void deleteTb_userById(Integer id) {
        tb_userDao.deleteUserById(id);

    }
    @Override
    public Tb_user getTb_userByName(String name){
        return tb_userDao.getTb_userByName(name);
    }

    @Override
    public void deleteTb_userByName(String name) {
    }
}
