/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Minh Khoa
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String EDITANSWERQA = "EditQAController";
    private static final String ANSWERQA = "AnswerQAController";
    private static final String LOGIN = "LoginController";
    private static final String SEARCH = "SearchController";
    private static final String LOGOUT = "LogoutController";
    private static final String GETLISTEVENT = "SearchController";
    private static final String EVENTMENTORATTEND = "SearchEventMentorAttendController";
    private static final String QANDAMENTOR = "QandAMentorController";
    private static final String EDITANWERED = "EditAnswerController";
    private static final String REGISTERMENTOR = "RegisterMentorController";
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if ("Login".equals(action)) {
                url = LOGIN;
            } else if("Search".equals(action)){
                url = SEARCH;
            }
            else if("Edit Answered".equals(action)){
                url = EDITANWERED;
            }else if("Register Mentor".equals(action)){
                url = REGISTERMENTOR;
            }
            else if("AnswerQA".equals(action)){
                url = ANSWERQA;
            }
            else if("Answered".equals(action)){
                url = EDITANSWERQA;
            }
            else if("Logout".equals(action)){
                url = LOGOUT;
            } else if("List Events".equals(action)){
                url = GETLISTEVENT;
            }
            else if("Q&A".equals(action)){
                url = QANDAMENTOR;
            }
             else if("Event Attended".equals(action)){
                url = EVENTMENTORATTEND;
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("ERROR_MESSAGE", "Function is not supported!");
            }
        } catch (Exception e) {
            log("Error at MainController" + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
