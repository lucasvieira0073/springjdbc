<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8"/>
<title>Home</title>
</head>
<body>

	<h1>Cadastro de produto</h1>
	
	<form:form action="${pageContext.request.contextPath}/" method="POST" commandName="produto">
		<input type="hidden" name="id" value="${produto.id }"/><br/>
		<label>Nome: </label><input type="text" name="nome" value="${produto.nome }"/><br/>
		<label>Descrição</label><textarea name="descricao" rows="4" >${produto.descricao}</textarea><br/>
		<input type="submit" value="Cadastrar"/>
	
	</form:form>
	<br/>
	<hr/>
	<br/>
	
	
	
	
	
	<table>
		<thead>
			<tr>
				<th>Editar</th>
				<th>Remover</th>
				<th>Id</th>
				<th>Nome</th>
				<th>Descrição</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${produtos }" var="produto">
				<tr>
					<td><a href="${pageContext.request.contextPath}/editar/${produto.id}">E</a></td>
					<td><a href="${pageContext.request.contextPath}/remover/${produto.id}">X</a></td>
					<td>${produto.id }</td>
					<td>${produto.nome }</td>
					<td>${produto.descricao }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>