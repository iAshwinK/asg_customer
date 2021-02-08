package com.ashwin.customer.entity;

import com.ashwin.customer.vo.UserType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "RoleEntity")
@Table(name = "ashwin_role")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleEntity implements Serializable {

    @Id
    @Column(name="role_id",unique = true)
    private String roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_code")
    private String roleCode;

    @Column(name = "role_type",nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType roleType;

    @OneToOne(mappedBy = "roleEntity")
    private UserEntity userEntity;

    public RoleEntity() {
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public UserType getRoleType() {
        return roleType;
    }

    public void setRoleType(UserType roleType) {
        this.roleType = roleType;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
