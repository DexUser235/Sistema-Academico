# Sistema-Academico

Sistema académico desarrollado en **Java** como proyecto de **Programación Orientada a Objetos**, con enfoque principal en la aplicación de **patrones de diseño** y principios **SOLID**.

El proyecto se encuentra en desarrollo y posteriormente incorporará **base de datos**. La interfaz se implementó con **Spring Boot**.

## Objetivos

- Aplicar POO en un sistema académico.
- Implementar patrones de diseño.
- Mantener el código desacoplado y extensible mediante SOLID.
- Integrar posteriormente persistencia de datos.

## Patrones implementados

- Builder 
- Strategy 
- Decorator
- Proxy

## Estructura del proyecto

```text
src/
└── main/
    ├── java/
    │   └── universidad/
    │       ├── App.java
    │       ├── controller/
    │       ├── service/
    │       └── model/
    │           ├── Builder/
    │           └── Strategy/
    │               ├── Decorator/
    │               ├── dictadoClases/
    │               └── Prom/
    └──
```

## Cómo ejecutar

Ejecuta la clase `universidad.App` y entra desde el navegador por:

**http://localhost:8080/**

## Tecnologías

- Java
- Spring Boot
- Programación Orientada a Objetos
- Principios SOLID
- Patrones de diseño
- Base de datos *(próximamente)*
