package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.common.api.CommonResult;
import org.example.model.UmsPermission;
import org.example.service.PermissionService;
import org.example.service.ProductService;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(tags = "permission", description = "test")
@RequestMapping("/permission")
@Controller
public class PermissionController {
    @Resource(name = "permissionService")
    private PermissionService permissionService;
    @ApiOperation(value = "")
    @PostMapping("/addpermission")
    @ResponseBody
    public CommonResult addPermission(@RequestParam("id") Integer id){
        permissionService.addPermission(id);
        return CommonResult.success("sucess");
    }

}
