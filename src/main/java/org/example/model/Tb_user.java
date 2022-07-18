package org.example.model;

import javax.persistence.*;

@Table(name ="tb_user")
@Entity
public class Tb_user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id ;
    @Basic
    @Column(name="username")
    private String name;
    @Basic
    @Column(name="email")
    private String email;
    @Basic
    @Column(name="phone")
    private String phone;
    @Basic
    @Column(name="role_id")
    private Integer roleId;



    public Integer getId(){return id;}
    public void setId(Integer id){this.id=id;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email=email;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    public String getPhone(){return phone;}
    public void setPhone(String phone){this.phone=phone;}

    public Integer getRoleId(){return roleId;}
    public void setRoleId(Integer roleId){this.roleId=roleId;}

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash =").append(hashCode());
        sb.append(",id=").append(id);
        sb.append(",name=").append(name);
        sb.append(", email =").append(email);
        sb.append(", phone =").append(phone);
        sb.append(",role_id=").append(roleId);
        sb.append("]");
        return sb.toString();
    }

}
