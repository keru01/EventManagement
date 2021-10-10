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
public class SpecialUserDTO {
    private String id;
    private String password;
    private String userName;
    private String userEmail;
    private String status;

    public SpecialUserDTO() {
    }

    public SpecialUserDTO(String id, String password, String userName, String status) {
        this.id = id;
        this.password = password;
        this.userName = userName;
        this.status = status;
    }

    
    
    public SpecialUserDTO(String id, String password, String userName, String userEmail, String status) {
        this.id = id;
        this.password = password;
        this.userName = userName;
        this.userEmail = userEmail;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    
    
}
