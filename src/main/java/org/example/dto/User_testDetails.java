package org.example.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.example.model.User_test;
import org.example.model.UmsPermission;

public class User_testDetails implements UserDetails {

    /**
     * SpringSecurity需要的用户详情
     *
     */
    private User_test user_test;
    private List<UmsPermission> permissionList;
    public User_testDetails(User_test user_test, List<UmsPermission> permissionList) {
        this.user_test = user_test;
        this.permissionList = permissionList;
        }
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            //返回当前用户的权限
            return permissionList.stream()
                    .filter(permission -> permission.getValue()!=null)
                    .map(permission ->new SimpleGrantedAuthority(permission.getValue()))
                    .collect(Collectors.toList());
        }

        @Override
        public String getPassword() {
            return user_test.getPassword();
        }

        @Override
        public String getUsername() {
            return user_test.getName();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
