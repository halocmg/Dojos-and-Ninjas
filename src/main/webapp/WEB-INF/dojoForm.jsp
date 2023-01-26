<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Dojo: New</title>
	<style>
		*{
			margin: 0px;
			padding: 0px;
			font: inherit;
		}
		
		.form{
			margin-top: 20px;
			margin-left: 200px;
			width: 300px;
			text-align: left;
			font: 100 12pt "Helvetica Neue", sans-serif;
		}
		h4{
			font: 100 20pt "Helvetica Neue", sans-serif;
			margin-bottom: 10px;
		}
		button{
			font: 100 10pt "Helvetica Neue", sans-serif;
			padding: 5px 10px 5px 10px;
			margin-top: 10px;
		}
		.errs{
			margin-top: 20px;
			margin-left: 200px;
			width: 300px;
		}
		legend{
			font: 100 15pt "Helvetica Neue", sans-serif;
			margin-left: 10px;
		}
		.errs p{
			font: 100 10pt "Helvetica Neue", sans-serif;
			margin-left: 10px;
			padding: 10px;
		}
	</style>
  </head>
  <body>
    <div class="form">
    		<form:form method="POST" action="/dojos/new" modelAttribute="dojo">
    			<h4>Create Dojo</h4>
    			<form:label path="name">Dojo Name:</form:label>
		    <form:input type="text" path="name"/><br>
		    
		    <button type=submit>Submit</button> 
    		</form:form>
    		<a href="/">Back</a>
    </div>
    <div class="errs">
    		<% if(request.getAttribute("errs") != null) { %>
	  		<fieldset>
	  			<legend>Errors</legend>
	  			<c:forEach items="${errs}" var="err">
					<p><c:out value="${err.getDefaultMessage()}"/></p>
				</c:forEach>
	  		</fieldset>
	  	<% } %>
    </div>
  </body>
</html>