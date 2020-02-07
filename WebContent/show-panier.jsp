<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contenu du panier</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>


	<div class="container">
	<h2>Contenu du panier</h2>
		<table class="table">
		<thead><tr class="success"><th>Titre</th><th>Prix HT</th></tr></thead>
	<c:forEach items="${caddy.films }" var="film">
		<tr><td>${film.titre }</td><td><fmt:formatNumber value = "${film.prixHT}" type = "currency"/></td>
		
			<td><a class="btn" href="ChangeCaddy?cd=plus&id=${film.id }" role="button">+</a></td>
			<td>${caddy.quantity(film) }</td>
			<td><a class="btn"href="ChangeCaddy?cd=min&id=${film.id }" role="button">-</a></td>
			<td><a href="DeleteFilm?id=${film.id }">Supprimer</a></td>
		</tr>
	</c:forEach>
		</table>	
</div>

		
		
</body>
</html>