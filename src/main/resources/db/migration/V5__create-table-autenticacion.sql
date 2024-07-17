CREATE TABLE autenticacion(
    id BIGINT NOT NULL AUTO_INCREMENT,
    login VARCHAR(100) NOT NULL,
    clave VARCHAR(100) NOT NULL,
    primary key (id)
);