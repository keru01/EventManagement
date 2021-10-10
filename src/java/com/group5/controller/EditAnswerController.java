/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.controller;

import com.group5.event.QandADAO;
import com.group5.event.QandADTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nghia
 */
@WebServlet(name = "EditAnswerController", urlPatterns = {"/EditAnswerController"})
public class EditAnswerController extends HttpServlet {

    private final static String ERROR = "editAnsweredQA.jsp";
    private final static String SUCCESS = "mentor.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url  = ERROR;
        try {
            String answerQA = request.getParameter("editAnsweredQA");
            String questionID = request.getParameter("questionID");
            String mentorID = request.getParameter("mentorID");
            String studentID = request.getParameter("studentID");
            String eventID = request.getParameter("eventID");
            String questionDetail = request.getParameter("questionDetail");
            
            
           
            if (!answerQA.isEmpty()) {
                QandADTO newQA = new QandADTO(questionID, mentorID, studentID, eventID,"", questionDetail, answerQA);
                QandADAO dao = new QandADAO();
                 boolean check = dao.setListAnswer(newQA);
                 if(check)
                 url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error at SearchController" + e.toString());
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
