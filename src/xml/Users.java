package xml;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Kamil on 06.05.2017.
 */

@XmlRootElement
public class Users {

    public Users() {
    }

    private ArrayList<User> list;

    public Users(ArrayList<User> list) {
        this.list = list;
    }

    public ArrayList<User> getList() {
        return list;
    }

    public void setList(ArrayList<User> list) {
        this.list = list;
    }
}
