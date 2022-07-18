package org.example.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name ="user_test")
@Entity
public class User_test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String name;
    private String password;
    private String email;
    private String telephone;
    private String loginName;
    private String createTime;
    private String lastLoginTime;

    @Column(name="id")
    public Integer getId(){return id;}

    public void setId(Integer id){this.id=id;}
    @Basic
    @Column(name="email")
    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}
    @Basic
    @Column(name="name")
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    @Basic
    @Column(name="password")
    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}
    @Basic
    @Column(name="telephone")
    public String getTelephone(){return telephone;}
    public void setTelephone(String telephone){this.telephone=telephone;}
    @Basic
    @Column(name="login_name")
    public String getLoginName(){return loginName;}
    public void setLoginName(String loginName){this.loginName=loginName;}
    @Basic
    @Column(name="create_time")
    public String getCreateTime(){return createTime;}
    public void setCreateTime(String createTime){this.createTime=createTime;}
    @Basic
    @Column(name="last_login_time")
    public String getLastLoginTime(){return lastLoginTime;}
    public void setLastLoginTime(String lastLoginTime){this.lastLoginTime=lastLoginTime;}
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(",id=").append(id);
        sb.append(",name=").append(name);
        sb.append(",password=").append(password);
        sb.append(", email =").append(email);
        sb.append(", telephone =").append(telephone);
        sb.append(",login_name=").append(loginName);
        sb.append(", create_time =").append(createTime);
        sb.append(", last_login_time =").append(lastLoginTime);
        sb.append("]");
        return sb.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User_test user = (User_test) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (telephone != null ? !telephone.equals(user.telephone) : user.telephone != null) return false;
        if (loginName != null ? !loginName.equals(user.loginName) : user.loginName != null) return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(user.lastLoginTime) : user.lastLoginTime != null)
            return false;
        if (createTime != null ? !createTime.equals(user.createTime) : user.createTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + (loginName != null ? loginName.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        return result;
    }

}
