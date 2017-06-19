package xml;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Kamil on 28.05.2017.
 */

@XmlRootElement
public class Messages {

    private ArrayList<Message> msg;

    public Messages(ArrayList<Message> msg) {
        this.msg = msg;
    }

    public Messages() {
    }

    public ArrayList<Message> getMsg() {
        return msg;
    }

    public void setMsg(ArrayList<Message> msg) {
        this.msg = msg;
    }
}
