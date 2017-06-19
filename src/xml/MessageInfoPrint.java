package xml;

import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Created by Kamil on 30.05.2017.
 */

@ManagedBean(name = "userData")
@SessionScoped
@Stateless
public class MessageInfoPrint{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWelcomeMessage() {
        return "Hello " + name;
    }

}
