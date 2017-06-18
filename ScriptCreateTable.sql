CREATE TABLE USUARIO
(
	nome_usuario varchar2(50) not null,
	login varchar2(50) not null,
	senha varchar2(50) not null,
	id_usuario varchar2(20) not null,

	CONSTRAINT id_usuario_pk PRIMARY KEY (id_usuario)
);

CREATE TABLE GRUPO
(
	nome_grupo varchar2(50) not null,
	id_grupo varchar2(20) not null,
	id_admin varchar2(20) not null,
	num_pessoas integer DEFAULT 1 not null,

	CHECK (num_pessoas > 0),

	CONSTRAINT id_grupo_pk PRIMARY KEY (id_grupo),
	CONSTRAINT id_admin_fk FOREIGN KEY (id_admin) REFERENCES USUARIO (id_usuario)
);

CREATE TABLE DESPESA
(
	id_despesa varchar2(100) not null,
	razao varchar2(100) not null,
	valor float(2) not null,
	data_hora date DEFAULT SYSDATE,
	id_grupo varchar2(20) not null,
	id_usuario varchar2(20) not null,

	CONSTRAINT id_despesa_pk PRIMARY KEY (id_despesa),
	CONSTRAINT id_usuario_fk FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario),
	CONSTRAINT id_grupo_fk FOREIGN KEY (id_grupo) REFERENCES GRUPO (id_grupo)
);

CREATE TABLE USUARIO_GRUPO
(
	id_relacao varchar2(30) not null,
	id_usuario varchar2(20) not null,
	id_grupo varchar2(20) not null,

	CONSTRAINT id_relacao_pk PRIMARY KEY (id_relacao),
	CONSTRAINT id_usuario_relacao_fk FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario),
	CONSTRAINT id_grupo_relacao_fk FOREIGN KEY (id_grupo) REFERENCES GRUPO (id_grupo)
);