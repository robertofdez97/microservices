INSERT INTO users (username, password, enabled, name, last_name,email) values ('rober', '12345', 1, 'rober', 'fernandez','robertofdez97@gmail.com')
INSERT INTO users (username, password, enabled, name, last_name,email) values ('andres', '12345', 1, 'andres', 'perez','andres@gmail.com')
INSERT INTO roles (name) VALUES ('ROLE_USER')
INSERT INTO roles (name) VALUES ('ROLE_ADMIN')

INSERT INTO users_roles (user_id,roles_id) VALUES (1,1)
INSERT INTO users_roles (user_id,roles_id) VALUES (1,2)
INSERT INTO users_roles (user_id,roles_id) VALUES (2,1)