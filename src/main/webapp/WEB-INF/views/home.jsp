<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<html>
<head>
    <title>Livraria</title>
</head>
<body>
Seja bem vindo
<br>
<a href="${s:mvcUrl('PC#listar').build()}">Lista de produtos</a>
</body>
</html>
