package xml;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Kamil on 28.05.2017.
 */

@XmlRootElement
public class Message {

    private String msg;
    private int strefa;

    public Message(String msg,int strefa) {
        this.msg = msg;
        this.strefa = strefa;
    }

    public Message() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStrefa() {
        return strefa;
    }

    public void setStrefa(int strefa) {
        this.strefa = strefa;
    }
}
