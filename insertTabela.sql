/*DROP TABLE PAGANTE_DESPESA;
DROP TABLE DEVEDOR_DESPESA;
DROP TABLE USUARIO_GRUPO;
DROP TABLE DESPESA;
DROP TABLE GRUPO;
DROP TABLE USUARIO;*/


/*insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Raul', 'raulll', '123456789', 1);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('R', 'R', 'R', 2);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Bruno', 'bru', '9', 3);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Allan', 'Allan', 'allan', 4);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Joao', 'joao', 'joao', 5);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Maria', 'maria', 'maria', 6);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Derpina', 'derpina', 'derpina', 7);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Ronaldo', 'ronaldo', 'ronaldo', 8);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Malboro', 'malboro', 'malboro', 9);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Mario', 'mario', 'mario', 10);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Misael', 'misael', 'misael', 11);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Ana', 'ana', 'ana', 12);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Fernanda', 'fernanda', 'fernanda', 13);



insert into GRUPO (nome_grupo, id_grupo, id_admin) values ('Never', 1, 1);
insert into GRUPO (nome_grupo, id_grupo, id_admin) values ('Numb', 2, 1);
insert into GRUPO (nome_grupo, id_grupo, id_admin) values ('Encore', 3, 11);
insert into GRUPO (nome_grupo, id_grupo, id_admin) values ('Pelada', 4, 5);

insert into DESPESA (id_despesa, razao, valor, id_grupo) values (1, 'agua', 23.0, 3);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (2, 'luz', 245.17, 1);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (3, 'telefone', 300.08, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (4, 'internet', 77.9, 3);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (5, 'academia', 51.0, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (6, 'revista playboy', 31.74, 3);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (7, 'faxineira', 800.0, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (8, 'passadeira', 50.0, 3);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (9, 'balada', 65.78, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (10, 'corre', 150.0, 3);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (11, 'papel higienico', 23.99, 3);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (12, 'viagem',1987.13 , 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (13, 'cafe', 7.69, 3);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (14, 'arroz', 15.78, 3);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (15, 'feijao', 21.37, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (16, 'carne', 37.81, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (17, 'batata', 5.24, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (18, 'inter usp', 613.41, 3);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (19, 'manutencao pia', 217.65, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (20, 'racao cachorro', 57.99, 3);

insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (1, 1, 1);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (2, 2, 2);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (3, 3, 2);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (4, 4, 2);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (5, 5, 2);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (6, 6, 3);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (7, 7, 3);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (8, 8, 3);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (9, 9, 3);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (10, 10, 3);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (11, 11, 3);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (12, 12, 3);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (13, 1, 4);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (15, 2, 4);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (16, 3, 4);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (17, 4, 4);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (18, 12, 4);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (19, 11, 1);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (20, 9, 1);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (21, 5, 1);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (22, 4, 3);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (23, 11, 4);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (24, 7, 4);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (25, 5, 4);


insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (1, 1, 1);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (2, 2, 2);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (3, 3, 3);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (4, 4, 4);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (5, 5, 5);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (6, 5, 6);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (7, 5, 7);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (8, 6, 8);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (9, 7, 9);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (10, 8, 10);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (11, 9, 11);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (12, 10, 12);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (13, 11, 13);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (14, 12, 14);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (15, 13, 15);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (16, 1, 16);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (17, 2, 17);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (18, 3, 18);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (19, 4, 19);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (20, 5, 20);


insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (1, 2, 1);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (2, 3, 1);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (3, 4, 1);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (4, 5, 1);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (5, 6, 1);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (6, 7, 1);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (7, 8, 1);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (8, 9, 1);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (9, 3, 2);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (10, 4, 2);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (11, 5, 2);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (12, 6, 3);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (13, 7, 3);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (14, 8, 4);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (15, 3, 4);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (16, 3, 4);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (17, 3, 5);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (18, 9, 5);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (19, 10, 5);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (20, 11, 5);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (21, 12, 6);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (22, 13, 6);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (23, 1, 7);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (24, 2, 7);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (25, 3, 7);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (26, 4, 7);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (27, 9, 7);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (28, 10, 8);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (29, 4, 8);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (30, 5, 8);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (31, 6, 8);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (32, 1, 8);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (33, 5, 9);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (34, 10, 9);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (35, 11, 10);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (36, 1, 10);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (37, 2, 10);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (38, 3, 10);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (39, 4, 10);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (40, 5, 11);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (41, 6, 11);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (42, 7, 12);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (43, 8, 12);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (44, 4, 12);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (45, 3, 13);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (46, 2, 13);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (47, 1, 13);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (48, 1, 14);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (49, 8, 14);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (50, 9, 14);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (51, 7, 15);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (52, 10, 15);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (53, 12, 15);*/


