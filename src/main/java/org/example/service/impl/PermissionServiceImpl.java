package org.example.service.impl;

import org.example.dao.UmsPermissionDao;
import org.example.dao.UserPermissionRelationDao;
import org.example.dao.User_testDao;
import org.example.model.UmsPermission;
import org.example.model.UserPermissionRelation;
import org.example.model.User_test;
import org.example.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service("permissionService")
@Transactional(rollbackOn = Exception.class)
public class PermissionServiceImpl implements PermissionService {
    @Resource(name="umsPermissionDao")
    private UmsPermissionDao umsPermissionDao;
    @Resource(name="userPermissionRelationDao")
    private UserPermissionRelationDao userPermissionRelationDao;
    @Autowired
    UserPermissionRelation userPermissionRelation;
    @Autowired
    UmsPermission umsPermission;
    @Override
    public  void addPermission(Integer id) {
        umsPermission.setValue("2");
        umsPermission.setName(id.toString()+"test");
        umsPermissionDao.save(umsPermission);
        String name=umsPermission.getName();
        Long permissionId = umsPermissionDao.findUmsPermissionByName(name).getId();
        userPermissionRelation.setPermissionId(permissionId);
        userPermissionRelation.setUserId(id);
        userPermissionRelationDao.save(userPermissionRelation);

    }
}
