package net.hello.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.hello.domain.Member;

@WebServlet(name = "ListMemberJPAServlet", urlPatterns = {"/ListMemberJPAServlet"})
public class ListMemberJPAServlet extends HttpServlet {

    @PersistenceUnit(unitName = "OCPJWCD_CH21PU")
    private EntityManagerFactory emf;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListMemberJPAServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListMemberJPAServlet at " + request.getContextPath() + "</h1>");

            EntityManager em = emf.createEntityManager();

            TypedQuery<Member> query = em.createQuery(
                    "SELECT m FROM Member m", Member.class);

            List<Member> ms = query.getResultList();

            for (Member m : ms) {
                out.println(m + "<br/>");
            }

            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
