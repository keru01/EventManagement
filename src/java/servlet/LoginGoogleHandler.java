/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.group5.users.UserDAO;
import com.group5.users.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import google.user.UserGoogleDTO;
/**
 *
 * @author Minh Khoa
 */
public class LoginGoogleHandler extends HttpServlet {

    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String code = request.getParameter("code");
        String accessToken =getToken(code);
        UserGoogleDTO userGoogle = getUserInfo(accessToken);
        HttpSession session = request.getSession();
        String url="error.jsp";
        if(userGoogle.getEmail().contains("@fpt.edu.vn")){
            request.setAttribute("UserGoogle", userGoogle);
            request.getRequestDispatcher("LoginController").forward(request, response);
            
        }
        else{
            session.setAttribute("ERROR_MESSAGE", "You are not from FPT!");
            url="error.jsp";
            response.sendRedirect(url);
        }
        
        System.out.println(userGoogle);
        
    }

    public static String getToken(String code) throws ClientProtocolException, IOException{
        String respone = Request.Post(constants.Constants.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", constants.Constants.GOOGLE_CLIENT_ID)
                        .add("client_secret", constants.Constants.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", constants.Constants.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", constants.Constants.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();
        JsonObject jobj =  new Gson().fromJson(respone, JsonObject.class);
        String acessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return acessToken;
    }
    
    public static UserGoogleDTO getUserInfo(final String accessToken) throws ClientProtocolException, IOException{
        String link = constants.Constants.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String respone = Request.Get(link).execute().returnContent().asString();
        UserGoogleDTO googlePojo = new Gson().fromJson(respone, UserGoogleDTO.class);
        return googlePojo;
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
