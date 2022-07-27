/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.m2i.javawebapp;

import fr.m2i.javawebapp.session.User;
import fr.m2i.javawebapp.session.userDb;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ben
 */
public class LoginServlet extends HttpServlet {

   
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
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
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
        
        if (request.getParameter("email") != null && request.getParameter("password") != null) {
            System.out.println("Good");
            login(request);
        this.getServletContext().getRequestDispatcher("/WEB-INF/welcome.jsp").forward(request, response);       

        }else{
                this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);

        }


    }
    public void login(HttpServletRequest request)
        {
        Map<String, String> messages = new HashMap<String, String>();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (userDb.checkUser(email, password) == null) {
                    messages.put("login", "Erreur email ou mdp");
                    return;
            }
        request.setAttribute("messages", messages);
        userDb.checkUser(email, password);
        User user = userDb.checkUser(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("email", user.getEmail());        
        session.setAttribute("role", user.getRole());

        //request.setAttribute("email", user.getEmail());
        //request.setAttribute("role", user.getRole());
           System.out.println("Good in login");
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
