package printers;

import start.Place;
import start.PrzyjazdService;
import xml.Pojo;
import xml.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.PrintWriter;
import java.util.ArrayList;
import xml.Message;
/**
 * Created by Kamil on 11.06.2017.
 */

@Stateless
public class MessagePrinter {

    @EJB
    private Pojo pojo;


    public void print(String role,String name, PrintWriter writer){
        PrzyjazdService service = new PrzyjazdService();
        if(role.equals("admin")){
            ArrayList<Message> list = pojo.getMsg();
            writer.println("<h2>Twoje powiadomienia</h2><br/>");
            System.out.println("ILOSC"+ list.size());
            for (Message message:list) {
                writer.println("<h4> Strefa: "+ message.getStrefa()+" Tresc: "+message.getMsg()+"</h4><br/>");
            }

        }
        else {
            User u = pojo.findUser(name);
            ArrayList<Message> list = pojo.getMsg();
            writer.println("<h2>Powiadomienia</h2><br/>");
            for (Message message:list) {
                if(message.getStrefa()==u.getStrefa())
                writer.println("<h4> Tresc: "+message.getMsg());
            }
        }
    }
}
