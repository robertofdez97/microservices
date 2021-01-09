INSERT INTO users (username, password, enabled, name, last_name,email) values ('rober', '$2a$10$eMnjSftxjZVgpQbghfxLcup6wRberDn2wwb/oUe8neiXYpyZohOne', 1, 'rober', 'fernandez','robertofdez97@gmail.com')
INSERT INTO users (username, password, enabled, name, last_name,email) values ('andres', '$2a$10$3v3mTrt55oFiGnIuitDnAeU66GWI/.HPEG/7mxXpjjiMn.YyLqM8S', 1, 'andres', 'perez','andres@gmail.com')
INSERT INTO roles (name) VALUES ('ROLE_USER')
INSERT INTO roles (name) VALUES ('ROLE_ADMIN')

INSERT INTO users_roles (user_id,roles_id) VALUES (1,1)
INSERT INTO users_roles (user_id,roles_id) VALUES (1,2)
INSERT INTO users_roles (user_id,roles_id) VALUES (2,1)