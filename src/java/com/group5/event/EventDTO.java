/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.event;

import java.sql.Timestamp;

/**
 *
 * @author Minh Khoa
 */
public class EventDTO {

    private String eventID;
    private String eventName;
    private String creatorID;
    private String categoryID;
    private String locationID;
    private String eventDetail;
    private int seat;
    private Timestamp createTime;
    private Timestamp startTime;
    private Timestamp endTime;
    private String image;
    private String video;
    private String status;

    public EventDTO() {
    }

    public EventDTO(String eventID, String eventName, String creatorID, String categoryID, String locationID, String eventDetail, int seat, Timestamp createTime, Timestamp startTime, Timestamp endTime, String image, String video, String status) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.creatorID = creatorID;
        this.categoryID = categoryID;
        this.locationID = locationID;
        this.eventDetail = eventDetail;
        this.seat = seat;
        this.createTime = createTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.image = image;
        this.video = video;
        this.status = status;
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

    public String getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(String creatorID) {
        this.creatorID = creatorID;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getEventDetail() {
        return eventDetail;
    }

    public void setEventDetail(String eventDetail) {
        this.eventDetail = eventDetail;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    

    
}
