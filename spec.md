# Specification: AUTO_FRONT_POM_FACTORY

Especificación funcional para automatización UI de autenticación.

## Objetivo

Validar autenticación de administrador en CyberGuard con 2 escenarios independientes (positivo y negativo).

## Datos de prueba

- Usuario admin: `admin@cyberguard.com`
- Password admin: `AdminSofka123456`
- Password inválido sugerido: `AdminSofka123456!BAD`
- URL base UI: `http://localhost:4200`

## Feature

```gherkin
Feature: Autenticación de Administrador con POM
  Como administrador de seguridad
  Quiero iniciar sesión en CyberGuard
  Para acceder a funcionalidades protegidas

  @ui @pom @smoke @positive
  Scenario: Inicio de sesión exitoso con credenciales válidas
    Given que el administrador abre la página de login
    When inicia sesión con usuario "admin@cyberguard.com" y contraseña "AdminSofka123456"
    Then debe visualizar el dashboard de amenazas
    And no debe visualizar mensajes de error de autenticación

  @ui @pom @negative
  Scenario: Inicio de sesión fallido por contraseña incorrecta
    Given que el administrador abre la página de login
    When inicia sesión con usuario "admin@cyberguard.com" y contraseña "AdminSofka123456!BAD"
    Then debe visualizar un mensaje de error de autenticación
    And debe permanecer en la pantalla de login
```

## Criterios de aceptación

1. El flujo positivo debe navegar a pantalla autenticada.
2. El flujo negativo no debe autenticar al usuario.
3. Cada escenario debe ejecutar en forma aislada.
4. El reporte Serenity debe incluir evidencia visual por paso.

## Fuera de alcance

- Validación JWT en API.
- Gestión de amenazas y WebSocket.
