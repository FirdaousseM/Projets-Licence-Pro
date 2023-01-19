<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bookommerce - Accueil</title>
    <link rel="stylesheet" href="css/static.css">
    <link rel="stylesheet" href="css/home.css">
    
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
      <section>
        <article class="article">
          <p class="article__headline">Retour sur la saga culte Harry Potter !</p>
          <img class="article__img" src="assets/HarryPotterBook.jpg" alt="cover harry potter">
        </article>
      </section>
      <section>
        <ul class="sub-menu">
          <li><a href="books/seeAll">Romans</a></li>
          <li><a href="books/seeAll">Sci-fi</a></li>
          <li><a href="books/seeAll">Psychologie</a></li>
          <li><a href="books/seeAll">Histoire</a></li>
        </ul>
      </section>
      
    </main>
    <footer>
      <p>All rights reserved</p>
    </footer>
  </body>

</html>