package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Data;
import org.apache.tomcat.util.security.MD5Encoder;
import org.example.common.api.CommonResult;
import org.example.common.utils.DateUtil;
import org.example.model.User_test;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "login", description = "test")
@RequestMapping("/login")
@Controller
public class Login {
    @Resource(name = "userService")
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @ApiOperation(value = "")
    @PostMapping("/register")
    @ResponseBody
    public CommonResult<User_test> register(@RequestBody User_test user_test, BindingResult result) throws UnsupportedEncodingException {
        String name = URLDecoder.decode(user_test.getName(), "utf-8");
        String loginName = URLDecoder.decode(user_test.getLoginName(), "utf-8");
        User_test checkUser = userService.getUserByName(user_test.getName());
        if(checkUser !=null) {
            return CommonResult.failed("exist");}
        user_test.setName(name);
        user_test.setPassword(passwordEncoder.encode(user_test.getPassword()));
        user_test.setCreateTime(DateUtil.getLocalTime());
        userService.saveUser(user_test);
        User_test user = userService.getUserByName(user_test.getName());
        //map.put("message","保存成功！");
        if(user == null){
            return CommonResult.failed();
        }
        return CommonResult.success(user_test);

    }
    @ApiOperation(value = "")
    @PostMapping("/login")
    @ResponseBody
    public CommonResult login(@RequestBody User_test user_test, BindingResult result){
        String token = userService.login(user_test.getName(), user_test.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("false password or username");
        }

        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }
}
