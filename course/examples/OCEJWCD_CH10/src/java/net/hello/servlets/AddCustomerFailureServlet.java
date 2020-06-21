package net.hello.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCustomerFailureServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddCustomerFailureServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Customer data error!</h1>");
            
            List<String> errorMessages = (List<String>)
                    request.getAttribute("errorMessages");
            
            out.println("<ul>");
            for (String message : errorMessages) {
                out.println("<li>" + message + "</li>");
            }
            out.println("</ul>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
