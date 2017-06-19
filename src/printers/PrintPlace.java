package printers;

import start.*;
import xml.MessageInfoPrint;
import xml.Pojo;
import xml.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Kamil on 11.05.2017.
 */

@Stateless
public class PrintPlace {

    @EJB
    private Pojo pojo;


    public void printPass(String role,String name, PrintWriter writer){
        PrzyjazdService service = new PrzyjazdService();
        if(role.equals("admin")){
            ArrayList<Place> list = (ArrayList<Place>) service.getPrzyjazdPort().getList(0);
            writer.println("<h2>Miejsca wszystkie</h2><br/>");
            for (Place m:list) {
                writer.println("<h4> Id: "+m.getId()+" Strefa: "+m.getStrefa()+" Wolne: "+m.getWolne()+"</h4><br/>");
            }

        }
        else {
            User u = pojo.findUser(name);
            ArrayList<Place> list = (ArrayList<Place>) service.getPrzyjazdPort().getList(u.getStrefa());
            System.out.println("ILOSC MIEJSC"+ list.size());
            writer.println("<h2>Miejsca w twojej strefie</h2><br/>");
            for (Place m:list) {
                writer.println("<h4> Id: "+m.getId()+" Wolne: "+m.getWolne()+"</h4><br/>");
            }
        }
    }
}
