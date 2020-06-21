package net.macspeed.tags;

import java.io.IOException;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ExamplesTagHandler extends SimpleTagSupport {
    private String sample;

    public void setSample(String sample) {
        this.sample = sample;
    }

    public void doTag() throws JspException, IOException {
        JspContext jContext = getJspContext();
        JspWriter out = jContext.getOut();

        out.println("<p>");
        out.println("<a href='" + sample + "'>" + sample + "</a>");
        out.println("</p>");

    }

}
