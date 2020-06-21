package net.macspeed.tags;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MySimpleSwitchTagHandler extends SimpleTagSupport {
    private String var;
    private boolean caseMatch = false;

    public void setVar(String var) {
        this.var = var;
    }

    public boolean isCaseMatch() {
        return caseMatch;
    }

    public boolean match(String value) {
        boolean result = var.equals(value);

        if (result) {
            caseMatch = true;
        }
        
        return result;
    }

    public void doTag() throws JspException, IOException {

        JspFragment jBody = getJspBody();
        
        if (jBody != null) {
            jBody.invoke(null);
        }
    }
    
}
