package net.macspeed.tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyClassicTagHandler extends TagSupport {

    public int doStartTag() throws JspException {
        JspWriter out = pageContext.getOut();

        try {
            out.println("Hello! Classic tag!");
        }
        catch (IOException e) {
            throw new JspException( e.toString() );
        }

        //return EVAL_BODY_INCLUDE;
        return SKIP_BODY;
    }

    public int doAfterBody() throws JspException {
        //return EVAL_BODY_AGAIN;
        return SKIP_BODY;
    }

    public int doEndTag() throws JspException {
        //return EVAL_PAGE;
        return SKIP_PAGE;
    }
}
