# Exercici Spring Boot i Maven

Aquest projecte és un primer contacte amb Spring Boot i Maven, on es desenvolupa una API REST bàsica.

## Configuració del projecte

### 1. Generació del projecte

Accedeix a [Spring Initializr](https://start.spring.io/) i genera un projecte Spring Boot amb les següents característiques:

- **Projecte**: Maven
- **Llenguatge**: Java
- **Versió de Spring Boot**: Última versió estable
- **Project Metadata**:
  - **Group**: `cat.itacademy.s04.t01.n01`
  - **Artifact**: `S04T01N01`
  - **Name**: `S04T01N01`
  - **Description**: `S04T01N01`
  - **Package name**: `cat.itacademy.s04.t01.n01`
- **Packaging**: Jar
- **Versió de Java**: Mínim 11
- **Dependències**:
  - Spring Boot DevTools
  - Spring Web

### 2. Importació a Eclipse

1. Descarrega i descomprimeix el projecte generat.
2. Obre Eclipse.
3. Ves a **File > Import > Existing Maven Project**.
4. Selecciona la carpeta del projecte i importa'l.

### 3. Configuració del port

Modifica l'arxiu `src/main/resources/application.properties` i afegeix la següent línia per configurar el port del servidor:

```
server.port=9000
```

## Desenvolupament de l'API REST

### 1. Creació del controlador

Dins del package principal `cat.itacademy.s04.t01.n01`, crea un subpackage anomenat `controller`. A dins, afegeix la classe `HelloWorldController` amb el següent codi:

```java
package cat.itacademy.s04.t01.n01.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping("/HelloWorld")
    public String saluda(@RequestParam(defaultValue = "UNKNOWN") String nom) {
        return "Hola, " + nom + ". Estàs executant un projecte Maven";
    }

    @GetMapping({"/HelloWorld2", "/HelloWorld2/{nom}"})
    public String saluda2(@PathVariable(required = false) String nom) {
        if (nom == null) {
            nom = "UNKNOWN";
        }
        return "Hola, " + nom + ". Estàs executant un projecte Maven";
    }
}
```

### 2. Execució de l'aplicació

Per executar l'aplicació, obre un terminal i dirigeix-te a la carpeta del projecte. Executa la següent comanda:

```
mvn spring-boot:run
```

### 3. Comprovació del funcionament

Un cop l'aplicació estigui en execució, pots fer peticions GET als següents endpoints:

- `http://localhost:9000/HelloWorld` → Retorna: *"Hola, UNKNOWN. Estàs executant un projecte Maven"*
- `http://localhost:9000/HelloWorld?nom=El meu nom` → Retorna: *"Hola, El meu nom. Estàs executant un projecte Maven"*
- `http://localhost:9000/HelloWorld2` → Retorna: *"Hola, UNKNOWN. Estàs executant un projecte Maven"*
- `http://localhost:9000/HelloWorld2/elmeunom` → Retorna: *"Hola, elmeunom. Estàs executant un projecte Maven"*

## Conclusió

Aquest exercici permet familiaritzar-se amb Spring Boot, la configuració de Maven i la creació d'un servei REST bàsic amb controladors que gestionen paràmetres mitjançant `@RequestParam` i `@PathVariable`. També ensenya a configurar l'aplicació i a executar-la en un servidor local.

