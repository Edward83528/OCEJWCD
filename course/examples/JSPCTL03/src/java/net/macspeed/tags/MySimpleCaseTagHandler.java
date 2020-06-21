package net.macspeed.tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MySimpleCaseTagHandler extends SimpleTagSupport {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public void doTag() throws JspException, IOException {

        JspFragment jBody = getJspBody();

        MySimpleSwitchTagHandler parent =
            (MySimpleSwitchTagHandler) getParent();

        if (parent != null && !parent.isCaseMatch()) {
            if (parent.match(value)) {
                jBody.invoke(null);
            }
        }

    }
    
}