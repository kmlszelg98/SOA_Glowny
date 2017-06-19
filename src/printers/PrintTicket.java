package printers;

import javax.ejb.Stateless;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import xml.Pojo;
import xml.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * Created by Kamil on 24.05.2017.
 */

@Stateless
public class PrintTicket {

    @EJB
    private Pojo pojo;
    public static final Client client = Client.create();



    public void printList(Ticket t,PrintWriter writer){
        writer.print("<h4>");
        writer.print(t);
        writer.print("</h4><br/>");
    }


    public void print(String role,String name, PrintWriter writer){

        Type listType = new TypeToken<ArrayList<Ticket>>() {
        }.getType();
        TypeReference reference = new TypeReference<ArrayList<Ticket>>(){};
        ObjectMapper mapper = new ObjectMapper();

        WebResource active = client.resource("http://localhost:8080/Bilet/start/tickets/active");
        ClientResponse responseActive = active.accept("application/json").get(ClientResponse.class);
        String outputActive = responseActive.getEntity(String.class);
        ArrayList<Ticket> ticketActive = new ArrayList<>();
        try {
            ticketActive = mapper.readValue(outputActive,reference);
        } catch (IOException e) {
            e.printStackTrace();
        }

        WebResource disabled = client.resource("http://localhost:8080/Bilet/start/tickets/disabled");
        ClientResponse responseDisabled = disabled.accept("application/json").get(ClientResponse.class);
        String outputDisabled = responseDisabled.getEntity(String.class);

        ArrayList<Ticket> ticketDisabled = new ArrayList<>();
        try {
            ticketDisabled = mapper.readValue(outputDisabled,reference);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (role.equals("admin")) {
            writer.println("<h2>Bilety aktywne</h2><br/>");
            for (Ticket t : ticketActive) {
                printList(t, writer);
            }

            writer.println("<h2>Bilety nieaktywne</h2><br/>");
            for (Ticket t : ticketDisabled) {
                    printList(t, writer);
                }
            } else {
                User u = pojo.findUser(name);
                writer.println("<h2>Bilety aktywne</h2><br/>");
                for (Ticket t : ticketActive) {
                    if (t.getStrefa() == u.getStrefa()) {
                        printList(t, writer);
                    }
                }

                writer.println("<h2>Bilety nieaktywne</h2><br/>");
                for (Ticket t : ticketDisabled) {
                    if (t.getStrefa() == u.getStrefa()) {
                        printList(t, writer);
                }
            }

        }

    }
}
