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
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Minh Khoa
 */
public class EventDAO {
    public List<EventDTO> getListEvent(String search, String categoryId) throws SQLException {
        List<EventDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT eventID, eventName, userName, categoryName, locationName, eventDetail, seat, creatTime, startTime, endTime, image, video, status FROM tblEvent, tblUser, tblCategory, tblLocation " 
                        +    " WHERE tblEvent.categoryID = tblCategory.categoryID " 
                        +    " AND tblEvent.creatorID = tblUser.userID " 
                        +    " AND tblEvent.locationID = tblLocation.locationID and " 
                        +    " eventName like ? and tblEvent.categoryID like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + search + "%");
                stm.setString(2, "%" + categoryId + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String eventID = rs.getString("eventID");
                    String eventName = rs.getString("eventName");
                    String creatorID = rs.getString("userName"); //act as creatorName
                    String categoryID = rs.getString("categoryName"); //act as categoryName
                    String locationID = rs.getString("locationName"); //act as locationName
                    String eventDetail = rs.getString("eventDetail");
                    int seat = rs.getInt("seat");
                    Timestamp creaetTime = rs.getTimestamp("creatTime");
                    Timestamp startTime = rs.getTimestamp("startTime");
                    Timestamp endTime = rs.getTimestamp("endTime");
                    String image = rs.getString("image");
                    String video = rs.getString("video");
                    String status = rs.getString("status");
                    
                    
                    list.add(new EventDTO(eventID, eventName, creatorID, categoryID, locationID, eventDetail, seat, creaetTime, startTime, endTime, image, video, status));
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
       public List<EventDTO> getListEventMentorAttended(String mentorId ) throws SQLException {
        List<EventDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            if (conn != null) {
                String sql = "SELECT tblEvent.eventID, eventName, userName, categoryName, locationName, eventDetail, seat, creatTime, startTime, endTime, image, video, status FROM tblEvent, tblUser, tblCategory, tblLocation,  tblMentorEvent " 
                        +    " WHERE tblEvent.categoryID = tblCategory.categoryID " 
                        +    " AND tblEvent.creatorID = tblUser.userID " 
                        +    " AND tblEvent.eventID = tblMentorEvent.eventID "
                        +    " AND tblEvent.locationID = tblLocation.locationID " 
                        +    " AND tblMentorEvent.mentorID like ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, mentorId);
                ;
                rs = stm.executeQuery();
                while (rs.next()) {
                    String eventID = rs.getString("eventID");
                    String eventName = rs.getString("eventName");
                    String creatorID = rs.getString("userName"); //act as creatorName
                    String categoryID = rs.getString("categoryName"); //act as categoryName
                    String locationID = rs.getString("locationName"); //act as locationName
                    String eventDetail = rs.getString("eventDetail");
                    int seat = rs.getInt("seat");
                    Timestamp creaetTime = rs.getTimestamp("creatTime");
                    Timestamp startTime = rs.getTimestamp("startTime");
                    Timestamp endTime = rs.getTimestamp("endTime");
                    String image = rs.getString("image");
                    String video = rs.getString("video");
                    String status = rs.getString("status");
                    
                    
                    list.add(new EventDTO(eventID, eventName, creatorID, categoryID, locationID, eventDetail, seat, creaetTime, startTime, endTime, image, video, status));
                /*String sql = "SELECT tblEvent.eventID, eventName, tblEvent.categoryID, startTime, endTime FROM tblEvent, tblCategory, tblMentorEvent "
                           + " WHERE tblEvent.eventID = tblMentorEvent.eventID "
                           + "  AND tblEvent.categoryID = tblCategory.categoryID  " 
                           + " AND tblMentorEvent.mentorID like ? "
                        ;
                
                       
                stm = conn.prepareStatement(sql);
                stm.setString(1, mentorId);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String eventID = rs.getString("eventID");
                    String eventName = rs.getString("eventName");
                    String categoryID = rs.getString("categoryID");
                    Timestamp startTime = rs.getTimestamp("startTime");
                    Timestamp endTime = rs.getTimestamp("endTime");
                    
                    
                    
                    list.add(new EventDTO(eventID, eventName, categoryID, startTime, endTime));*/
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
       
    public static void sendMailRegisterMentor(String nameRegister, String gmail, String nameEvent, String category, String location, String startTime) throws SQLException, ClassNotFoundException, MessagingException {
       Properties properties = new Properties();
        System.out.println("Prepare!");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "eventnotifygroup5@gmail.com";
        String password = "eventgroup5";
        
        Session session = Session.getInstance(properties, new Authenticator() {
        
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail, password);
            }
                    
        });
        String htmlCode ="Dear Admin,<br>I am " + nameRegister + "<br> I write this mail to request authorized to be a mentor of " + nameEvent + " with catalogy " + category +" at "+ location +" in "+ startTime + "." + "<br>Thank you,<br>" + nameRegister;
        Message message = prepareMessage(session, myAccountEmail, "knguyen9047@gmail.com", htmlCode);
        Transport.send(message);
        System.out.println("Message sent seccessfully!");
        
    }
    
    private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String htmlCode){
        
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Request to become Mentor");
            
            message.setContent(htmlCode ,"text/html");
            return message;
        } catch (Exception ex) {
            Logger.getLogger(EventDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  null;
    }
    
}
