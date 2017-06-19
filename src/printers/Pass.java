package printers;

import xml.Pojo;
import xml.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Kamil on 06.05.2017.
 */
@Stateless
public class Pass {

    @EJB
    private Pojo pojo;

    public void printPass(String role, PrintWriter writer){
        if(role.equals("admin")){
            ArrayList<User> list = pojo.getLista();
            writer.println("<h2>Lista uzytkownikow</h2><br/>");
            for (User u:list) {
                writer.println("<h3>"+u.getName()+"</h3><br/>");
            }
            writer.println("<form action=\"change\" method=\"post\">");
            writer.println("Uzytkownik <input type=\"text\" name=\"user\"><br/>");
            writer.println("Nowe haslo <input type=\"text\" name=\"pass\"><br/>");
            writer.println("<input type=\"submit\" value=\"Zmien\">");
            writer.println("</form>");
        }
        else {
            writer.println("<h2>Zmien swoje haslo</h2><br/>");
            writer.println("<form action=\"change\" method=\"post\">");
            writer.println("Nowe haslo <input type=\"text\" name=\"pass\"><br/>");
            writer.println("<input type=\"submit\" value=\"Zmien\">");
            writer.println("</form>");
        }
    }
}
