package org.example.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;
/**
 * 用户登录参数
 *
 */
public class UmsAdminLoginParam {
    @ApiModelProperty(value = "User", required = true)
    @NotEmpty(message = "User can not null")
    private String username;
    @ApiModelProperty(value = "Password", required = true)
    @NotEmpty(message = "Password can not null")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
