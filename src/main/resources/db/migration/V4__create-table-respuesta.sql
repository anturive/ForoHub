CREATE TABLE Respuesta (
    id BIGINT AUTO_INCREMENT,
    mensaje TEXT NOT NULL,
    fecha DATETIME,
    topico_id BIGINT NOT NULL,
    autor_id BIGINT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (topico_id) REFERENCES Topico(id),
    FOREIGN KEY (autor_id) REFERENCES Usuario(id)
);