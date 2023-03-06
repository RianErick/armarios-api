
<p>Este projeto é um sistema de gerenciamento de armários escolares, com operações CRUD para as entidades "aluno" e "armário", além de funcionalidades adicionais como criação de listas de alunos e armários, criação de solicitações de armários para alunos específicos, e conexão com banco de dados utilizando a arquitetura REST API.</p>

<h2>Requisitos</h2>

<p>Para executar o projeto, você precisará ter as seguintes ferramentas instaladas em sua máquina:</p>

<ul>
    <li>Java 8 ou superior</li>
    <li>Maven</li>
    <li>MySQL</li>
</ul>

<h2>Tecnologias utilizadas</h2>

<ul>
    <li>Spring Boot</li>
    <li>Spring Data JPA</li>
    <li>Flyway</li>
    <li>MySQL</li>
</ul>

<h2>Instalação</h2>

<p>Para clonar e instalar o projeto, siga os passos abaixo:</p>

<ol>
    <li>Clone o repositório para sua máquina:</li>
</ol>

<pre><code>git clone https://github.com/seu-usuario/gerenciamento-armarios-escolares.git</code></pre>

<ol start="2">
    <li>Importe o projeto em sua IDE de preferência.</li>
    <li>Configure as variáveis de ambiente necessárias no arquivo <code>application.properties</code>, como mostrado abaixo:</li>
</ol>

<pre><code>spring.datasource.url=jdbc:mysql://localhost:3306/nome-do-banco-de-dados
<ol start="4">
    <li>Execute as migrações de banco de dados com o Flyway:</li>
</ol>

<pre><code>mvn flyway:migrate</code></pre>

<ol start="5">
    <li>Execute a aplicação:</li>
</ol>

<pre><code>mvn spring-boot:run</code></pre>

<ol start="6">
    <li>O servidor estará rodando em <a href="http://localhost:8080">http://localhost:8080</a></li>
</ol>

<h2>Uso</h2>

<p>A seguir, estão as operações disponíveis para as entidades "aluno" e "armário".</p>

<h3>Aluno</h3>

<ul>
    <li><code>GET /alunos</code>: retorna a lista de todos os alunos cadastrados.</li>
    <li><code>GET /alunos/{id}</code>: retorna os detalhes do aluno com o ID especificado.</li>
    <li><code>POST /alunos</code>: cria um novo aluno


