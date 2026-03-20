# Proyecto de Automatización: Front-End con POM y Page Factory

Este documento contiene las especificaciones para automatizar las pruebas del flujo de autenticación del proyecto **CyberGuard System** utilizando el patrón **Page Object Model (POM)** con Page Factory.

---

## 1. Contexto del Negocio

CyberGuard System es una plataforma de ciberseguridad para el reporte y notificación de amenazas en tiempo real. Este proyecto se enfoca en validar el acceso de los administradores al sistema.

---

## 2. Configuración del Entorno de Pruebas

Antes de ejecutar las pruebas, el sistema CyberGuard debe estar en funcionamiento.

-   **URL de la Aplicación (Frontend):** `http://localhost:4200`

### Pasos para Levantar el Entorno

1.  En la raíz del proyecto `cyberguard-system`, ejecuta:
    ```bash
    docker-compose up -d --build
    ```
2.  Verifica que los contenedores estén activos con `docker-compose ps`.

---

## 3. Casos de Prueba a Implementar

**Objetivo:** Validar el flujo de autenticación.

### Escenario 1: Flujo Positivo
-   **ID del Caso Base:** `TC-AI-HU001-01`
-   **Nombre:** Inicio de sesión exitoso con credenciales válidas.
-   **Gherkin (`autenticacion.feature`):**
    ```gherkin
    Feature: Autenticación de Administrador con POM

      Scenario: Inicio de sesión exitoso
        Given que el administrador está en la página de login
        When ingresa credenciales válidas
        Then debería ver el dashboard de amenazas
    ```

### Escenario 2: Flujo Negativo
-   **ID del Caso Base:** `TC-AI-HU001-03`
-   **Nombre:** Inicio de sesión fallido por contraseña incorrecta.
-   **Gherkin (`autenticacion.feature`):**
    ```gherkin
    Feature: Autenticación de Administrador con POM

      Scenario: Inicio de sesión fallido por contraseña incorrecta
        Given que el administrador está en la página de login
        When ingresa un usuario válido y una contraseña incorrecta
        Then debería ver un mensaje de error de credenciales inválidas
    ```

---

## 4. Datos de Prueba: Credenciales

Utiliza el siguiente usuario con rol de **administrador**:

-   **Usuario:** `admin@cyberguard.com`
-   **Contraseña:** `AdminSofka123456`

---

## 5. Instrucciones de Ejecución

Dentro de este directorio (`AUTO_FRONT_POM_FACTORY`), ejecuta el siguiente comando para correr las pruebas y generar el reporte:

```bash
./gradlew clean test aggregate
```

El reporte de Serenity BDD se encontrará en `target/site/serenity/`.
