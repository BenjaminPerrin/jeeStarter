/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.m2i.javawebapp;

import fr.m2i.javawebapp.distributeur.Distributeur;
import fr.m2i.javawebapp.distributeur.Produit;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ben
 */
public class Distrib extends HttpServlet {

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
        Distributeur distributeur = Distributeur.getInstance();
        int credit = distributeur.getCredit();
        List<Produit> stock = distributeur.getStock();
        request.setAttribute("stock",stock);
        request.setAttribute("credit",credit);
            this.getServletContext().getRequestDispatcher("/WEB-INF/distrib.jsp").forward(request, response);

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
            Distributeur distributeur = Distributeur.getInstance();
             if (request.getParameter("onecredit") != null) {
                distributeur.insererArgent(1);
            } else if(request.getParameter("twocredit") != null) {
                distributeur.insererArgent(2);

            }
            int credit = distributeur.getCredit();
            System.out.println(request.getParameter("id"));
            if (request.getParameter("id") != null) {
                int itemToBuy = Integer.parseInt(request.getParameter("id"));
                distributeur.commanderProduit(itemToBuy);
               
            }
            List<Produit> stock = distributeur.getStock();
            request.setAttribute("stock",stock);
            request.setAttribute("credit",credit);
            
            this.getServletContext().getRequestDispatcher("/WEB-INF/distrib.jsp").forward(request, response);

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
