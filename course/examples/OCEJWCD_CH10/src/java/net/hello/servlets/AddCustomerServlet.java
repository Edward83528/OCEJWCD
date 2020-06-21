package net.hello.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.hello.domain.Customer;

public class AddCustomerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String notify = request.getParameter("notify");
        
        List<String> errorMessages = new ArrayList<>();
        
        if (name == null || name.length() == 0) {
            errorMessages.add("Name is required.");
        }
        
        if (address == null || address.length() == 0) {
            errorMessages.add("Address is required.");
        }
        
        if (phone == null || phone.length() == 0) {
            errorMessages.add("Phone is required.");
        }
        
        if (errorMessages.isEmpty()) {
            Customer customer = new Customer(name, address, phone, 
                notify != null);
            request.setAttribute("customer", customer);
            RequestDispatcher rd  = request.getRequestDispatcher(
                    "add_customer_success.view");
            rd.forward(request, response);
        }
        else {
            request.setAttribute("errorMessages", errorMessages);
            RequestDispatcher rd  = request.getRequestDispatcher(
                    "add_customer_failure.view");
            rd.forward(request, response);
        }
    }
    
}
