<%-- 
    Document   : answerQuestion
    Created on : Oct 2, 2021, 1:26:45 AM
    Author     : Nghia
--%>

<%@page import="com.group5.event.EventDTO"%>
<%@page import="com.group5.event.QandADTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="com.group5.users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Answer Questions Page</title>
    </head>
    <body>
         <%
            UserDTO mentor = (UserDTO) session.getAttribute("LOGIN_USER");
            String answerQA = request.getParameter("answerQA");
            if (answerQA == null) {
                answerQA = "";
            }
        %>
         <h1>Hello Mentor: <%=mentor.getName()%></h1>
        <%
            QandADTO QAM = new QandADTO(request.getParameter("questionID"), request.getParameter("mentorID"), request.getParameter("studentID"),
                    request.getParameter("eventID"),request.getParameter("eventName"), request.getParameter("questionDetail"), request.getParameter("reply"));
            if (QAM != null) {
            %>
           
          <form action="MainController">
             <input type="hidden" name="questionID" value="<%=QAM.getQuestionID()%>"/>
             <input type="hidden" name="mentorID" value="<%=QAM.getMentorID()%>"/>
             <input type="hidden" name="studentID" value="<%=QAM.getStudentID()%>"/>
             <input type="hidden" name="eventID" value="<%=QAM.getEventID()%>"/>
             <input type="hidden" name="questionDetail" value="<%=QAM.getQuestionDetail()%>"/>
             <h2>Question of Event: <%=QAM.getEventName()%></h2><br>
             Question: <%=QAM.getQuestionDetail()%><br>
             
             <input type="text" name="answerQA" value="<%=answerQA%>"/>
             <input type="submit" name="action" value="AnswerQA"/>
                    
         </form> 
            <% 
            }
            %>
    </body>
</html>
