<%-- 
    Document   : changeRole
    Created on : Oct 11, 2021, 2:39:38 PM
    Author     : ASUS
--%>

<%@page import="com.group5.users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change  Role Page</title>
    </head>
    <body>
        <%
        UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
        String reason = "";
        %>
        <form action="MainController">
            <input type="hidden" name="nameRegister" value="<%=loginUser.getName()%>" />
            <input type="hidden" name="gmail" value="<%=loginUser.getEmail()%>"/>
            <br>
            <h2>Write reason clearly:</h2><br>
            <br><input type="text" name="reason" value="<%=reason%>"/><br>          
            <input type="submit" name="action" value="Confirm Resquest"/><br>
            
            <% 
            
            String message=(String)request.getAttribute("STUDENT_MESSAGE");
            if (message==null) {
                    message="";
                }
        %>
        <%= message%>
        </form> 
    </body>
</html>
