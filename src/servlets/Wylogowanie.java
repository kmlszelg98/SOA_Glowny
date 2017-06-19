package servlets;

import xml.Pojo;
import xml.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Kamil on 06.05.2017.
 */
@WebServlet(urlPatterns = "/wyloguj")
public class Wylogowanie extends HttpServlet {

    @EJB
    private Pojo pojo;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie loginCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    loginCookie = cookie;
                    break;
                }
            }
        }

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        ArrayList<User> list = pojo.getLista();
        for(int i=0;i<list.size();i++){
            User u = list.get(i);
            if(u.getName().equals(user)){
                u.setLogged("false");
                pojo.getLista().remove(i);
                pojo.getLista().add(i,u);
                pojo.PojoStart(pojo.getLista());
            }
        }
        session.removeAttribute("user");
        session.removeAttribute("printers");
        if (loginCookie != null) {
            loginCookie.setMaxAge(0);
            response.addCookie(loginCookie);
        }
        response.sendRedirect("index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
