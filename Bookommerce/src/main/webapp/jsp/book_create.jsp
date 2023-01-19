<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/static.css">
    <title>Ajout d'un livre à la base de donnée</title>
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
    <h2>Ajout d'un livre à la base de donnée</h2>

    <form method="post" enctype="multipart/form-data" action="create">
      <ul>
        <li>
          <label for="book-title">Titre</label>
          <input type="text" name="book-title" id="book-title">
        </li>
        <li>
          <label for="book-author">Auteur</label>
          <input type="text" name="book-author" id="book-author">
        </li>
        <li>
          <label for="book-synopsys">Synopsys</label>
          <input type="text" name="book-synopsys" id="book-synopsys">
        </li>
        <li>
          <label for="book-price">Prix</label>
          <input type="number" name="book-price" id="book-price" step="10">
        </li>
        <li>
          <label for="book-rating">Note</label>
          <input type="number" name="book-rating" id="book-rating" step="10">
        </li>
        <li>
          <label for="book-genre">Genre</label>
          <select name="book-genre" id="book-genre">
            <option>Sci-Fi</option>
            <option>Roman</option>
            <option>Histoire</option>
            <option>Psychologie</option>
          </select>
        </li>
        <li>
          <label for="book-cover">Image de couverture</label>
          <input type="file" id="book-cover" name="book-cover" multiple>
        </li>
        <li>
          <label for="book-editor">Éditeur</label>
          <input type="text" name="book-editor" id="book-editor">
        </li>
      </ul>
      <input type="submit" value="Valider les modifications">
  
    </form>
    <footer>
      <p>All rights reserved</p>
    </footer>
  </body>

</html>