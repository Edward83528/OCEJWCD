package net.macspeed.tags;

import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MySimpleForEachTagHandler extends SimpleTagSupport {

    private List items;
    private String var;

    public void setItems(List items) {
        this.items = items;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public void doTag() throws JspException, IOException {

        JspContext jContext = getJspContext();
        JspFragment jBody = getJspBody();

        if (items != null) {
            for (Object o : items) {
                jContext.setAttribute(var, o);
                jBody.invoke(null);
            }
        }

    }

}
