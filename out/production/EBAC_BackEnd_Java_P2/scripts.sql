create table cliente (
	id bigint,
	cpf bigint not null,
	nome varchar(50) not null,
	telefone varchar(50),
	vip boolean,
	constraint pk_id_cliente primary key(id)
);

ALTER TABLE CLIENTE
ADD CONSTRAINT UK_CPF_CLIENTE UNIQUE (CPF);

create sequence sq_cliente
start 1
increment 1
owned by cliente.id;

<----------------------------------------------------->

create table produto(
	id bigint,
	codigo varchar(10) not null,
	nome varchar(50) not null,
	valor numeric(10,2) not null,
	marca varchar(50),
	constraint pk_id_produto primary key(id)
);

ALTER TABLE PRODUTO
ADD CONSTRAINT UK_CODIGO_PRODUTO UNIQUE (CODIGO);

create sequence sq_produto
start 1
increment 1
owned by produto.id;

<----------------------------------------------------->

create table venda(
	id bigint,
	codigo varchar(10) not null,
	id_cliente_fk bigint not null,
	valor_total numeric(10,2) not null,
	data_venda TIMESTAMPTZ not null,
	status_venda varchar(50) not null,
	constraint pk_id_venda primary key(id),
	constraint fk_id_cliente_venda foreign key(id_cliente_fk) references cliente(id)
);

ALTER TABLE VENDA
ADD CONSTRAINT UK_CODIGO_VENDA UNIQUE (CODIGO);

create sequence sq_venda
start 1
increment 1
owned by venda.id;

<----------------------------------------------------->

create table produto_quantidade(
	id bigint,
	id_produto_fk bigint not null,
	id_venda_fk bigint not null,
	quantidade int not null,
	valor_total numeric(10,2) not null,
	constraint pk_id_prod_venda primary key(id),
	constraint fk_id_prod_venda foreign key(id_produto_fk) references produto(id),
	constraint fk_id_prod_venda_venda foreign key(id_venda_fk) references venda(id)
);

create sequence sq_produto_quantidade
start 1
increment 1
owned by produto_quantidade.id;

<----------------------------------------------------->
