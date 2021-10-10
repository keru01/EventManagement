<%-- 
    Document   : admin
    Created on : Sep 21, 2021, 12:40:20 AM
    Author     : Minh Khoa
--%>

<%@page import="com.group5.users.SpecialUserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            SpecialUserDTO loginUser = (SpecialUserDTO) session.getAttribute("LOGIN_USER");
            
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <h1>Hello Admin: <%=loginUser.getId()%></h1>
    </body>
</html>
