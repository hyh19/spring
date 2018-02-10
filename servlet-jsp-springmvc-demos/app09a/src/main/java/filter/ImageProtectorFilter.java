package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "ImageProtectorFilter", urlPatterns = {"*.png", "*.jpg", "*.gif"})
public class ImageProtectorFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("ImageProtectorFilter");
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        String referer = httpServletRequest.getHeader("referer");
        System.out.println("referer: " + referer);
        if (referer != null) {
            chain.doFilter(req, resp);
        } else {
            throw new ServletException("Image not available");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
