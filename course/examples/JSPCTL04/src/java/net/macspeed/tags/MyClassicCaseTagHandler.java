package net.macspeed.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MyClassicCaseTagHandler extends TagSupport {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public int doStartTag() throws JspException {
        MyClassicSwitchTagHandler parent =
            (MyClassicSwitchTagHandler) getParent();

        if (parent != null && 
            !parent.isCaseMatch() &&
            parent.match(value)) {
            return EVAL_BODY_INCLUDE;
        }
        else {
            return SKIP_BODY;
        }
    }    
}