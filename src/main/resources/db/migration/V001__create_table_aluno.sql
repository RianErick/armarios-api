create table aluno_bolsista(

id bigint not null auto_increment,
nome varchar (100) not null,
email varchar (100) not null,
cpf varchar (11) not null,
matricula varchar (15) not null,
periodo varchar (50) not null,
curso varchar (100) not null,
primary key (id)

);

create table armario(
id bigint not null auto_increment,
aluno_id bigint references aluno_bolsista (id),
cor varchar (40) not null,
numero_chave varchar (8) not null,
localizacao varchar (100) not null,
status varchar (10) not null,
primary key (id)

);

create table solicitacao_armario(
id bigint not null auto_increment,
aluno_id bigint references aluno_bolsista(id),
armario_id bigint references armario (id),
data_sl_armario datetime not null,
status_sl varchar (10) not null,
primary key (id)

);