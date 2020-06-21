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

public class StepTwoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        String phone = request.getParameter("phone");
        String notify = request.getParameter("notify");
        
        List<String> errorMessages = new ArrayList<>();
                
        if (phone == null || phone.length() == 0) {
            errorMessages.add("Phone is required.");
        }
        
        if (errorMessages.isEmpty()) {
            HttpSession session = request.getSession();
            Customer customer = (Customer) session.getAttribute("customer");
            customer.setPhone(phone);
            customer.setNotify(notify != null);
            RequestDispatcher rd  = request.getRequestDispatcher(
                    "add_customer_success.jsp");
            rd.forward(request, response);
        }
        else {
            request.setAttribute("errorMessages", errorMessages);
            RequestDispatcher rd  = request.getRequestDispatcher(
                    "step_two_form.jsp");
            rd.forward(request, response);
        }
    }
    
}
