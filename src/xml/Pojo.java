package xml;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by Kamil on 06.05.2017.
 */

@Stateless
public class Pojo {

    private static String path2 = "C:\\Users\\Kamil\\IdeaProjects\\Parking\\Wersja3\\Glowny\\users.xml";
    private static String path = "C:\\Users\\Kamil\\IdeaProjects\\Parking\\Wersja3\\Glowny\\message.xml";

    private ArrayList<User> lista;
    private ArrayList<Message> msg;

    @PostConstruct
    public void setup(){
        lista = new ArrayList<User>();
        msg = new ArrayList<Message>();
        lista = generate();
        msg = new ArrayList<>();
        save(msg);
        for (User user:lista){
            if(user.getLogged().equals("true"))  user.setLogged("false");
        }
        PojoStart(lista);

    }

    public ArrayList<User> getLista() {
        return lista;
    }

    public void setLista(ArrayList<User> lista) {
        this.lista = lista;
    }

    public ArrayList<Message> getMsg() {
        return msg;
    }

    public void setMsg(ArrayList<Message> msg) {
        this.msg = msg;
    }

    public User findUser(String name){
        for (User u:lista) {
            if(u.getName().equals(name)) return u;
        }
        return null;
    }

    public void addSave(Message message){
        msg.add(message);
        save(msg);
    }

    public ArrayList<User> generate(){
        JAXBContext context = null;
        Marshaller marshaller = null;
        Unmarshaller unmarshaller = null;
        Users messages = null;

        try {
            context = JAXBContext.newInstance(Users.class);
            unmarshaller = context.createUnmarshaller();
            messages = (Users) unmarshaller.unmarshal(new File(path2));

        } catch (JAXBException e) {
            System.out.println("Blad");
        }

        return messages.getList();
    }

    public ArrayList<Message> generate2(){
        JAXBContext context = null;
        Marshaller marshaller = null;
        Unmarshaller unmarshaller = null;
        Messages messages = null;

        try {
            context = JAXBContext.newInstance(Messages.class);
            unmarshaller = context.createUnmarshaller();
            messages = (Messages) unmarshaller.unmarshal(new File(path));

        } catch (JAXBException e) {
            System.out.println("Blad");
        }

        return messages.getMsg();
    }

    public void PojoStart(ArrayList<User> messageList){
        JAXBContext context = null;
        Marshaller marshaller = null;
        Unmarshaller unmarshaller = null;
        try {

            context = JAXBContext.newInstance(Users.class);
            unmarshaller = context.createUnmarshaller();
            Users users = (Users) unmarshaller.unmarshal(new File(path2));
            users.setList(messageList);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(users, new File(path2));

        } catch (JAXBException e) {
            System.out.println(e);
        }
    }

    public void save(ArrayList<Message> list){
        JAXBContext context = null;
        Marshaller marshaller = null;
        Unmarshaller unmarshaller = null;
        try {

            context = JAXBContext.newInstance(Messages.class);
            unmarshaller = context.createUnmarshaller();
            Messages users = (Messages) unmarshaller.unmarshal(new File(path));
            users.setMsg(list);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(users, new File(path));

        } catch (JAXBException e) {
            System.out.println(e);
        }
    }
}
