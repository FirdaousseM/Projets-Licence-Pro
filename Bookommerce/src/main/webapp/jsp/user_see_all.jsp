<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="web.user.User" %>
<% 
  ArrayList<User> usersList = (ArrayList<User>)request.getAttribute("booksList");
%>
<!DOCTYPE html>
<html lang="fr">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/static.css">
    
    <title>Tous les utilisateurs</title>
  </head>

  <body>
    <header>
      <a href="/Bookommerce"><h1>Bookommerce</h1></a>
      <ul>
        <li><a href="/Bookommerce/books/seeAll">Tous les Livres</a></li>
        <li><a href="#">A propos</a></li>
        <li>
          Mon Panier
          <div class="cart-list">
            <% //for cart-item %>
          </div>
        </li>
      </ul>
    </header>
    <main>
      <h2>Liste de nos utilisateurs</h2>
      <% for (User user : usersList) { %>
        <section>
          <a href="<%= user.getId() %>/dashboard">
            <h2><%= user.getUsername() %></h2>
            <label><%= user.getEmail() %></label>
            <label><%= user.getPassword() %></label>
          </a>
        </section> 
      <% } %>
    </main>
    <footer>
      <p>All rights reserved</p>
    </footer>
  </body>

</html>