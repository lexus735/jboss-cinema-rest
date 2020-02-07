<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cinema</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 <fmt:setLocale value = "fr_FR"/>
 <div class="container">
<h2>Caddie- Nb d'articles : ${caddy.nombreArticles } - Prix Total: <fmt:formatNumber value = " ${caddy.prixTotalHT }" type = "currency"/></h2>

     <a href="ShowPanier" class="btn btn-success btn-lg">
          <span class="glyphicon glyphicon-shopping-cart"></span> Panier 
        </a>


<table class="table">
	<thead><tr class="success"><th>Titre</th><th>Prix HT</th></tr></thead>
	<c:forEach items="${films }" var="film">
		<tr><td>${film.titre }</td><td><fmt:formatNumber value = "${film.prixHT}" type = "currency"/></td>
			<td><a href="AddFilmServlet?id=${film.id }">Acheter</a></td>
			
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>



		