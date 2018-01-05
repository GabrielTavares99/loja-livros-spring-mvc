
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Formulário de cadastro de livro</title>
</head>
<body>
    <form action="/casadocodigo/produtos" method="post">
        <div>
            <label>Nome</label>
            <input type="text" name="nome">
        </div>
        <div>
            <label>Descrição</label>
            <textarea name="descricao"></textarea>
        </div>
        <div>
            <label>Nº Páginas</label>
            <input type="text" name="paginas">
        </div>
        <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
            <div>
                <label>${tipoPreco}</label>
                <input type="text" name="precos[${status.index}].valor">
                <input type="hidden" name="precos[${status.index}].tipoPreco" value="${tipoPreco}">
            </div>
        </c:forEach>
        <button type="submit">Cadastrar</button>
    </form>
</body>
</html>
