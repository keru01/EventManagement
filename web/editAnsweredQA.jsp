<%-- 
    Document   : editAnsweredQA
    Created on : Oct 4, 2021, 10:27:48 PM
    Author     : Nghia
--%>

<%@page import="com.group5.event.QandADTO"%>
<%@page import="com.group5.users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Answered Q&A Page</title>
    </head>
    <body>
        <%
            UserDTO mentor = (UserDTO) session.getAttribute("LOGIN_USER");
            String editAnsweredQA = request.getParameter("editAnsweredQA");
            if (editAnsweredQA == null) {
                editAnsweredQA = "";
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
             <h2>Question of Event: <%=QAM.getEventName()%></h2>
             Question of student: <%=QAM.getQuestionDetail()%><br>
             Your Answered: <%=QAM.getReply()%><br>
             
             <input type="text" name="editAnsweredQA" value="<%=editAnsweredQA%>"/>
             <input type="submit" name="action" value="Edit Answered"/>
                    
         </form> 
            <% 
            }
            %>
    </body>
</html>
