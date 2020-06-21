package net.hello.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.hello.dao.MemberJdbcDAO;
import net.hello.domain.Member;

public class ListMemberServlet extends HttpServlet {
    
    private MemberJdbcDAO memberJdbcDAO;
    
    @Override
    public void init() {
        ServletContext context = getServletContext();
        memberJdbcDAO = (MemberJdbcDAO) context.getAttribute("memberJdbcDAO");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>List Member</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>List Member</h1>");
  
            try {
                List<Member> members = memberJdbcDAO.getAll();
                
                out.println("<ul>");
                
                for (Member member : members) {
                    out.println("<li>" + member + "</li>");
                }
                
                out.println("</ul>");
            }
            catch (SQLException e) {
                out.println(e);
            }
            
            out.println("</body>");
            out.println("</html>");
        }
    }

}
