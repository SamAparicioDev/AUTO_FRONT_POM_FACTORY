# Plan: AUTO_FRONT_POM_FACTORY

Plan operativo para construir y ejecutar automatización UI con POM.

## 1) Precondiciones técnicas

- Java 17+ y Gradle disponibles.
- Chrome/Chromium instalado para pruebas UI.
- Docker y Docker Compose instalados.
- Sistema CyberGuard levantado desde raíz del monorepo.

## 2) Levantar sistema bajo prueba

1. En la raíz `cyberguard-system`:

```bash
docker compose up -d --build
docker compose ps
```

2. Verificar:
   - UI: `http://localhost:4200`
   - API: `http://localhost:3000/health`

## 3) Configuración mínima del proyecto de pruebas

1. Configurar dependencias Serenity + Cucumber + JUnit.
2. Definir `webdriver.base.url = "http://localhost:4200"` en `serenity.conf`.
3. Activar evidencia:
   - `serenity.take.screenshots = "BEFORE_AND_AFTER_EACH_STEP"`.

## 4) Estrategia de implementación

1. Escribir `autenticacion.feature`.
2. Implementar `PageObjects` de Login y Dashboard.
3. Implementar `StepDefinitions` y `Runner`.
4. Ejecutar localmente y estabilizar waits.

## 5) Ejecución

En `AUTO_FRONT_POM_FACTORY`:

```bash
./gradlew clean test aggregate
```

## 6) Resultado esperado

- 2 escenarios ejecutados.
- Reporte disponible en `target/site/serenity/index.html`.
- Evidencia visual por pasos Given/When/Then.
