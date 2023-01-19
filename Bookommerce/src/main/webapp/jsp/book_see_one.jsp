<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="web.book.Book" %>
<%@ page import="java.util.ArrayList" %>

<% 
  Book book = (Book)request.getAttribute("book");
  ArrayList<Book> panier = (ArrayList<Book>)request.getAttribute("panier");

%>
<!DOCTYPE html>
<html lang="fr">

  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../../css/static.css">
    
		<title><%= book.getTitle() %></title>
	</head>


	<body>
    <header>
      <a href="/Bookommerce"><h1>Bookommerce</h1></a>
      <ul>
        <li><a href="/Bookommerce/books/seeAll">Tous les Livres</a></li>
        <li><a href="#">A propos</a></li>
        <li class="cart">
          Mon Panier
          <ul class="cart-list">
            <% if (panier.size() > 0) 
            for(Book oneBook : panier){ %>
            <li class="cart-item">
              <img class="" src="../../assets/<%= book.getCover() %>" alt="Couverture du livre">
              <label class=""><%= book.getTitle() %></label>
              <label class=""><%= book.getPrice() %> €</label>
            </li>  
            <%} %>
          </ul>
        </li>
      </ul>
    </header>
		<h2><%= book.getTitle() %></h2>
		<article>
			<img src="../../assets/<%= book.getCover() %>" alt="book Cover">
			<label>Genre : <%= book.getGenre() %></label>
			<p>Synopsys : <%= book.getSynopsys() %></p>
			<label>Prix : <%= book.getPrice() %> €</label>
			<label>Auteur : <%= book.getAuthor() %></label>
			<label>Note : <%= book.getRating() %></label>
			<label>Éditeur : <%= book.getEditor() %></label>
			
		</article>

    <form action="#" enctype='multipart/form-data' method="post">
      <button type="submit" name="button" value="ajouterAuPanier">Ajouter au panier</button>
    </form> 

		<a href="edit">Modifier ce livre (admin)</a>
		
    <footer>
      <p>All rights reserved</p>
    </footer>
	</body>

</html>