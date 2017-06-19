CREATE TABLE USUARIO
(
	nome_usuario varchar2(50) not null,
	login varchar2(50) not null,
	senha varchar2(50) not null,
	id_usuario number(9) not null,

	CONSTRAINT id_usuario_pk PRIMARY KEY (id_usuario)
);

CREATE TABLE GRUPO
(
	nome_grupo varchar2(50) not null,
	id_grupo number(9) not null,
	id_admin number(9) not null,

	CONSTRAINT id_grupo_pk PRIMARY KEY (id_grupo),
	CONSTRAINT id_admin_fk FOREIGN KEY (id_admin) REFERENCES USUARIO (id_usuario)
);

CREATE TABLE DESPESA
(
	id_despesa number(9) not null,
	razao varchar2(100) not null,
	valor DOUBLE PRECISION not null,
	data_hora date DEFAULT SYSDATE,
	id_grupo number(9) not null,
	id_usuario number(9) not null,

	CONSTRAINT id_despesa_pk PRIMARY KEY (id_despesa),
	CONSTRAINT id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario),
	CONSTRAINT id_grupo_fk FOREIGN KEY (id_grupo) REFERENCES GRUPO (id_grupo)
);

CREATE TABLE USUARIO_GRUPO
(
	id_relacao number(9) not null,
	id_usuario number(9) not null,
	id_grupo number(9) not null,

	CONSTRAINT id_relacao_pk PRIMARY KEY (id_relacao),
	CONSTRAINT id_usuario_relacao_fk FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario),
	CONSTRAINT id_grupo_relacao_fk FOREIGN KEY (id_grupo) REFERENCES GRUPO (id_grupo)
);