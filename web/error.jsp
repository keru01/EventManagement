<%-- 
    Document   : error
    Created on : Sep 20, 2021, 11:55:56 PM
    Author     : Minh Khoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>error Page</title>
    </head>
    <body>
        <h1>Error: <%=session.getAttribute("ERROR_MESSAGE")%> </h1>
    </body>
</html>
