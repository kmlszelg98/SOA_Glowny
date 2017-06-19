package servlets;

import java.io.PrintWriter;

/**
 * Created by Kamil on 12.06.2017.
 */

@javax.servlet.annotation.WebServlet(urlPatterns = "/Error")
public class Error extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        PrintWriter writer = response.getWriter();
        writer.print("Nie mozesz zalogowac sie z tej przegladarki sprobuj na innej");
    }
}