/*Novo banco*/

insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Raul', 'raulll', '123456789', 1);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('R', 'R', 'R', 2);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Bruno', 'bru', '9', 3);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Allan', 'Allan', 'allan', 4);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Joao', 'joao', 'joao', 5);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Maria', 'maria', 'maria', 6);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Derpina', 'derpina', 'derpina', 7);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Ronaldo', 'ronaldo', 'ronaldo', 8);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Malboro', 'malboro', 'malboro', 9);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Mario', 'mario', 'mario', 10);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Misael', 'misael', 'misael', 11);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Ana', 'ana', 'ana', 12);
insert into USUARIO (nome_usuario, login, senha, id_usuario) values ('Fernanda', 'fernanda', 'fernanda', 13);



insert into GRUPO (nome_grupo, id_grupo, id_admin) values ('Never', 1, 1);
insert into GRUPO (nome_grupo, id_grupo, id_admin) values ('Numb', 2, 1);
insert into GRUPO (nome_grupo, id_grupo, id_admin) values ('Encore', 3, 11);
insert into GRUPO (nome_grupo, id_grupo, id_admin) values ('Pelada', 4, 5);

insert into DESPESA (id_despesa, razao, valor, id_grupo) values (1, 'agua', 23.0, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (2, 'luz', 245.17, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (3, 'telefone', 300.08, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (4, 'internet', 77.9, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (5, 'academia', 51.0, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (6, 'revista playboy', 31.74, 4);
/*insert into DESPESA (id_despesa, razao, valor, id_grupo) values (7, 'faxineira', 800.0, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (8, 'passadeira', 50.0, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (9, 'balada', 65.78, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (10, 'corre', 150.0, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (11, 'papel higienico', 23.99, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (12, 'viagem',1987.13 , 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (13, 'cafe', 7.69, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (14, 'arroz', 15.78, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (15, 'feijao', 21.37, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (16, 'carne', 37.81, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (17, 'batata', 5.24, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (18, 'inter usp', 613.41, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (19, 'manutencao pia', 217.65, 4);
insert into DESPESA (id_despesa, razao, valor, id_grupo) values (20, 'racao cachorro', 57.99, 4);*/

insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (1, 1, 4);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (2, 2, 4);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (3, 3, 4);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (4, 4, 4);
insert into USUARIO_GRUPO (id_relacao, id_usuario, id_grupo) values (5, 5, 4);

insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (1, 1, 1);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (2, 2, 2);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (3, 3, 3);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (4, 4, 4);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (5, 5, 5);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (6, 1, 6);
/*insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (7, 2, 7);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (8, 3, 8);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (9, 4, 9);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (10, 5, 10);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (11, 1, 11);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (12, 2, 12);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (13, 3, 13);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (14, 4, 14);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (15, 5, 15);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (16, 1, 16);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (17, 2, 17);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (18, 3, 18);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (19, 4, 19);
insert into PAGANTE_DESPESA (id_relacao, id_usuario, id_despesa) values (20, 5, 20);*/


insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (1, 2, 1);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (2, 3, 1);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (3, 4, 1);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (4, 5, 1);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (5, 1, 2);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (6, 3, 2);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (7, 4, 2);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (8, 5, 2);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (9, 1, 3);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (10, 2, 3);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (11, 4, 3);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (12, 5, 3);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (13, 1, 4);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (14, 2, 4);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (15, 3, 4);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (16, 5, 4);	
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (17, 1, 5);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (18, 2, 5);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (19, 3, 5);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (20, 4, 5);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (21, 2, 6);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (22, 3, 6);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (23, 4, 6);
insert into DEVEDOR_DESPESA (id_relacao, id_usuario, id_despesa) values (24, 5, 6);
