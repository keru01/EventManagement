/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.users;

/**
 *
 * @author Minh Khoa
 */
public class UserDTO {
    private String id;
    private String email;
    private String status;
    private String name;
    private String roleID;
    
    public UserDTO() {
    }

    public UserDTO(String id, String email, String status, String name, String roleID) {
        this.id = id;
        this.email = email;
        this.status = status;
        this.name = name;
        this.roleID = roleID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    
}
