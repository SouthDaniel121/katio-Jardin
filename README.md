# Biblioteca Digital Secretos Para Contar

## Project Katio

Este project de Spring Boot con JPA y MySQL/MongoDB está diseñado para ser una biblioteca o repositorio de libros digital para la Fundación Secretos Para contar.

## Grupo Dinamita



## integrantes
Sofia Pineda , Alejandro Buitrago y Daniel Orrego


## Entrega final de 15 de junio

### Usuarios

- [ x ] Crear un usuario, utilizar el registro.
- [ x ] Login del usuario: debe regresar un token bearer. Al hacer login, debo poder usar el token para cuaquier otra acción.
- [ x ] Todas mis acciones deben quedar bajo llave, con la sola excepción de: Login, Signup.
- [ x ] Editar un usuario.
- [  ] Debo poder reiniciar mi clave, solo mi clave. Debo colocar la clave anterior, y dos veces la clave nueva.
- [ x ] Listar todos mis usuarios.
- [ x ] Listar todos mis usuarios por email, o identificación.
- [ x ] Agregar un username. No todos los usuarios tienen un correo hábil. Ambos campos son distintos, pero puede repetir la información.
- [ ] Manejar los perfiles (Roles) del usuario.

### Libros

- [ x ] Crear un libro.
- [ x ] Editar un libro.
- [ x ] Buscar libro por nombre, de forma relativa.
- [ x ] Buscar libro por autor, de forma relativa, por nombre y apellido del autor.
- [ x ] Buscar libro por editorial.
- [ x ] Buscar libro por genero.
- [ x ] No pueden haber dos versiones del mismo libro.
- [ ] Agregar temas al libro.
- [ ] Subir un libro en PDF a la biblioteca.
- [ x ] Buscar libro por fecha de publicación.
- [ ] Servir un libro en PDF al cliente.
- [ ] Agregar varios géneros a un libro.
- [ ] Los libros pueden tener varios autores.
- [ ] un libro puede tener varios temas.
-
- [ ] Agregar libros relacionados a un libro principal

### Audiolibros

- [ x ] Crear un audiolibro.
- [ x ] Editar un audiolibro.
- [ x ] Buscar Audiolibro por nombre, de forma relativa.
- [ x ] Buscar Audiolibro por autor, de forma relativa, por nombre y apellido del autor.
- [ x ] Buscar Audiolibro por editorial.
- [ x ] Buscar Audiolibro por genero.
- [ x ] Buscar Audiolibro por fecha de publicación.
- [ ] Subir un audiolibro en MP3/OGG a la biblioteca.
- [ ] Servir un audiolibro en MP3/OGG al cliente.
- [ x ] Buscar un audiolibro por narrador.
- [ x ] Buscar un audiolibro por longitud.
- [ ] Agregar varios géneros a un libro.
- [ ] Los libros pueden tener varios autores.
- [ ] Agregar temas al libro.
- [ ] un libro puede tener varios temas.
- [ ] No pueden haber dos versiones del mismo libro.

### Autores

- [ ] Buscar todos los audiolibros de un autor por relación.
- [ x ] Crear un Autor
- [ x ] Editar un Autor
- [ x ] Buscar un autor por nombre y apellido de forma relativa.
- [ x ] Buscar un autor por fecha de nacimiento
- [ x ] Buscar un autor por país de procedencia
- [ x ] Buscar todos los libros de un autor por relación.


### Narradores

- [ x ] Crear un narrador
- [ x ] Editar un narrador
- [ x ] Buscar narrador por nombre.
- [ x ] Buscar narrador por perfil de voz.
- [ ] Buscar libros narrados por el narrador por relación.

### Utils

- [ ] manejo correcto de errores.
- [ ] utilizar try catch donde sea necesario
- [ ] Hacer rollback donde sea necesario.
- [ ] Usar el tipo correcto para mejorar la memoria.
- [ ] no hacer llamados innecesarios.
- [ ] Extraer funcionalidad repetida en su propia clase, o método.

### Admin / Estadísticas

- [ ] Ver mis usuarios, editarlos y desactivarlos.
- [ ] Asignar una clave de forma directa a un usuario a través de la edición
- [ ] El username y el email no son mutables.
- [ ] Agregar estadísticas al sitio.
- [ ] Cada vez que se descargue un libro, tener un contador que se encargue de llevar la cuenta.
- [ ] Cada vez que  se reproduzca un audilibro, tener un contador que se encargue de llevar la cuenta.
- [ ] Cada vez que se mire el perfil de un autor con sus libros, tener un contador que se encargue de llevar la cuenta.
- [ ] Cada vez que se descargue un libro, o se escuche un audiolibro, marcar el género en una tabla de contadores que lleve la cuenta.
- [ ] Última conexión al usuario.
- [ ] Llevar la cuenta de cuantos dias distintos se conecta un usuario. Diferente a la última conexión.
- [ ] Agregar logs al sistema.
- [ ] Basada en las conexiones y la cuenta de las mismas, emitir una estadística que diga cuales son los días más activos para el sistema.
- [ ] llevar la cuenta de intentos fallidos al hacer login. Al llegar a 10, bloquear el usuario. una vez se ingrese la clave correcta, reiniciar el contador a 0;
- [ ] Cambiar la longitud de duración del token a 24H.'
- [ ] Actualizar su sistema a la última versión de Java y Spring.



















## BONUS TRACKS (Actividades Extra Curriculares)

- Crear un front end en angular o react. Que sea capaz de implementar todos los dominios.
    - Crear pagina de signup
    - crear página de login
    - crear Modulo de libros
        - Buscar        
        - Descargar
    - Crear módulo de Autores
        - Buscar
        - listar
    - Crear módulo de Audiolibros
        - Buscar
        - Listar
    - Crear módulo de Admin con todas las funcionalidades implementadas del Backend. Incluir lo que se considere necesario.


## BONUS TRACK EXCLUSIVE (Actividad Extra Extra Curricular, SUMA CUM LAUDE)

```csharp
// C# Dotnet 8
public void Main(String[] args)
{
    const string NET_VERSION = "8.0 (SDK 8.0.301)";
    const string LANGUAGE_VERSION = "C#";
    Console.WriteLine($"Escribir todo el backend en {NET_VERSION} y {LANGUAGE_VERSION}");
    return 0;
}
```

## BONUS TRACK GENIUS MODE (Actividad Extra Extra Extra Curricular, SUMA CUM LAUDE, PHD Doctorate)

```rust
// Rust Languge 1.78.0
use std::io;

fn main (){
    println!("Write this in Rust Language with Axum or Rocket.");
}
```

