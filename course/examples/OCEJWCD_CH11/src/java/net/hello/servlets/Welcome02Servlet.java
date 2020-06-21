package net.hello.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Welcome02Servlet extends HttpServlet {
    
    private String email = "service@google.com", name = "Service";
    
    @Override
    public void init() {
        ServletContext context = getServletContext();
        
        String emailIni = context.getInitParameter("email");
        
        if (emailIni != null) {
            email = emailIni;
        }
        
        String nameIni = context.getInitParameter("name");
        
        if (nameIni != null) {
            name = nameIni;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet WelcomeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Welcome!</h1>");
            out.println("Contact me: <a href='mailto:" + email + "'>" + name + "</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
