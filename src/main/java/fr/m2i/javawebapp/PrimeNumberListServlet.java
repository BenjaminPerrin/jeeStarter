/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.m2i.javawebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ben
 */
public class PrimeNumberListServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    public static String checkPrime(int n) {
        int count = 0;

        
        if (n < 2)
            return n+" nombre non premier";

        for (int i = 1; i <= n; i++) 
        { 
            if (n % i == 0) 
                count += 1; 
        } 

        if (count > 2){
            return n+" nombre non premier";

        }else{
            return n+" nombre premier";  
        }  }
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
            ArrayList<String> numbers = new ArrayList<String>();

        if(request.getParameter("start") != null && request.getParameter("end") != null){
            int start = Integer.parseInt(request.getParameter("start"));            
            int end = Integer.parseInt(request.getParameter("end"));
               for (int i = start; i <= end; i++) 
                { 
                    numbers.add(checkPrime(i));
                } 
            request.setAttribute("numbers",numbers);
        }  
        this.getServletContext().getRequestDispatcher("/primeNumberListServlet.jsp").forward(request, response);
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
            super.doGet(request, response);
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
