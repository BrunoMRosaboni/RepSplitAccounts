insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Raul', 'raulll', '123456789', 1);

insert into GRUPO (nome_grupo, id_grupo, id_admin) values ('Never', 1, 1);

insert into DESPESA (id_despesa, razao, valor, id_grupo, id_usuario) values (1, 'agua', 23.0, 1, 1);

insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (1, 1, 1);