package net.macspeed.tags;

import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MySimpleListTagHandler extends SimpleTagSupport {

    private List items;

    public void setItems(List items) {
        this.items = items;
    }

    public void doTag() throws JspException, IOException {
        JspContext jContext = getJspContext();
        JspWriter out = jContext.getOut();

        if (items != null && items.size() > 0) {
            out.println("<ul>");

            for (Object o : items) {
                out.print("<li>");
                out.print(o);
                out.print("</li>");
            }

            out.println("</ul>");
        }
        else {
            out.println("<p>Empty!</p>");
        }
    }
}
