package app02a.hiddenfields;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {
        "/customer", "/editCustomer", "/updateCustomer"
})
public class CustomerServlet extends HttpServlet {

    private static final long serialVersionUID = -20L;

    private List<Customer> customers = new ArrayList<Customer>();

    @Override
    public void init() throws ServletException {
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("Donald D.");
        customer1.setCity("Miami");
        customers.add(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Mickey M.");
        customer2.setCity("Orlando");
        customers.add(customer2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String uri = req.getRequestURI();
        if (uri.endsWith("/customer")) {
            sendCustomerList(resp);
        } else if (uri.endsWith("editCustomer")) {
            sendEditCustomerForm(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int customerId = 0;
        try {
            customerId = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {

        }
        Customer customer = getCustomer(customerId);
        if (customer != null) {
            customer.setName(req.getParameter("name"));
            customer.setCity(req.getParameter("city"));
        }
        sendCustomerList(resp);
    }

    private void sendCustomerList(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>Customers</title></head>"
                + "<body><h2>Customers </h2>");
        writer.println("<ul>");
        for (Customer customer :
                customers) {
            writer.println("<li>" + customer.getName()
                    + "(" + customer.getCity() + ") ("
                    + "<a href='editCustomer?id=" + customer.getId()
                    + "'>edit</a>)");
        }
        writer.println("</ul>");
        writer.println("</body></html>");
    }

    private Customer getCustomer(int customerId) {
        for (Customer customer :
                customers) {
            if (customer.getId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    private void sendEditCustomerForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        int customerId = 0;
        try {
            customerId = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {

        }
        Customer customer = getCustomer(customerId);
        if (customer != null) {
            writer.println("<html><head>"
                    + "<title>Edit Customer</title></head>"
                    + "<body><h2>Edit Customer</h2>"
                    + "<form method='post' "
                    + "action='updateCustomer'>");
            writer.println("<input type='hidden' name='id' value='"
                    + customerId + "'/>");
            writer.println("<table>");
            writer.println("<tr><td>Name:</td><td>"
                    + "<input name='name' value='" +
                    customer.getName().replaceAll("'", "&#39;")
                    + "'/></td></tr>");
            writer.println("<tr><td>City:</td><td>"
                    + "<input name='city' value='" +
                    customer.getCity().replaceAll("'", "&#39;")
                    + "'/></td></tr>");
            writer.println("<tr>"
                    + "<td colspan='2' style='text-align:right'>"
                    + "<input type='submit' value='Update'/></td>"
                    + "</tr>");
            writer.println("<tr><td colspan='2'>"
                    + "<a href='customer'>Customer List</a>"
                    + "</td></tr>");
            writer.println("</table>");
            writer.println("</form></body>");
        } else {
            writer.println("No customer found");
        }
    }
}
