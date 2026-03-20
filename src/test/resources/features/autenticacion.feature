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
