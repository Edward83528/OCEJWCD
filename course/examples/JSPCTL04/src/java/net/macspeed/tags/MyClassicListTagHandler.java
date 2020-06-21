package net.macspeed.tags;

import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MyClassicListTagHandler extends TagSupport {

    private List items;

    public void setItems(List items) {
        this.items = items;
    }

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();

        try {
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
        catch (IOException e) {
            throw new JspException(e.toString());
        }

        return SKIP_PAGE;
    }
}
