package com.jobsearch.user_service.entity;


import javax.persistence.*;

@Entity
public class Role {

    @Id
    @Column(nullable = false, unique = true)
    private String roleName;
    private String roleDescription;


    public Role() {
    }

    public Role( String roleName, String roleDescription) {

        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
