# Loja Livros Spring MVC

O objetivo do projeto é ser uma base de conhecimento de Spring MVC. Como plano de fundo, temos o desenvolvimento
de um sistema de e-commerce de uma loja de livros.

**JboosForge**<br>
Para gerar a estrutura do projeto:
   1. Copiar o _**.zip**_ do **JBossForge** para dentro do projeto;
   2. Executar os seguintes comandos <br>
   `[pasta do  JBoosForge]/bin/forge`
   3. `project-new --named [nome do projeto]` **OU** `new-project --named [nome do projeto]`
   
**Iniciando com Heroku**\
    1. Instalar Heroku toolbelt `sudo snap install heroku --classic`\
    2. Fazendo autenticação: `heroku login`\
    3. Criando projeto: `heroku create [nome aplicação]`

**Fazendo deploy no Heroku**\
    1. `git push heroku master`\
    2. Ver erros `heroku logs --tail`\
    3. `heroku open` abrir projeto no browser