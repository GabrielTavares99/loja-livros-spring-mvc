<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<head>
    <title>Formulário de cadastro de livro</title>
</head>
<body>
<h1>Lista de produtos:</h1>

<h2 style="background-color: #24cd2d">${mensagem_sucesso}</h2>
<h2 style="background-color: #ff0000">${mensagem_falha}</h2>

<table style="border: black solid 1px; width: 100%">
    <thead>
    <tr>
        <td>Título</td>
        <td>Descrição</td>
        <td>Data lançamento</td>
        <td>Páginas</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${produtos}" var="produto" varStatus="status">
        <tr>
            <td><a href="${s:mvcUrl('PC#detalhe').arg(0, produto.id).build()}"> ${produto.nome}</a></td>
            <td>${produto.descricao}</td>
            <td><fmt:formatDate value="${produto.dataLancamento.time}" pattern="dd/MM/yyyy"/></td>
            <td>${produto.paginas}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
