package servlets;

import printers.PrintTicket;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Kamil on 24.05.2017.
 */
@WebServlet(urlPatterns = "/ticket")
public class Tickets extends HttpServlet {

    @EJB
    private PrintTicket printer;




    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setIntHeader("Refresh", 15);
        PrintWriter writer = response.getWriter();

        HttpSession session = request.getSession();

        if(session.getAttribute("user") == null){
            response.sendRedirect("index.jsp");
        }
        String role = (String) session.getAttribute("printers");
        String name = (String) session.getAttribute("user");
        printer.print(role, name, writer);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
