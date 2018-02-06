package customtag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class SelectElementTag extends SimpleTagSupport {

    private String[] countries = {"Australia", "Brazil", "China" };

    @Override
    public void doTag() throws JspException, IOException {
        JspContext jspContext = getJspContext();
        JspWriter out = jspContext.getOut();
        out.print("<select>\n");
        for (int i = 0; i < 3; i++) {
            jspContext.setAttribute("value", countries[i]);
            jspContext.setAttribute("text", countries[i]);
            getJspBody().invoke(null);
        }
        out.print("</select>\n");
    }
}
