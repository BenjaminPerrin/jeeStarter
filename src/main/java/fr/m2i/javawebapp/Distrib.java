/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package fr.m2i.javawebapp;

import fr.m2i.javawebapp.distributeur.Distributeur;
import fr.m2i.javawebapp.distributeur.OutOfStockException;
import fr.m2i.javawebapp.distributeur.Produit;
import fr.m2i.javawebapp.distributeur.negativeParam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Distrib extends HttpServlet {

    private final Distributeur distributeur = Distributeur.getInstance();   


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
        setDistributorAttribute(request);
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
        Map<String, String> messages = new HashMap<String, String>();
        
        addCredit(request);
        try {
           buyProduct(request);
        } catch (OutOfStockException e) {
//            System.out.println(e);
            messages.put("buyProduct", e.getMessage());
        }
        
        try {
             AddSelectedMoney(request);
        } catch (negativeParam e) {
//            System.out.println(e);
            messages.put("AddSelectedMoney", e.getMessage());
        }

        setDistributorAttribute(request);
        request.setAttribute("messages", messages);
        this.getServletContext().getRequestDispatcher("/WEB-INF/distrib.jsp").forward(request, response);
    }

    private void addCredit(HttpServletRequest request) {
        Map<String, String> messages = new HashMap<String, String>();
        request.setAttribute("messages", messages);
        String addOne = request.getParameter("addOne");
        String addTwo = request.getParameter("addTwo");

        if (addOne == null && addTwo == null) {
            messages.put("addCredit", "veuillez entrer un nombre");
            return;
        }

        int amount = addOne != null ? 1 : 2;

        distributeur.insererArgent(amount);
        // distributeur.setCredit(distributeur.getCredit() + amount);
    }
    
    private void buyProduct(HttpServletRequest request)throws OutOfStockException {

        String productId = request.getParameter("productId");

        if (productId == null || "".equals(productId)) {
            return;
        }
        if(!distributeur.stockSuffisant(Integer.parseInt(productId))){
            throw new OutOfStockException("l'item n'est plus en stock");

        }
        distributeur.commanderProduit(Integer.parseInt(productId));
    }
    private void AddSelectedMoney(HttpServletRequest request) throws negativeParam{
        String addCredit = request.getParameter("addCredit");
        if(addCredit != null){
            if(Integer.parseInt(addCredit) < 0){
                throw new negativeParam("Veuillez entrez un nombre positif");
            }

        distributeur.insererArgent(Integer.parseInt(addCredit));
        }
        


    }

    private void setDistributorAttribute(HttpServletRequest request){
        request.setAttribute("credit", distributeur.getCredit());
        request.setAttribute("stock", distributeur.getStock());
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
