<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.*" %>
<%@ page import="web.book.Book" %>
<% 
  ArrayList<Book> booksList = (ArrayList<Book>)request.getAttribute("booksList");
  ArrayList<Book> panier = (ArrayList<Book>)request.getAttribute("panier");
%>
<!DOCTYPE html>
<html lang="fr">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/static.css">
    <link rel="stylesheet" href="../css/category.css">
 	   
    <title>Tous les livres</title>
  </head>

  <body>
    <header>
      <a href="/Bookommerce"><h1>Bookommerce</h1></a>
      <ul>
        <li><a href="#">Tous les Livres</a></li>
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
      <h2>Liste de nos livres</h2>
      <% for (Book book : booksList) { %>
     <section class="item-list">
        <div class="item-card">
          <a class="item-link" href="<%= book.getId() %>/see">
            <img class="item-card__image" src="../assets/<%= book.getCover() %>" alt="Couverture du livre">
            <label class="item-card__title"><%= book.getTitle() %></label>
            <label class="item-card__genre"><%= book.getGenre() %></label>
            <label class="item-card__price"><%= book.getPrice() %> €</label>
          </a>
        </div>
     </section> 
      <% } %>
    </main>
    <footer>
      <p>All rights reserved</p>
    </footer>
  </body>

</html>