package net.macspeed.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MyClassicSwitchTagHandler extends TagSupport {
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

    public int doStartTag() throws JspException {
        return EVAL_BODY_AGAIN;
    }
    
}
