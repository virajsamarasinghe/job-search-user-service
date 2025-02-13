package com.jobsearch.user_service.dto;

public class RoleDto {


    private String roleName;
    private String roleDescription;


    public RoleDto() {
    }

    public RoleDto( String roleName, String roleDescription) {

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
