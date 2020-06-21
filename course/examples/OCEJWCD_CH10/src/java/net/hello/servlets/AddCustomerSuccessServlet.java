package net.hello.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.hello.domain.Customer;

public class AddCustomerSuccessServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddCustomerSuccessServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Add customer success!</h1>");
            
            Customer customer = (Customer) request.getAttribute("customer");
            
            out.println("Name: " + customer.getName() + "<br/>");
            out.println("Address: " + customer.getAddress() + "<br/>");
            out.println("Phone: " + customer.getPhone() + "<br/>");
            out.println("Notify: " + (customer.isNotify() ? "YES" : "NO") + "<br/>");
            
//            out.println("Name: " + request.getParameter("name") + "<br/>");
//            out.println("Address: " + request.getParameter("address") + "<br/>");
//            out.println("Phone: " + request.getParameter("phone") + "<br/>");
//            String notify = request.getParameter("notify");
//            out.println("Notify: " + (notify == null ? "NO" : "YES") + "<br/>");
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
