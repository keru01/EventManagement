<%-- 
    Document   : becomeMentor
    Created on : Oct 4, 2021, 11:08:28 PM
    Author     : Nghia
--%>

<%@page import="com.group5.users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Become Mentor Page</title>
    </head>
    <body>
        
        <%
        UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
        String location="";
        String startTime ="";
        String nameEvent ="";
        %>
        <form action="MainController">
            <input type="hidden" name="nameRegister" value="<%=loginUser.getName()%>" />
            <input type="hidden" name="gmail" value="<%=loginUser.getEmail()%>"/>
            Name Event: <input type="text" name="nameEvent" value="<%=nameEvent%>"/><br>
            Category:   <select name="category">
                <option value="">Others</option>
                <option value="Information technology">Information technology</option>
                <option value="International business">International business</option>
                <option value="Languages">Languages</option>
            </select>
            <br>Location:<input type="text" name="location" value="<%=location%>"/><br>
            Start Time: <input type="date" name="startTime" value="<%=startTime%>"/><br>
            <input type="submit" name="action" value="Register Mentor"/>
        </form> 
    </body>
</html>
