package app16c.servlet;

import app16c.controller.InputProductController;
import app16c.controller.SaveProductController;
import app16c.domain.Product;
import app16c.form.ProductForm;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DispatcherServlet", urlPatterns = {"*.action"})
public class DispatcherServlet extends HttpServlet {

    private static final long serialVersionUID = 748495L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String uri = request.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);

        String dispatchUrl = null;
        if (action.equals("product_input.action")) {
            InputProductController controller = new InputProductController();
            dispatchUrl = controller.handleRequest(request, response);
        } else if (action.equals("product_save.action")) {
            SaveProductController controller = new SaveProductController();
            dispatchUrl = controller.handleRequest(request, response);
        }
        if (dispatchUrl != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher(dispatchUrl);
            dispatcher.forward(request, response);
        }
    }
}
