/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package fr.m2i.javawebapp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ben
 */
public class AuthFilter implements Filter {
    private ServletContext context;
    
    public AuthFilter() {
    }    
    
     public void init(FilterConfig filterConfig) {        
         this.context = filterConfig.getServletContext();
         this.context.log("AuthFilter Init");
    }
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {  
        // on cast en HttpServletRequest pour ensuite recuperer la session
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        
        // on verifie qu'un user est connecte
        boolean isLoggedIn = session != null && session.getAttribute("user") != null;
        
        //si pas co on affiche la page notWelcome
        if (!isLoggedIn) {
            this.context.log("User not connected");
            request.getRequestDispatcher("/WEB-INF/notWelcome.jsp").forward(request,response);
            return;
        }
        // tout va bien on passe au filter suivant
        chain.doFilter(request, response);
    }
    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }
}
