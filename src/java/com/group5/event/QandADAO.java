/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.event;

import com.group5.utils.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nghia
 */
public class QandADAO {
     public List<QandADTO> getListQuestion() throws SQLException {
        List<QandADTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT questionID, mentorID, studentID, tblQandA.eventID, eventName, questionDetail, reply  " 
                        +    " FROM tblQandA, tblEvent "                       
                        +    " WHERE tblQandA.reply IS null "
                        +    " AND tblQandA.eventID = tblEvent.eventID  " ;
                       
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String questionID = rs.getString("questionID");
                    String mentorID = rs.getString("mentorID");
                    String studentID = rs.getString("studentID");
                    String eventID = rs.getString("eventID"); 
                    String eventName = rs.getString("eventName");
                    String questionDetail = rs.getString("questionDetail"); 
                    String reply = rs.getString("reply");
                                       
                    list.add(new QandADTO(questionID, mentorID, studentID, eventID, eventName, questionDetail, reply));
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
        return list;
    }
    
     public List<QandADTO> getListAnswered() throws SQLException {
        List<QandADTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT questionID, mentorID, studentID, tblQandA.eventID, eventName, questionDetail, reply  " 
                        +    " FROM tblQandA, tblEvent "                       
                        +    " WHERE tblQandA.reply IS not null "
                        +    " AND tblQandA.eventID = tblEvent.eventID  " ;
                       
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String questionID = rs.getString("questionID");
                    String mentorID = rs.getString("mentorID");
                    String studentID = rs.getString("studentID");
                    String eventID = rs.getString("eventID"); 
                    String eventName = rs.getString("eventName");
                    String questionDetail = rs.getString("questionDetail"); 
                    String reply = rs.getString("reply");
                                       
                    list.add(new QandADTO(questionID, mentorID, studentID, eventID, eventName, questionDetail, reply));
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
        return list;
    }
    public boolean setListAnswer(QandADTO qa) throws SQLException, ClassNotFoundException {
        boolean check = false;
        Connection con = null;
        PreparedStatement stm = null;
        
        try {
            con = DBUtil.getConnection();
            if (con != null) {
                String sql="UPDATE tblQandA "
                        +" SET reply = ? "
                        +" WHERE questionID = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, qa.getReply());
                stm.setString(2, qa.getQuestionID()); 
                 
                /*stm.setString(1, qa.getQuestionID());
                stm.setString(2, qa.getMentorID());
                stm.setString(3, qa.getStudentID());
                stm.setString(4, qa.getEventID());
                stm.setString(5, qa.getQuestionDetail());
                stm.setString(6, qa.getReply());*/
                check = stm.executeUpdate() > 0;
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return check;
    }

    
}
