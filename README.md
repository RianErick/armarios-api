
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

<pre><code>git clone https://github.com/RianErick/armarios-api</code></pre>
<ol start="2">
    <li>Abra o projeto em sua IDE de preferência (recomendamos o uso do IntelliJ IDEA).</li>
    <li>Configure o arquivo application.properties com as informações de seu banco de dados MySQL:</li>
</ol>
<pre><code>spring.datasource.url=jdbc:mysql://localhost:3306/{nome_do_banco}?useSSL=false&amp;serverTimezone=UTC
spring.datasource.username={seu_usuario}
spring.datasource.password={sua_senha}
</code></pre>
<ol start="5">
    <li>Execute o projeto utilizando o comando:</li>
</ol>
<pre><code>mvn spring-boot:run</code></pre>
<p>A API estará disponível na porta 8080 em seu navegador:</p>
<pre><code>http://localhost:8080</code></pre>
<h2>Endpoints</h2>
<p>A API possui os seguintes endpoints:</p>
<ul>
    <li><code>GET /alunos</code>: Retorna uma lista com todos os alunos cadastrados.</li>
    <li><code>GET /alunos/{id}</code>: Retorna o aluno correspondente ao ID informado.</li>
    <li><code>POST /alunos</code>: Cria um novo aluno.</li>
    <li><code>PUT /alunos/{id}</code>: Atualiza as informações de um aluno já cadastrado.</li>
    <li><code>DELETE /alunos/{id}</code>: Deleta o aluno correspondente ao ID informado.</li>
    <li><code>GET /armarios</code>: Retorna uma lista com todos os armários cadastrados.</li>
    <li><code>GET /armarios/{id}</code>: Retorna o armário correspondente ao ID informado.</li>
    <li><code>POST /armarios</code>: Cria um novo armário.</li>
    <li><code>PUT /armarios/{id}</code>: Atualiza as informações de um armário já cadastrado.</li>
    <li><code>DELETE /armarios/{id}</code>: Deleta o armário correspondente ao ID informado.</li>
    <li><code>GET /alunos/{id}/armarios</code>: Retorna a lista de armários do aluno correspondente ao ID informado.</li>
    <li><code>GET /armarios/{id}/alunos</code>: Retorna a lista de alunos que possuem o armário correspondente ao ID informado.</li>
    <li><code>POST /alunos/{id}/solicitar-armario?armarioId={id_do_armario}</code>: Cria uma solicitação de armário para o aluno correspondente ao ID informado, utilizando o armário informado pelo ID na query string.</li>
</ul>
<p>Todos os endpoints retornam as respostas em formato JSON.</p>




