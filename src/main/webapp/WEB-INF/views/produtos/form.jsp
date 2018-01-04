
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <button type="submit">Cadastrar</button>
    </form>
</body>
</html>
