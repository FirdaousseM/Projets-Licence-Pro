<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="web.user.User" %>
<% 
  User user = (User)request.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="fr">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../css/static.css">
    
    <title>Mon compte - <%= user.getUsername() %></title>
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
    <h2>Mon compte - <%= user.getUsername() %></h2>
    
    <label>Nom d'utilisateur : <%= user.getUsername() %></label>
    <label>Email : <%= user.getEmail() %></label>
    <label>Mot de passe : <%= user.getPassword() %></label>

    <section>
      <h2>Adresse de Facturation</h2>
      <label>Prénom : <%= user.getFirstname() %></label>
      <label>Nom : <%= user.getLastname() %></label>
      <label>Numéro de téléphone : <%= user.getPhone() %></label>
      <label>Adresse : <%= user.getAddress() %></label>

    </section>
    <footer>
      <p>All rights reserved</p>
    </footer>
    
  </body>

</html>