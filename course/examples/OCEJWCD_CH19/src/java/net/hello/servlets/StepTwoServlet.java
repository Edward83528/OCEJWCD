package net.hello.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.hello.dao.MemberDAOImpl;

import net.hello.domain.Member;

public class StepTwoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        
        String birthDate = request.getParameter("birthDate");
        String bonus = request.getParameter("bonus");
        Date dateValue = null;
        
        List<String> errorMessages = new ArrayList<>();
                
        if (birthDate == null || birthDate.length() == 0) {
            errorMessages.add("Birthdate is required.");
        }
        else {
            DateFormat df = SimpleDateFormat.getDateInstance();
            
            try {
                dateValue = df.parse(birthDate);
            } catch (ParseException e) {
                errorMessages.add(e.toString());
            }
        }
        
        if (bonus == null || bonus.length() == 0) {
            errorMessages.add("Bonus is required.");
        }
        
        if (errorMessages.isEmpty()) {
            
            try (MemberDAOImpl dao = new MemberDAOImpl()) {
                HttpSession session = request.getSession();
                Member member = (Member) session.getAttribute("member");
                member.setBirthDate(dateValue);
                member.setBonus(Double.parseDouble(bonus));
                
                int id = dao.add(member);
                member.setId(id);
                
                RequestDispatcher rd  = request.getRequestDispatcher(
                        "add_member_success.jsp");
                rd.forward(request, response);                
            }
            catch (Exception e) {
                errorMessages.add(e.toString());
                request.setAttribute("errorMessages", errorMessages);
                RequestDispatcher rd  = request.getRequestDispatcher(
                        "step_two_form.jsp");
                rd.forward(request, response);
            }            
        }
        else {
            request.setAttribute("errorMessages", errorMessages);
            RequestDispatcher rd  = request.getRequestDispatcher(
                    "step_two_form.jsp");
            rd.forward(request, response);
        }
    }
    
}
