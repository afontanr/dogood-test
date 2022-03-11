# Getting Started

Prueba técnica de un sistema de puntuaciones.
## Getting started

### Paso 1: Levantar base de datos
Levantaremos un contenedor docker postgresql que expondrá el puerto 5434
```  bash
docker run -p 5434:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=pass -e POSTGRES_DB=postgres -d postgres:13
```

### Paso 2: Inicializar base de datos

Utilizando el plugin de flyway vamos a inicializar la base de datos anterior.
```bash
mvn flyway:migrate
```

### Paso 3: Levantar la aplicación

Ahora podemos levantar la aplicación y ejecutar las peticiones de la colección postman. La aplicación se levanta en el puerto 7020.
```bash
mvn spring-boot:run
```

## Suposiciones

Todos los movimientos se realizan de un usuario sobre otro, por tanto, las penalizaciones y las ganancias de puntos las realiza un usuario administrador sobre un usuario jugador.