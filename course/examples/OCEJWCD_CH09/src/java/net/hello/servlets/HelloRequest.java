package net.hello.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloRequest</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloRequest at " + request.getContextPath() + "</h1>");
            
            Enumeration e = request.getHeaderNames();
            
            out.println("<ul>");
            
            while (e.hasMoreElements()) {
                out.println("<li>");
                out.println(e.nextElement() + " = " + 
                        request.getHeader(e.nextElement().toString()) + "<br/>");
                out.println("</li>");
            }
            
            out.println("</ul>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
