package net.macspeed.tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MySimpleDefaultTagHandler extends SimpleTagSupport {

    public void doTag() throws JspException, IOException {

        JspFragment jBody = getJspBody();

        MySimpleSwitchTagHandler parent =
            (MySimpleSwitchTagHandler) getParent();

        if (jBody != null && parent != null && !parent.isCaseMatch()) {
            jBody.invoke(null);
        }

    }
    
}