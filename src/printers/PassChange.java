package printers;

import xml.Pojo;
import xml.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Kamil on 06.05.2017.
 */
@WebServlet(urlPatterns = "/change")
public class PassChange extends HttpServlet {

    @EJB
    private Pojo pojo;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        if(user==null){
            user = (String)request.getSession().getAttribute("user");
        }

        ArrayList<User> list = pojo.getLista();
        for(int i=0;i<list.size();i++){
            User u = list.get(i);
            if(u.getName().equals(user)){
                u.setPassword(pass);
                pojo.getLista().remove(i);
                pojo.getLista().add(i,u);
                pojo.PojoStart(pojo.getLista());
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
