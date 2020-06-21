package net.macspeed.tags;

import java.io.IOException;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.TagSupport;

public class MyClassicForEachTagHandler extends TagSupport {

    private List items;
    private String var;
    private int count = 0;

    public void setItems(List items) {
        this.items = items;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public int doStartTag() throws JspException {
        if (items == null || items.isEmpty()) {
            return SKIP_BODY;
        }
        else {
            pageContext.setAttribute(var, items.get(count));
            count++;
            return EVAL_BODY_INCLUDE;
        }
    }

    public int doAfterBody() throws JspException {
        if (count < items.size()) {
            pageContext.setAttribute(var, items.get(count));
            count++;
            return EVAL_BODY_AGAIN;
        }
        else {
            return SKIP_BODY;
        }        
    }

}
