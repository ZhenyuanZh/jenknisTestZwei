package org.example.service.impl;

import org.example.common.utils.JwtTokenUtil;
import org.example.dao.UmsPermissionDao;
import org.example.dao.UserPermissionRelationDao;
import org.example.dao.User_testDao;
import org.example.model.UmsPermission;
import org.example.model.UserPermissionRelation;
import org.example.model.User_test;
import org.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional(rollbackOn = Exception.class)
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource(name="user_testDao")
    private User_testDao user_testDao;
    @Resource(name="umsPermissionDao")
    private UmsPermissionDao umsPermissionDao;
    @Resource(name="userPermissionRelationDao")
    private UserPermissionRelationDao userPermissionRelationDao;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String login(String name, String password) {
        String token = null;
        try{
            UserDetails userDetails = userDetailsService.loadUserByUsername(name);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e){
            LOGGER.warn("Login exception:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public boolean updatePassword(String oldPass, String newPass) {
        return false;
    }

    @Override
    public List<User_test> getUser(HttpServletRequest request) {
        return null;
    }

    @Override
    public void updateUser(User_test user) throws Exception {

    }

    @Override
    public void saveUser(User_test user) {
        user_testDao.save(user);
    }

    @Override
    public void deleteUserById(Integer id) {

    }

    @Override
    public User_test getUserById(Integer id) {
        return null;
    }
    @Override
    public User_test getUserByName(String name) {
        return user_testDao.findUserByName(name);
    }

    @Override
    public void updateLoginTime(User_test user) throws Exception {

    }

    @Override
    public List<UmsPermission> getPermissionList(Integer id) {
        User_test user_test = user_testDao.findUserById(id);
        List<UserPermissionRelation> up_relation = userPermissionRelationDao.findUserPermissionRelationByUserId(user_test.getId());
        List<UmsPermission> umsPermissions = new ArrayList<UmsPermission>();
        for(int i=0;i<up_relation.size();i++){
            UmsPermission umsPermission=umsPermissionDao.findUmsPermissionById(up_relation.get(i).getPermissionId());
            umsPermissions.add(umsPermission);
        }
        //System.out.println(umsPermissions.get(1).getId());
        return umsPermissions;
    }
}
