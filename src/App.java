import xml.Message;
import xml.Pojo;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Kamil on 22.05.2017.
 */

@Path("/message")
public class App {

    @EJB
    Pojo pojo;

    @EJB
    MessageSender sender;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        return "info.Start";
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/newMessage")
    public void take (Message message) {
        System.out.println("Wiadomosc informacyjna");
        System.out.println(message.getMsg());
        pojo.addSave(message);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/danger")
    public void error(Message message){
        System.out.println("Brak biletu");
        System.out.println(message.getMsg());
        sender.sendMessage(message.getMsg(),String.valueOf(message.getStrefa()));
        pojo.addSave(message);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/empty")
    public void zwolnienie(Message message){
        System.out.println("Nie zwolniono miejsca");
        System.out.println(message.getMsg());
        sender.sendMessage(message.getMsg(),String.valueOf(message.getStrefa()));
        pojo.addSave(message);
    }


}
