package servlets;

import printers.Pass;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Kamil on 06.05.2017.
 */
@WebServlet(urlPatterns = "/pass")
public class Haslo extends HttpServlet {

    @EJB
    private Pass pass;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();

        if(session.getAttribute("user") == null){
            response.sendRedirect("index.jsp");
        }
        pass.printPass((String) session.getAttribute("printers"),writer);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
