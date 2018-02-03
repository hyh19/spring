package app01a;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletConfigDemoServlet",
        urlPatterns = {"/servletConfigDemo"},
        initParams = {
                @WebInitParam(name = "admin", value = "Harry Taciak"),
                @WebInitParam(name = "email", value = "admin@example.com")
        })
public class ServletConfigDemoServlet implements Servlet {

    private transient ServletConfig servletConfig;

    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletConfig servletConfig = getServletConfig();
        String admin = servletConfig.getInitParameter("admin");
        String email = servletConfig.getInitParameter("email");
        servletResponse.setContentType("text/html");
        PrintWriter writer = servletResponse.getWriter();
        writer.print("<html><head></head><body>" +
                "Admin:" + admin +
                "<br/>Email:" + email +
                "</body></html>");
    }

    public String getServletInfo() {
        return "ServletConfig demo";
    }

    public void destroy() {

    }
}