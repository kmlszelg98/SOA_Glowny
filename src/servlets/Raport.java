/**
 * Created by Kamil on 11.06.2017.
 */
package servlets;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import printers.Terminy;
import xml.Pojo;
import xml.User;

import javax.ejb.EJB;
import javax.servlet.http.HttpSession;


@javax.servlet.annotation.WebServlet(urlPatterns = "/raport")
public class Raport extends javax.servlet.http.HttpServlet {

    @EJB
    Pojo pojo;

    static Client client = Client.create();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        HttpSession session = request.getSession();

        if(session.getAttribute("user") == null){
            response.sendRedirect("index.jsp");
        }
        String role = (String) session.getAttribute("printers");
        String name = (String) session.getAttribute("user");

        User u = pojo.findUser(name);

        int ile = Integer.parseInt(request.getParameter("ile"));


        Terminy terminy = new Terminy(ile,u.getStrefa());

        WebResource webResource = client
                .resource("http://localhost:8080/Raport/api/mobile/post");


        Gson gson = new Gson();
        String string = gson.toJson(terminy);
        System.out.println(string);
        ClientResponse resp = webResource.type("application/json").post(ClientResponse.class, string);
        System.out.println(resp);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

    }
}
