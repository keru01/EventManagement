/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.users;

import com.group5.utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Minh Khoa
 */
public class SpecialUserDAO {
    public SpecialUserDTO checkLoginSpecial(String userID, String password, String role) throws SQLException {
        SpecialUserDTO user = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null && role.equals("admin")) {
                String sql = "SELECT adminName, status FROM tblAdmin WHERE adminID=? AND password=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String adminName =rs.getString("adminName");
                    String status = rs.getString("status");
                    user = new SpecialUserDTO(userID, password, adminName, status);
                }
            }
            else if (conn != null && role.equals("mentor")) {
                String sql= "SELECT mentorName, mentorEmail, status FROM tblMentor WHERE mentorID=? AND password=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String mentorName = rs.getString("mentorName");
                    String mentorEmail = rs.getString("mentorEmail");
                    String status = rs.getString("status");
                    user = new SpecialUserDTO(userID, password, mentorName, mentorEmail, status);
                }
            }
            else if (conn != null && role.equals("leader")) {
                String sql = "SELECT leaderName, leaderEmail, status FROM tblLeader WHERE leaderID=? AND password=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String leaderName = rs.getString("leaderName");
                    String leaderEmail = rs.getString("leaderEmail");
                    String status = rs.getString("status");
                    user = new SpecialUserDTO(userID, password, leaderName, leaderEmail, status);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
    }
}
