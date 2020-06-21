package net.hello.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
    
    private static final String DEFAULT_NAME = "World";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            String name = request.getParameter("name");
            
            if (name == null || name.length() == 0) {
                name = DEFAULT_NAME;
            }
            
            out.println("Hello, " + name);
            out.println("</body>");
            out.println("</html>");
        }
    }

}
