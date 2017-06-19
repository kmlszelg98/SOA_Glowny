import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.HashMap;

@Stateless
public class MessageSender {


    @Resource(mappedName = "java:/ConnectionFactory")
    private TopicConnectionFactory cf;


    public void sendMessage(String message,String typ) {

        MessageProducer messageProducer;
        TextMessage textMessage;
        try {
            TopicConnection connection = cf.createTopicConnection();
            connection.start();
            InitialContext context = new InitialContext();
            Topic topic = (Topic) context.lookup("java:/jms/topics/Topic");
            TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            TopicPublisher publisher = session.createPublisher(null);
            textMessage = session.createTextMessage();

            textMessage.setText(message);
            textMessage.setStringProperty("typ",typ);
            publisher.send(topic,textMessage);

            publisher.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
    } catch (NamingException e) {
        e.printStackTrace();
    }
    }


}