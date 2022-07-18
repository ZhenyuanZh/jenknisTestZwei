package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.common.api.CommonResult;
import org.example.model.Tb_user;

import org.example.service.TbUserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Api(tags = "flywayTest", description = "test")
@RequestMapping("/flywayTest")
@Controller
public class FlayWayTestController {
    @Resource(name = "tb_userService")
    private TbUserService tbUserService;
    @ApiOperation(value = "")
    @PostMapping("/create")
    @ResponseBody
    public CommonResult<Tb_user> create(@RequestBody Tb_user tb_user) throws UnsupportedEncodingException {
        String name = URLDecoder.decode(tb_user.getName(), "utf-8");
        Tb_user checkTb_user= tbUserService.getTb_userByName(name);
        if(checkTb_user !=null){
            return CommonResult.failed("exist");
        }
        tb_user.setName(tb_user.getName());
        tb_user.setPhone(tb_user.getPhone());
        tb_user.setEmail(tb_user.getEmail());
        tb_user.setRoleId(tb_user.getRoleId());
        tbUserService.saveTb_user(tb_user);
        return CommonResult.success(tb_user);
    }
    @ApiOperation("")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult delete(@RequestParam(value = "name", defaultValue = "string") String name) {
        tbUserService.deleteTb_userByName(name);
        return CommonResult.success("success");
    }
    @ApiOperation("")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Tb_user> update(@RequestBody Tb_user tb_user, BindingResult result) throws UnsupportedEncodingException {
        String name = URLDecoder.decode(tb_user.getName(), "utf-8");
        Tb_user checkTbuser= tbUserService.getTb_userByName(name);
        if(checkTbuser ==null){
            return CommonResult.failed("exist");
        }
        tbUserService.updatePhone(tb_user.getId(),tb_user.getPhone());
        return CommonResult.success(tb_user);
    }

}
