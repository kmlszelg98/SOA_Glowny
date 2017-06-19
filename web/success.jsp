<%--
  Created by IntelliJ IDEA.
  User: Kamil
  Date: 06.05.2017
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //allow access only if session exists

    if(session.getAttribute("user") == null){
        response.sendRedirect("index.jsp");
    }
    String userName = null;

    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("user")) userName = cookie.getValue();

        }
    }
%>

<h2>Stan Biletow</h2>

<a href="/Glowny/ticket"  role="button">BILETY</a>
<br/>

<h2>Stan miejsc</h2>
<a href="/Glowny/places"  role="button">MIEJSCA</a>
<br/>

<h2>Zmien haslo</h2>
<a href="/Glowny/pass"  role="button">ZMIANA</a>
<br/>

<h2>Powiadomienia</h2>
<a href="/Glowny/powiadomienia"  role="button">POWIADOMIENIA</a>

<br/>


<br/>
<h2>Wyloguj sie z systemu</h2>
<a href="/Glowny/wyloguj"  role="button">WYLOGUJ</a>

<h2>Raport</h2>
<form action="/Glowny/raport" method="post">
    Ile dni: <input type="number" name="ile"/>
    <input type="submit" value="Raport">
</form>


</body>
</html>
