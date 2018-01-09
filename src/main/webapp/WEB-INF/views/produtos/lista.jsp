
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Formulário de cadastro de livro</title>
</head>
<body>
    <h1>Lista de produtos:</h1>
    <table style="border: black solid 1px; width: 100%">
        <thead>
            <tr>
                <td>Título</td>
                <td>Descrição</td>
                <td>Páginas</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${produtos}" var="produto" varStatus="status">
                <tr>
                    <td>${produto.nome}</td>
                    <td>${produto.descricao}</td>
                    <td>${produto.paginas}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
