package servlets;

import xml.MessageInfoPrint;
import xml.Pojo;
import xml.User;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Kamil on 06.05.2017.
 */
@WebServlet(urlPatterns = "/logowanie")
public class Logowanie extends HttpServlet {

    @EJB
    private Pojo pojo;

    @EJB
    MessageInfoPrint infoPrint;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<User> list = pojo.getLista();
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        infoPrint.setName("Wynik");
        for (int i=0;i<list.size();i++) {
            User u = list.get(i);
            if(u.getName().equals(user) && u.getPassword().equals(pwd)){

                if(u.getLogged().equals("false")) {
                    u.setLogged("true");
                    pojo.getLista().remove(i);
                    pojo.getLista().add(i,u);
                    pojo.PojoStart(pojo.getLista());
                    String role = u.getRole();
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                    session.setAttribute("printers", role);

                    session.setMaxInactiveInterval(30 * 60);
                    Cookie userName = new Cookie("user", user);
                    userName.setMaxAge(30 * 60);
                    response.addCookie(userName);
                    response.sendRedirect("success.jsp");
                } else {

                    PrintWriter out= response.getWriter();
                    out.println("<font color=red>Zalogowales sie wczesniej</font>");

                }
            }

        }

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        PrintWriter out= response.getWriter();
        out.println("<font color=red>Bledne dane</font>");
        rd.include(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void error(String msg,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        PrintWriter out= response.getWriter();
        out.println("<font color=red>"+msg+"</font>");
        rd.include(request, response);
    }
}
