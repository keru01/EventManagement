<%-- 
    Document   : eventDetail
    Created on : Sep 27, 2021, 2:48:16 PM
    Author     : Minh Khoa
--%>

<%@page import="java.sql.Timestamp"%>
<%@page import="com.group5.event.EventDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Event Detail Page</title>
    </head>
    <body>
        <%
            EventDTO event = new EventDTO(request.getParameter("id"), request.getParameter("name"), request.getParameter("creatorID"),
                    request.getParameter("categoryID"), request.getParameter("location"), request.getParameter("eventDetail"),
                    Integer.parseInt(request.getParameter("seat")), Timestamp.valueOf(request.getParameter("creatTime")), Timestamp.valueOf(request.getParameter("startTime")),
                    Timestamp.valueOf(request.getParameter("endTime")), request.getParameter("image"), request.getParameter("video"),
                    request.getParameter("status"));
            if (event != null) {
        %>
        
        <h1>Event: <%=event.getEventName()%></h1>
        <h1> <%=event.getCategoryID()%></h1>
        <h1> Post by: <%=event.getCreatorID()%> at <%=event.getCreateTime()%></h1>
        <h1> Location: <%=event.getLocationID()%></h1>
        <h1> From <%=event.getStartTime()%> to <%=event.getEndTime()%></h1>
        <img src ="<%=event.getImage()%>"> 
               
        <iframe width="560" height="315" src="<%=event.getVideo()%>" 
                title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

        <h1> <%=event.getEventDetail()%></h1>
        <h1> <%=event.getStatus()%></h1>
        <h1> Seat available <%=event.getSeat()%></h1>
        <% }
        %>
        
        
    </body>
</html>
