<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
    
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8"/>
<title>Home</title>
</head>
<body>

	<h1>Lista de produtos</h1>
	
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Descrição</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${produtos }" var="produto">
				<tr>
					<td>${produto.id }</td>
					<td>${produto.nome }</td>
					<td>${produto.descricao }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>