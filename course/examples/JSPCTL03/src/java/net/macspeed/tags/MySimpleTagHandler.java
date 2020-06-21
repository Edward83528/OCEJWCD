package net.macspeed.tags;

import java.io.IOException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MySimpleTagHandler extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {
        JspContext jContext = getJspContext();
        JspWriter out = jContext.getOut();

        out.print("Hello! Simple tag!");

        JspFragment jspBody = getJspBody();

        if (jspBody != null) {
            out.println("<p>");
            jspBody.invoke(null);
            out.println("</p>");
        }
    }

}
