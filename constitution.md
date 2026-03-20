# Constitution: AUTO_FRONT_POM_FACTORY

Este documento define principios obligatorios para implementar pruebas UI con Serenity BDD bajo patrón POM + Page Factory.

## Principios No Negociables

1. **Arquitectura POM estricta**
    - Cada página/componente relevante se modela en un `PageObject` dedicado.
    - No se permite lógica de negocio en `StepDefinitions` más allá de orquestación.

2. **Page Factory y localizadores resilientes**
    - Usar `@FindBy` con selectores estables (id, name, data-*).
    - Evitar selectores frágiles acoplados a estructura visual cambiante (xpath largos).

3. **Alta cohesión y bajo acoplamiento**
    - `PageObjects`: solo interacción UI (acciones + lecturas de estado).
    - `Steps`: solo narrativa Gherkin y aserciones.
    - Aserciones centralizadas y mensajes claros.

4. **Clean Code**
    - Nombres semánticos en clases, métodos y variables.
    - Sin código comentado ni duplicación innecesaria.
    - Métodos cortos con responsabilidad única.

5. **Pruebas determinísticas e independientes**
    - Cada escenario prepara su estado y no depende de otro.
    - Manejo explícito de esperas (waits) para evitar flakiness.

6. **Trazabilidad y evidencia**
    - Capturas activas en Serenity con `BEFORE_AND_AFTER_EACH_STEP`.
    - Reporte final debe mostrar Given/When/Then con evidencia visual.

## Definition of Done

- Los 2 escenarios definidos en `spec.md` pasan en ejecución limpia.
- Se genera reporte Serenity en `target/site/serenity/index.html`.
- El código respeta patrón POM + Page Factory y principios anteriores.
