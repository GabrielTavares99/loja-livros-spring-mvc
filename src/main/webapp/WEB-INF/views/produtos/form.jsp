
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
    <form:form action="${s:mvcUrl('PC#gravar').build()}" method="post" enctype="multipart/form-data" commandName="produto">
        <div style="height: 50px; margin: 10px;">
            <label>Nome</label>
            <form:input path="nome"/>
            <form:errors path="nome"/>
        </div>
        <div style="height: 50px; margin: 10px;">
            <label>Descrição</label>
            <form:textarea path="descricao"/>
            <form:errors path="descricao"/>
        </div>
        <div style="height: 50px; margin: 10px;">
            <label>Nº Páginas</label>
            <form:input path="paginas"/>
            <form:errors path="paginas"/>
        </div>
        <div style="height: 50px; margin: 10px;">
            <label>Data lançamento</label>
            <form:input path="dataLancamento"/>
            <form:errors path="dataLancamento"/>
        </div>
        <c:forEach items="${tipos}" var="tipoPreco" varStatus="status">
            <div style="height: 50px; margin: 10px;">
                <label>${tipoPreco}</label>
                <form:input path="precos[${status.index}].valor"/>
                <form:input type="hidden" path="precos[${status.index}].tipoPreco" value="${tipoPreco}"/>
            </div>
        </c:forEach>
        <div>
            <label>Sumário</label>
            <input type="file" name="sumario"/>
        </div>
        <button style="width: 100%" type="submit">Cadastrar</button>
    <%--</form>--%>
    </form:form>
</body>
</html>
