package xml;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Kamil on 06.05.2017.
 */

@XmlRootElement
public class User {

    private String name;
    private String password;
    private String role;
    private String logged;
    private int strefa;

    public User() {
    }

    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getLogged() {
        return logged;
    }

    public void setLogged(String logged) {
        this.logged = logged;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStrefa() {
        return strefa;
    }

    public void setStrefa(int strefa) {
        this.strefa = strefa;
    }
}
