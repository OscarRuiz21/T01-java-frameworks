CREATE TABLE IF NOT EXISTS mensajes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    destinatario VARCHAR(100),
    remitente VARCHAR(100),
    copiaPara VARCHAR(100),
    texto VARCHAR(1000),
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP
    );

INSERT INTO mensajes (destinatario, remitente, copiaPara, texto)
VALUES ('juan@example.com', 'maria@example.com', 'oscar@example.com', 'Hola, ¿cómo estás?');
