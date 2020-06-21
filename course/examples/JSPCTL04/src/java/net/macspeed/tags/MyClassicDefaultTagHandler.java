package net.macspeed.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MyClassicDefaultTagHandler extends TagSupport {

    public int doStartTag() throws JspException {
        MyClassicSwitchTagHandler parent =
            (MyClassicSwitchTagHandler) getParent();

        if (parent != null && !parent.isCaseMatch()) {
            return EVAL_BODY_INCLUDE;
        }
        else {
            return SKIP_BODY;
        }
    }    
}