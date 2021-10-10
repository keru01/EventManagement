<%-- 
    Document   : mentor
    Created on : Oct 1, 2021, 3:02:15 PM
    Author     : Nghia
--%>

<%@page import="com.group5.event.QandADTO"%>
<%@page import="java.util.List"%>
<%@page import="com.group5.event.EventDTO"%>
<%@page import="com.group5.users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mentor Page</title>
    </head>
    <body>
        <%
            UserDTO mentor = (UserDTO) session.getAttribute("LOGIN_USER");
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        
         <h1>Hello Mentor: <%=mentor.getName()%></h1>
         <form action="MainController">
            <input type="submit" name="action" value="Logout"/>
        </form>
         
        
         
         <form action="MainController">
            <input type="hidden" name="qaMentor"/>
            
            <input type="submit" name="action" value="Q&A"/>
           
        </form>
        <% 
            List<QandADTO> listQA = (List<QandADTO>) request.getAttribute("QA_MENTOR");
            if (listQA != null) {
                if (!listQA.isEmpty()) {
                    for (QandADTO QAM : listQA) {
                        if (QAM.getReply()== null) {
                            
        %>
        <a href="answerQuestion.jsp?questionID=<%=QAM.getQuestionID()%>&mentorID=<%=QAM.getMentorID()%>&studentID=<%=QAM.getStudentID()%>&eventID=<%=QAM.getEventID()%>&eventName=<%=QAM.getEventName()%>&&questionDetail=<%=QAM.getQuestionDetail()%>&reply=<%=QAM.getReply()%>"> <%=QAM.getQuestionID()%>. Answer</a><br>
       
        <%
                            }
                    }
                }
            }
         
        %>
        
         
        <form action="MainController">
            <input type="hidden" name="editQAMentor"/>
            
            <input type="submit" name="action" value="Answered"/>
           
        </form>
         
        <% 
            List<QandADTO> listAnswered = (List<QandADTO>) request.getAttribute("EDIT_QA_MENTOR");
            
            if (listAnswered != null) {
                if (!listAnswered.isEmpty()) {
                    for (QandADTO QAM : listAnswered) {
                        if ((QAM.getReply()) !=  null) {
                            
         %>
         <a href="editAnsweredQA.jsp?questionID=<%=QAM.getQuestionID()%>&mentorID=<%=QAM.getMentorID()%>&studentID=<%=QAM.getStudentID()%>&eventID=<%=QAM.getEventID()%>&eventName=<%=QAM.getEventName()%>&questionDetail=<%=QAM.getQuestionDetail()%>&reply=<%=QAM.getReply()%>"><%=QAM.getQuestionID()%>. Edit</a><br>
         
         <%
                        }
                    }
                }
            }
         
         %>
         
         
         
        <form action="MainController">
            <h2>Search <input type="text" name="search" value="<%=search%>"/>
                <select name="categoryId">
                <option value="">All</option>
                <option value="IT">Information technology</option>
                <option value="IB">International business</option>
                <option value="LA">Languages</option>
                </select>
                <input type="submit" name="action" value="Search"/>
            </h2>
        </form>
                
        <form action="MainController">
            <input type="hidden" name="search" value=""/>
            <input type="hidden" name="categoryId" value=""/>
            <h2>
            <input type="submit" name="action" value="List Events"/>
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
           &status=<%=event.getStatus()%>"> <%=event.getEventName()%> </a><br>
        <%
                    }
                }
            }
        %>
        
        
        <form action="MainController">
            <input type="hidden" name="eventMentorAttended" value="<%=mentor.getId()%>"/>
            <h2>
            <input type="submit" name="action" value="Event Attended"/>
            </h2>
        </form>
        <%
            List<EventDTO> listEventMentorAttended = (List<EventDTO>) request.getAttribute("LIST_EVENT_MENTOR_ATTEND");
            if (listEventMentorAttended != null) {
                if (!listEventMentorAttended.isEmpty()) {
                    for (EventDTO eventMentor : listEventMentorAttended) {
                
        %>
        <a href="eventDetail.jsp?id<%=eventMentor.getEventID()%>&name=<%=eventMentor.getEventName()%>&creatorID=<%=eventMentor.getCreatorID()%>&categoryID=<%=eventMentor.getCategoryID()%>
           &location=<%=eventMentor.getLocationID()%>&eventDetail=<%=eventMentor.getEventDetail()%>&seat=<%=eventMentor.getSeat()%>&startTime=<%=eventMentor.getStartTime()%>
           &endTime=<%=eventMentor.getEndTime()%>&creatTime=<%=eventMentor.getCreateTime()%>&image=<%=eventMentor.getImage()%>&video=<%=eventMentor.getVideo()%>
           &status=<%=eventMentor.getStatus()%>"> <%=eventMentor.getEventName()%> </a><br>
            Category: <%=eventMentor.getCategoryID()%>
        <%
                    }
                }
            }
        %>
        
        
        
        
    </body>
</html>
