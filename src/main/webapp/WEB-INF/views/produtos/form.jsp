
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<html>
<head>
    <title>Formulário de cadastro de livro</title>
</head>
<body>
    <%--<form style="width: 50%" action="/casadocodigo/produtos" method="post">--%>
    <%--ALTERNATIVE modelAttribute="produto"--%>
    <form:form action="${s:mvcUrl('PC#gravar').build()}" method="post" commandName="produto">
        <div style="height: 50px; margin: 10px;">
            <label>Nome</label>
            <input type="text" name="nome">
            <form:errors path="nome"/>
        </div>
        <div style="height: 50px; margin: 10px;">
            <label>Descrição</label>
            <textarea name="descricao"></textarea>
            <form:errors path="descricao"/>
        </div>
        <div style="height: 50px; margin: 10px;">
            <label>Nº Páginas</label>
            <input type="text" name="paginas">
            <form:errors path="paginas"/>
        </div>
        <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
            <div style="height: 50px; margin: 10px;">
                <label>${tipoPreco}</label>
                <input type="text" name="precos[${status.index}].valor">
                <input type="hidden" name="precos[${status.index}].tipoPreco" value="${tipoPreco}">
            </div>
        </c:forEach>
        <button style="width: 100%" type="submit">Cadastrar</button>
    <%--</form>--%>
    </form:form>
</body>
</html>
