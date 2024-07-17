# ForoHub API Alura Back End

ForoHub es una API RESTful para gestionar tópicos y respuestas en un foro.


## Tecnologías Utilizadas

- Java 17
- Spring Boot 3
- Spring Security
- JPA/Hibernate
- MySQL
- Flyway
- Maven

## Advertencias
No se puede registrar el mismo topico y mensaje, usuario o curso 2 veces
Se requiere de un token para probar la API

## Endpoints

![forohub](src/main/java/com/forohubapi/assets/forohub.png)

## Ejemplo

- Get (Listar todos los topicos)
![forohub-get-lista](src/main/java/com/forohubapi/assets/get_lista.png)

- Get (Mostrar un topico - requiere el id del topico)
![forohub-get](src/main/java/com/forohubapi/assets/get.png)

- Post (Registrar un topico)

![forohub-post](src/main/java/com/forohubapi/assets/post.png)

- Put (Actualizar un topico)

![forohub-post](src/main/java/com/forohubapi/assets/put.png)

![forohub-post](src/main/java/com/forohubapi/assets/put2.png)

- Delete (Eliminar fisicamente el topico en la Base de datos)

## Base de datos

![forohub-bd](src/main/java/com/forohubapi/assets/bd.png)
