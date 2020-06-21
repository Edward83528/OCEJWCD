package net.hello.servlets;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.hello.domain.Customer;

public class StepOneServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        
        List<String> errorMessages = new ArrayList<>();
        
        if (name == null || name.length() == 0) {
            errorMessages.add("Name is required.");
        }
        
        if (address == null || address.length() == 0) {
            errorMessages.add("Address is required.");
        }
                
        if (errorMessages.isEmpty()) {
            Customer customer = new Customer(name, address, null, false);
            HttpSession session = request.getSession();
            session.setAttribute("customer", customer);
            RequestDispatcher rd  = request.getRequestDispatcher(
                    "step_two_form.jsp");
            rd.forward(request, response);
        }
        else {
            request.setAttribute("errorMessages", errorMessages);
            RequestDispatcher rd  = request.getRequestDispatcher(
                    "step_one_form.jsp");
            rd.forward(request, response);
        }
    }
    
}
