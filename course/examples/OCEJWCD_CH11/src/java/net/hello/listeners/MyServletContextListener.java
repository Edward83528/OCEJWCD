package net.hello.listeners;

import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import net.hello.dao.MemberJdbcDAO;

public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            MemberJdbcDAO memberJdbcDAO = new MemberJdbcDAO(
                "localhost", "3306", "ocejwcd", "root", "");
            ServletContext context = sce.getServletContext();
            context.setAttribute("memberJdbcDAO", memberJdbcDAO);
            context.log("MyServletContextListener.contextInitialized: MemberJdbcDAO create success!");
        }
        catch (SQLException e) {
            sce.getServletContext().log(
                    "MyServletContextListener.contextInitialized", e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        MemberJdbcDAO memberJdbcDAO = (MemberJdbcDAO) 
                context.getAttribute("memberJdbcDAO");
        
        try {
            memberJdbcDAO.close();
            context.log("MyServletContextListener.contextDestroyed: MemberJdbcDAO close!");
        }
        catch (SQLException e) {
            sce.getServletContext().log(
                    "MyServletContextListener.contextDestroyed", e);
        }
    }
    
}
