# Organizador de turnos 

Este es un proyecto para la materia Aplicaciones Java sobre Web correspondiente al quinto año de la carrera ingenieria en informatica de la universidad nacional Arturo Jauretche.

## Installation

Importar el proyecto en IntelliJ.
Setear el active profile desde la opcion de configuraciones(al lado del boton run)

```javascript
Para usar MySQL como base de datos.
Enviroment variables => spring.profiles.active=dev 

Para usar H2 como base de datos en memoria.
Enviroment variables => spring.profiles.active=default 
Se puede acceder a la consola de la misma con el endpoint '/h2-console'.
Las tablas se crean automaticamente.

```

Configurar el archivo src/main/resources/application-dev.yml apropiadamente.

```yml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/«Database name»
    username: «Database user»
    password: «password»
    platform: mysql
```
Ejecutar script hospitals_create_database.sql

## Usage

```python

```


## License
[MIT](https://choosealicense.com/licenses/mit/)