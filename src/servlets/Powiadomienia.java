package servlets;

import printers.MessagePrinter;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.PrintWriter;

/**
 * Created by Kamil on 11.06.2017.
 */
@WebServlet(urlPatterns = "/powiadomienia")
public class Powiadomienia extends HttpServlet {

    @EJB
    MessagePrinter messagePrinter;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {

        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
            response.sendRedirect("index.jsp");        }

        response.setIntHeader("Refresh", 15);


        String role = (String) session.getAttribute("printers");
        String name = (String) session.getAttribute("user");
        messagePrinter.print(role,name,writer);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException {
        doPost(request,response);
    }
}
