package net.hello.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.hello.service.HelloService;

@WebServlet(name = "LiftCycleServlet", urlPatterns = {"/LiftCycleServlet"})
public class LiftCycleServlet extends HttpServlet {
    
    @Inject
    private HelloService helloService;
    
    @Override
    public void init() {
        System.out.println("LiftCycleServlet/init");
    }
    
    @Override
    public void destroy() {
        System.out.println("LiftCycleServlet/destroy");
    }
    
    public LiftCycleServlet() {
        System.out.println("LiftCycleServlet/constructor");
    }
    
    @PostConstruct
    public void myPostConstruct() {
        System.out.println("LiftCycleServlet/PostConstruct");
    }
    
    @PreDestroy
    public void myPreDestroy() {
        System.out.println("LiftCycleServlet/PreDestroy");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LiftCycleServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LiftCycleServlet at " + request.getContextPath() + "</h1>");
            out.println(helloService.greeting());
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
