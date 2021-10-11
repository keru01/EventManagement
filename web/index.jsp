<%-- 
    Document   : index
    Created on : Sep 20, 2021, 2:04:14 PM
    Author     : Minh Khoa
--%>

<%@page import="java.util.List"%>
<%@page import="com.group5.event.EventDTO"%>
<%@page import="com.group5.users.UserDTO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <h1>Hello User: <%=loginUser.getName()%></h1>
        <h3>ID: <%=loginUser.getId()%></h3>
        <h3>Email: <%=loginUser.getEmail()%></h3>
        <h3>Role <%=loginUser.getRoleID()%></h3>
        <form action="MainController">
            <input type="submit" name="action" value="Logout"/>
        </form>

        <form action="MainController">
            <h2>Search <input type="text" name="search" value="<%=search%>"/>
            <input type="submit" name="action" value="Search"/>
            </h2>
        </form>
        
        <%
            List<EventDTO> list = (List<EventDTO>) request.getAttribute("LIST_EVENT");
            if (list != null) {
                if (!list.isEmpty()) {
                    for (EventDTO event : list) {
                
        %>
        <a href="eventDetail.jsp?id<%=event.getEventID()%>&name=<%=event.getEventName()%>&creatorID=<%=event.getCreatorID()%>&categoryID=<%=event.getCategoryID()%>
           &location=<%=event.getLocationID()%>&eventDetail=<%=event.getEventDetail()%>&seat=<%=event.getSeat()%>&startTime=<%=event.getStartTime()%>
           &endTime=<%=event.getEndTime()%>&creatTime=<%=event.getCreateTime()%>&image=<%=event.getImage()%>&video=<%=event.getVideo()%>
           &status=<%=event.getStatus()%>"> <%=event.getEventName()%> </a>
        <%
                    }
                }
            }
        %>
        
        <a href="changeRole.jsp">Change Role</a>
    </body>
</html>
