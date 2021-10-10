/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.event;

/**
 *
 * @author Nghia
 */
public class QandADTO {
    private String questionID;
    private String mentorID;
    private String studentID;
    private String eventID;
    private String eventName;
    private String questionDetail;
    private String reply;

    public QandADTO() {
    }

    public QandADTO(String questionID, String mentorID, String studentID, String eventID, String eventName, String questionDetail, String reply) {
        this.questionID = questionID;
        this.mentorID = mentorID;
        this.studentID = studentID;
        this.eventID = eventID;
        this.eventName = eventName;
        this.questionDetail = questionDetail;
        this.reply = reply;
    }

    public String getQuestionID() {
        return questionID;
    }

    public void setQuestionID(String questionID) {
        this.questionID = questionID;
    }

    public String getMentorID() {
        return mentorID;
    }

    public void setMentorID(String mentorID) {
        this.mentorID = mentorID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getQuestionDetail() {
        return questionDetail;
    }

    public void setQuestionDetail(String questionDetail) {
        this.questionDetail = questionDetail;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    
}
