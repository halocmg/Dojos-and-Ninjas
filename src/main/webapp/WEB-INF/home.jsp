<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dojos and Ninjas</title>
	<style>
		*{
			margin: 0px;
			padding: 0px;
			font: inherit;
		}
		.all{
			margin: auto;
			text-align: center;	
			font: 100 20pt "Helvetica Neue", sans-serif;
		}
		h1{
			font: 100 60pt "Helvetica Neue", sans-serif;
		}
		a{
			font: 100 15pt "Helvetica Neue", sans-serif;
			text-decoration: none;
		}
		.everyone{
			margin: auto;
			text-align: center;	
			margin-top: 20px;
		}
		h3{
			font: 100 17pt "Helvetica Neue", sans-serif;
		}
		h4{
			font: 100 15pt "Helvetica Neue", sans-serif;
		}
		.dojo{
			margin: auto;
			text-align: center;
			padding: 10px;
			width: 200px;
			text-align: left;
			
		}
	</style>
  </head>
  <body>
  	<div class="all">
  		<h1>Welcome to Dojos and Ninjas!</h1>
  		<a href="/dojos/new">Create Dojo</a> || <a href="/ninjas/new">Create Ninjas</a>
  		<div class="everyone">
  			<h3>All Dojos</h3>
  			<c:forEach items="${dojos}" var="dojo">
  				<div class="dojo">
  					<a href="/dojos/show/${dojo.id}"><h4> <c:out value="${dojo.name}"/></h4></a>
  				</div>
			</c:forEach>
  		</div>
  	</div>
  </body>
</html>