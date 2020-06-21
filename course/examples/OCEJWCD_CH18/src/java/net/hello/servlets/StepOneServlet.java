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

import net.hello.domain.Member;

public class StepOneServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        
        List<String> errorMessages = new ArrayList<>();
        
        if (firstName == null || firstName.length() == 0) {
            errorMessages.add("First Name is required.");
        }
        
        if (lastName == null || lastName.length() == 0) {
            errorMessages.add("Last Name is required.");
        }
                
        if (errorMessages.isEmpty()) {
            Member member = new Member(0, firstName, lastName, null, 0);
            HttpSession session = request.getSession();
            session.setAttribute("member", member);
            RequestDispatcher rd  = request.getRequestDispatcher(
                    "/admin/step_two_form.jsp");
            rd.forward(request, response);
        }
        else {
            request.setAttribute("errorMessages", errorMessages);
            RequestDispatcher rd  = request.getRequestDispatcher(
                    "/admin/step_one_form.jsp");
            rd.forward(request, response);
        }
    }
    
}
