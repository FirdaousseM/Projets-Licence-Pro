<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="web.book.Book" %>
<% 
  Book book = (Book)request.getAttribute("book");
%>
<!DOCTYPE html>
<html lang="fr">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/static.css">    
    <title>Modification - <%= book.getTitle() %></title>
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
    <h2>Modification d'un livre sur la base de donnée</h2>

    <form method="post" enctype="multipart/form-data" action="update">
      <ul>
        <li>
          <label for="book-title">Titre</label>
          <input type="text" name="book-title" id="book-title" value=<%=book.getTitle() %>>
        </li>
        <li>
          <label for="book-author">Auteur</label>
          <input type="text" name="book-author" id="book-author" value=<%=book.getAuthor() %>>
        </li>
        <li>
          <label for="book-synopsys">Synopsys</label>
          <input type="text" name="book-synopsys" id="book-synopsys" value=<%=book.getSynopsys() %>>
        </li>
        <li>
          <label for="book-cover">Image de couverture</label>
		  <img src="data:image/jpeg;base64, <%= book.getCover() %>" alt="book Cover">
          <input type="file" id="book-cover" name="book-cover" multiple>
        </li>
        <li>
          <label for="book-price">Prix</label>
          <input type="number" name="book-price" id="book-price" step="10" value=<%=book.getPrice() %>>
        </li>
        <li>
          <label for="book-rating">Note</label>
          <input type="number" name="book-rating" id="book-rating" step="10" value=<%=book.getRating() %>>
        </li>
        <li>
          <label for="book-genre">Genre</label>
          <select name="book-genre" id="book-genre" value=<%=book.getGenre() %>>
            <option>Sci-Fi</option>
            <option>Roman</option>
            <option>Histoire</option>
            <option>Psychologie</option>
          </select>
        </li>
        <li>
          <label for="book-editor">Éditeur</label>
          <input type="text" name="book-editor" id="book-editor" value=<%=book.getEditor() %>>
        </li>
      </ul>
      <input type="submit" value="Valider les modifications">
    </form>
  
    <a href="delete">Supprimer le livre</a>
  
    <footer>
      <p>All rights reserved</p>
    </footer>
  </body>

</html>