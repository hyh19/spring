package customtag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

public class MyFirstTag implements SimpleTag {

    JspContext jspContext;

    public void doTag() throws JspException, IOException {
        System.out.println("doTag");
        jspContext.getOut().print("This is my first tag.");
    }

    public void setParent(JspTag jspTag) {
        System.out.println("setParent");
    }

    public JspTag getParent() {
        System.out.println("getParent");
        return null;
    }

    public void setJspContext(JspContext jspContext) {
        System.out.println("setJspContext");
        this.jspContext = jspContext;
    }

    public void setJspBody(JspFragment jspFragment) {
        System.out.println("setJspBody");
    }
}
