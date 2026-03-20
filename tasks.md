# Tasks: AUTO_FRONT_POM_FACTORY

Este documento desglosa las tareas de implementación necesarias para completar la automatización del flujo de autenticación.

## Tareas de Implementación

1. **Configurar proyecto base**
    - [x] Inicializar Gradle Java.
    - [x] Agregar dependencias Serenity BDD + Cucumber + JUnit4/5 según runner elegido.
    - [x] Configurar `src/test/resources/serenity.conf` con:
        - [x] `webdriver.base.url = "http://localhost:4200"`
        - [x] `serenity.take.screenshots = "BEFORE_AND_AFTER_EACH_STEP"`

2. **Estructura recomendada**
    - [x] Crear `src/test/resources/features/autenticacion.feature`.
    - [x] Crear paquete `ui/pages` para Page Objects.
    - [x] Crear paquete `stepdefinitions`.
    - [x] Crear paquete `runners`.

3. **Feature en Gherkin**
    - [x] Implementar 2 escenarios de `spec.md`.
    - [x] Etiquetar escenarios (`@positive`, `@negative`, `@smoke`).

4. **Page Objects (POM + PageFactory)**
    - [x] `LoginPage.java`: campos usuario/contraseña, botón login, mensaje de error.
    - [x] `DashboardPage.java`: elemento inequívoco de autenticación exitosa.
    - [x] Métodos públicos semánticos y de responsabilidad única.

5. **Step Definitions**
    - [x] `Given`: abrir login.
    - [x] `When`: autenticación con credenciales de escenario.
    - [x] `Then` positivo: validar pantalla autenticada.
    - [x] `Then` negativo: validar mensaje de error + permanencia en login.

6. **Runner y ejecución**
    - [x] Crear `TestRunner.java` con Cucumber + Serenity.
    - [x] Ejecutar `./gradlew clean test aggregate`.

7. **Criterios de calidad**
    - [x] Sin código comentado.
    - [x] Sin sleeps fijos; usar waits explícitos.
    - [x] Pruebas independientes.
    - [x] Reporte Serenity generado con capturas.
