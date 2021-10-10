/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group5.controller;

import com.group5.users.SpecialUserDAO;
import com.group5.users.SpecialUserDTO;
import com.group5.users.UserDAO;
import com.group5.users.UserDTO;
import google.user.UserGoogleDTO;
import java.awt.ActiveEvent;
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
public class LoginController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String STUDENT_PAGE = "index.jsp";
    private static final String MENTOR_PAGE = "mentor.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            //lay id cua uG check với hệ thống
                //UserDAO dao = new UserDAO();
                //UserDTO user = new UserDTO();
                //HttpSession session = request.getSession();
            //nếu có thì cho vô theo role
                //role student vô student page
                //role mentor vào mentor
                //role admin vào admin
                //role leader vào trang leader
            //nếu ko có thì add vào db với role mặc định là student
            UserGoogleDTO googleUser = (UserGoogleDTO) request.getAttribute("UserGoogle");
            String checkID = googleUser.getId();

            UserDAO dao = new UserDAO();
            UserDTO user = dao.checkLoginSpecial(checkID);
            HttpSession session = request.getSession();
            
            if (user == null) {
                UserDTO newUser = new UserDTO(googleUser.getId(), googleUser.getEmail(), "ACT", googleUser.getName(), "STU");
                dao.insertUser(newUser);
                user = dao.checkLoginSpecial(checkID);
                
            }
            String a =user.getRoleID();
            if ("MT".equals(user.getRoleID())) {
             url = MENTOR_PAGE;   
            }else{
            url = STUDENT_PAGE;
            }
            session.setAttribute("LOGIN_USER", user);
        } catch (Exception e) {
            log("Error at LoginController" + e.toString());
        } finally {
            response.sendRedirect(url);
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
