package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProgrammaticServlet", urlPatterns = {"/prog"})
//@ServletSecurity(@HttpConstraint(rolesAllowed = "manager"))

//@ServletSecurity(httpMethodConstraints = {
//        @HttpMethodConstraint(value = "GET", rolesAllowed = "manager")
//})

@ServletSecurity(value = @HttpConstraint(rolesAllowed = "manager"),
        httpMethodConstraints = {@HttpMethodConstraint("GET")}
)
public class ProgrammaticServlet extends HttpServlet {

    private static final long serialVersionUID = 87620L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("doGet");
//        if (request.authenticate(response)) {
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            out.println("Welcome");
//        } else {
//            System.out.println("User not authenticated");
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("doPost");
    }
}
