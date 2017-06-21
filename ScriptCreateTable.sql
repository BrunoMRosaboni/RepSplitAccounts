CREATE TABLE USUARIO
(
	nome_usuario varchar2(50) not null,
	login varchar2(50) not null,
	senha varchar2(50) not null,
	id_usuario integer not null,

	CONSTRAINT id_usuario_pk PRIMARY KEY (id_usuario)
);

CREATE TABLE GRUPO
(
	nome_grupo varchar2(50) not null,
	id_grupo integer not null,
	id_admin integer not null,

	CONSTRAINT id_grupo_pk PRIMARY KEY (id_grupo),
	CONSTRAINT id_admin_fk FOREIGN KEY (id_admin) REFERENCES USUARIO (id_usuario)
);

CREATE TABLE DESPESA
(
	id_despesa integer not null,
	razao varchar2(100) not null,
	valor DOUBLE PRECISION not null,
	data_hora date DEFAULT SYSDATE,
	id_grupo integer not null,

	CONSTRAINT id_despesa_pk PRIMARY KEY (id_despesa),
	CONSTRAINT id_grupo_fk FOREIGN KEY (id_grupo) REFERENCES GRUPO (id_grupo)
);

CREATE TABLE USUARIO_GRUPO
(
	id_relacao integer not null,
	id_usuario integer not null,
	id_grupo integer not null,

	CONSTRAINT id_relacao_pk PRIMARY KEY (id_relacao),
	CONSTRAINT id_usuario_relacao_fk FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario),
	CONSTRAINT id_grupo_relacao_fk FOREIGN KEY (id_grupo) REFERENCES GRUPO (id_grupo)
);

CREATE TABLE PAGANTE_DESPESA
(
	id_relacao integer not null,
	id_usuario integer not null,
	id_despesa integer not null,

	CONSTRAINT id_relacao_pagante_pk PRIMARY KEY (id_relacao),
	CONSTRAINT id_despesa_pagante_fk FOREIGN KEY (id_despesa) REFERENCES DESPESA (id_despesa),
	CONSTRAINT id_usuario_pagante_fk FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario)
);

CREATE TABLE DEVEDOR_DESPESA
(
	id_relacao integer not null,
	id_usuario integer not null,
	id_despesa integer not null,

	CONSTRAINT id_relacao_devedor_pk PRIMARY KEY (id_relacao),
	CONSTRAINT id_usuario_devedor_fk FOREIGN KEY (id_usuario) REFERENCES USUARIO (id_usuario),
	CONSTRAINT id_despesa_devedor_fk FOREIGN KEY (id_despesa) REFERENCES DESPESA (id_despesa)
);