<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="../css/static.css">
    
    <title>Inscription sur Bookommerce</title>
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
    <h2>Inscription</h2>

    <form method="post" action="create">
      <ul>
        <li>
          <label for="user-username">Nom d'utilisateur</label>
          <input type="text" name="user-username" id="user-username">
        </li>
        <li>
          <label for="user-email">Email</label>
          <input type="email" name="user-email" id="user-email">
        </li>
        <li>
          <label for="user-password">Mot de passe</label>
          <input type="password" name="user-password" id="user-password">
        </li>
      </ul>
      <input type="submit" value="S'inscrire">
    </form>
    <footer>
      <p>All rights reserved</p>
    </footer>
  </body>

</html>
