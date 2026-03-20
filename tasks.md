# Tasks: AUTO_FRONT_POM_FACTORY

Este documento desglosa las tareas de implementación necesarias para completar la automatización del flujo de autenticación.

## Tareas de Implementación

1. **Configurar proyecto base**
    - [ ] Inicializar Gradle Java.
    - [ ] Agregar dependencias Serenity BDD + Cucumber + JUnit4/5 según runner elegido.
    - [ ] Configurar `src/test/resources/serenity.conf` con:
      - [ ] `webdriver.base.url = "http://localhost:4200"`
      - [ ] `serenity.take.screenshots = "BEFORE_AND_AFTER_EACH_STEP"`

2. **Estructura recomendada**
    - [ ] Crear `src/test/resources/features/autenticacion.feature`.
    - [ ] Crear paquete `ui/pages` para Page Objects.
    - [ ] Crear paquete `stepdefinitions`.
    - [ ] Crear paquete `runners`.

3. **Feature en Gherkin**
    - [ ] Implementar 2 escenarios de `spec.md`.
    - [ ] Etiquetar escenarios (`@positive`, `@negative`, `@smoke`).

4. **Page Objects (POM + PageFactory)**
    - [ ] `LoginPage.java`: campos usuario/contraseña, botón login, mensaje de error.
    - [ ] `DashboardPage.java`: elemento inequívoco de autenticación exitosa.
    - [ ] Métodos públicos semánticos y de responsabilidad única.

5. **Step Definitions**
    - [ ] `Given`: abrir login.
    - [ ] `When`: autenticación con credenciales de escenario.
    - [ ] `Then` positivo: validar pantalla autenticada.
    - [ ] `Then` negativo: validar mensaje de error + permanencia en login.

6. **Runner y ejecución**
    - [ ] Crear `TestRunner.java` con Cucumber + Serenity.
    - [ ] Ejecutar `./gradlew clean test aggregate`.

7. **Criterios de calidad**
    - [ ] Sin código comentado.
    - [ ] Sin sleeps fijos; usar waits explícitos.
    - [ ] Pruebas independientes.
    - [ ] Reporte Serenity generado con capturas.
