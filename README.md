labori
======

**Sistema modelo de cadastro de vagas e currículos em Java EE**

Desenvolvido para o curso Projeto Interdisciplinar II ministrado pelo professor Calebe de Paula Bianchini na Universidade Presbiteriana Mackenzie.

Este projeto foi desenvolvido para ser executado diretamente pelo NetBeans IDE 7.1.2 e não tem pretensão de ser rodado em produção.

Requisitos
----------

1. NetBeans 7.1.2
2. GlassFIsh Server 3.1.2 (vem com o NetBeans)
3. Apache Derby 10.3.1.4 (vem com o NetBeans)
4. OmniFaces 1.1

Como rodar o projeto
--------------------

1. Clone o projeto a partir de seu repositório
2. Abra o repositório local no NetBeans 7.1.2 (não foi testado em outras versões)
3. Inicie o Derby a partir da aba `Services` no NetBeans
4. Ainda no `Derby`, crie o banco `labori` e o usuário `admin` com senha `admin`
5. Execute o arquivo `main.Main.java` (ele criará e preencherá as tabelas necessárias para a execução do projeto)
6. Baixe o arquivo [http://omnifaces.googlecode.com/files/omnifaces-1.1.jar](http://omnifaces.googlecode.com/files/omnifaces-1.1.jar) e salve-o na pasta `LaboriEnterprise/labori-war/web/WEB-INF/lib` (crie-o se não existir)
7. Execute o projeto no NetBeans (ele iniciará o GlassFish e fará o Deploy automaticamente)
8. Acesse a página inicial no [http://localhost:8080/](http://localhost:8080/)

Projetos utilizados
-------------------
* [Twitter Bootstrap 2.1.1](http://twitter.github.com/bootstrap/)
* [JQuery 1.8.2](http://jquery.com/)
* [bootstrap-wysihtml5 0.0.2](https://github.com/jhollingworth/bootstrap-wysihtml5/)
* [Font Awesome 2.0](http://fortawesome.github.com/Font-Awesome/)
