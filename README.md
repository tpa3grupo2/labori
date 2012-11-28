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
4. Hibernate 3.5 (vem com o NetBeans)
5. OmniFaces 1.1

Como rodar o projeto
--------------------

1. Clone o projeto a partir de seu repositório
2. Abra o repositório local no NetBeans 7.1.2 (não foi testado em outras versões)
3. Abra individualmente todos os projetos (`labori-ejb`, `labori-war`, `labori-empresa` e `labori-desktop`) para que o NetBeans atualize os XMLs de compilação de cada projeto
4. Inicie o Derby a partir da aba `Services` no NetBeans
5. Ainda no `Derby`, crie o banco `labori` e o usuário `admin` com senha `admin`
6. Execute o projeto `LaboriEnterprise` no NetBeans (ele iniciará o GlassFish e fará o Deploy automaticamente)
7. Acesse a página inicial no [http://localhost:8080/labori-war/](http://localhost:8080/labori-war/)

Organização dos projetos
------------------------

Os projetos estão organizados da seguinte maneira:

* `LaboriEnterprise`
  Container dos projetos, deve ser usado para o deploy.
* `LaboriEnterprise/labori-ejb`
  Projeto que contém os modelos e os EJBs utilizados pelos clientes.
 * Para rodar: Faça o deploy do `LaboriEnterprise`.
* `LaboriEnterprise/labori-war`
  Projeto web com a interface para os usuários que estão procurando emprego.
 * Para rodar: Faça o deploy do `LaboriEnterprise` e acesse `http://localhost:8080/labori-war`
* `LaboriEnterprise/labori-empresa`
  Cliente desktop para que a empresa gerencie suas vagas, candidatos e referências profissionais.
 * Para rodar: Execute o projeto `LaboriEnterprise/labori-empresa`
* `labori-desktop`
  Cliente administrativo do sistema, onde são gerenciados elementos como campos de atuação e universidades.
 * Para rodar: Execute o projeto `labori-desktop`

Credenciais de acesso
---------------------

Quando as tabelas do sistema são criadas, o banco é populado com alguns dados de acesso. Esses dados podem ser usados para efetuar o login nas aplicações.

Para acessar os sistemas, siga as instruções abaixo:

* `LaboriEnterprise/labori-war`
  * Para acessar o sistema, uma conta pode ser criada diretamente do site ou uma das credencias abaixo pode ser usada:
     * Usuário `cauelt@gmai.com`, senha `1`
     * Usuário `ronyclayaa@gmail.com`, senha `rony99`
     * Usuário `rodrigogomes@gmail.com`, senha `jag987`
     * Usuário `ica_selima@hotmail.com`, senha `mooo112233`
     * Usuário `julio@globo.com`, senha `r0ma`
* `LaboriEnterprise/labori-empresa`
  * Para acessar esse sistema, uma nova empresa deve ser criada pelo `labori-desktop` e seus dados devem ser utilizados no login, ou então uma das credenciais abaixo pode ser usada:
     * CNPJ: `52.422.498/0001-84`, senha `car123`
     * CNPJ: `23.837.043/0001-21`, senha `petr$`
     * CNPJ: `33.468.532/0001-07`, senha `tel666`
* `labori-desktop`
  * Esse sistema não necessita de login, pois ficará instalado diretamente na máquina dos administradores do site.

Os objetos que são inseridos automaticamente no deploy podem ser consultados no arquivo `LaboriEnterprise/labori-ejb/src/java/import.sql`.

Projetos utilizados
-------------------
* [Twitter Bootstrap 2.1.1](http://twitter.github.com/bootstrap/)
* [JQuery 1.8.2](http://jquery.com/)
* [bootstrap-wysihtml5 0.0.2](https://github.com/jhollingworth/bootstrap-wysihtml5/)
* [Font Awesome 2.0](http://fortawesome.github.com/Font-Awesome/)
