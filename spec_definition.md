# Datos del sistema

- Construido con el OpenJDK 21, Spring boot y MariaDB

## Return types

200 - OK

401 - NotAuthorized

403 - BadRequest

404 - NotFound

500 - InternalServerError

503 - ServiceUnavailable

## Módulo de usuarios `Controlador`

![Diagrama inicial para ](diagrama_sc_usuarios.svg)

### Tipos de usuario

- Usuario registrado: este usuario son las personas que utilizan la aplicación
- Usuarios Administradores:
  - que suben o bajan el contenido del sitio.
  - Pueden eliminar o crear usuarios
  - Pueden bloquear usuarios
  - Pueden deshabilitar o habilitar secciones
  - Tiene poder absoluto.
  - Los desarrolladores están un nivel por encima, y los vamos a llamar GodMode.

|Verb|Action|Params|Returns|Results|
|---|---|---|---|---|
|GET|BuscarUsuarioPorNombre|@RequestParam|Usurio|200, 403, 404, 500 |
|GET|BuscarUsuarioPorID|@RequestParam|Usuario| 200, 403, 404, 500|
|GET|BuscarUsuarioPorCedula|@RequestParam|Usuario|200, 403, 404, 500|
|POST|Login|@RequestBody|Token|200, 403, 500|
|PATCH|EditarUsuario|@RequestBody|Usuario|200, 403, 404, 500|
|PUT|RegistrarUsuario|@RequestBody|Usuario|200, 400, 403, 500|
|DELETE|EliminarUsuario|@RequestBody||200, 404, 403, 500|
|POST|BloquearUsuario|@RequestBody|Usuario|200, 404, 403, 500|

## Acciones

## **GET** - *BuscarUsuarioPorNombre*

- Busca el usuario por nombre.

## **GET** - *BuscarUsuarioPorID*

- Busca el usuario por el ID de BD

## **GET** - *BuscarUsuarioPorCédula*

- Busca el usuario por el número de identificación.

## **POST** - *Login*

- hace un login de usuario utilizando un DTO de login (usuario, clave)
- El sitio solo debe devolver 200 o 403 Badrequest, el mensaje para error es: "Las credenciales no son correctas"

## **PATCH** - *EditarUsuario*

- Edita el usuario con el valor requerido en la entidad.
- Primero se debe buscar que el usuario exista antes de actualizarlo.

## **PUT** - *RegistrarUsuario*

- Registra una entidad de usuario
- El nombre, la cédula son requeridos
- El email debe ser correcto.
- el password debe ser encriptado en Blake3.

## **DELETE** - *EliminarUsuario*

- Eliminar el usuario por ID o por entidad

## **POST** - *BloquearUsuario*

- Bloquear un usuario solo por el ID.

```SQL
CREATE TABLE Users
(
    Id INT NOT NULL AUTO_INCREMENT,
    Nombre NVARCHAR(255) NOT NULL,
    Apellido NVARCHAR(255) NOT NULL,
    Email NVARCHAR(255) NOT NULL,
    Telefono NVARCHAR(20) NOT NULL,
    Identificacion NVARCHAR(20) NOT NULL,
    Passhash NVARCHAR(255) NOT NULL, 
    PRIMARY KEY(ID),
    INDEX email_idx(Email)
);
```
