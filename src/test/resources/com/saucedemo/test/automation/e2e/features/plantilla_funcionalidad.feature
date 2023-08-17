# El "#languaje" No es un comentario representa el tipo de lenguaje utilizado en la estructura de Gherkin
#language: es

# @Todos            # Etiqueta para todos los escenarios
# @{Funcionalidad}  # Palabra clave representativa de la funcionalidad

#@Todos
@{{Funcionalidad}}
Característica: {{Nombre de la funcionalidad}}
  Yo como {{rol/actor/..}}
  Necesito {{necesidad}}
  Para {{objetivo}}

  # @HP            # Tipo de prueba [Happy Path | Altern Path]
  # @Regresion     # Aplica para regresion
  # @Smoke         # Aplica para prueba de humo
  # @C######       # ID CP en la herramienta de gestion de pruebas (TestRail / XRay ...)
  # @Actual        # Escenario que se esta automatizando/trabajando actualmente


  @{{HP|AP}}
  @{{ID_ESCENARIO}} # {{Titulo del escenario de prueba sujeto al ID, desde la herramienta de gestion de pruebas}}
  Escenario: {{Descripcion del escenario con un unico caso de prueba, regularmente obedece al titulo sujeto al ID del caso de prueba}}
      # R/ ¿Donde se encuentra el actor? --> ubicación / contexto
      # R/ ¿Que acabó de realizar el actor? --> previamente, en tiempo pasado
    Dado que "Claudia" {{responda una de las preguntas anteriores, preferiblemente la primera}} {{añada un contexto opcional}}
      # R/ ¿Que esta haciendo el actor? --> en tiempo presente, comportamiento sujeto de prueba
    Cuando {{responda la pregunta anterior}} {{añada un contexto opcional}}
      # R/ ¿Que se espera? --> en tiempo futuro, validación / verificación
      # R/ ¿Cual es la consecuencia de sus actos? --> en tiempo futuro, lo que sucederá
    Entonces deberia {{responda la pregunta anterior}}


  @{{HP|AP}}
  @{{ID_ESCENARIO}} # {{Titulo del escenario de prueba sujeto al ID, desde la herramienta de gestion de pruebas}}
  Esquema del escenario: {{Descripcion del escenario con mas de un caso de prueba, regularmente obedece al titulo sujeto al ID del caso de prueba}}
      # R/ ¿Donde se encuentra el actor? --> ubicación / contexto
      # R/ ¿Que acabó de realizar el actor? --> previamente, en tiempo pasado
    Dado que "Claudia" {{responda una de las preguntas anteriores, preferiblemente la primera}} {{añada un contexto opcional}}
      # R/ ¿Que esta haciendo el actor? --> en tiempo presente, comportamiento sujeto de prueba
    Cuando {{responda la pregunta anterior}} {{añada un contexto opcional}}
      | parametro1   | parametro2   | parametroN   |
      | <parametro1> | <parametro2> | <parametroN> |
      # R/ ¿Que se espera? --> en tiempo futuro, validación / verificación
      # R/ ¿Cual es la consecuencia de sus actos? --> en tiempo futuro, lo que sucederá
    Entonces debería {{responda la pregunta anterior}}
    Ejemplos:
      | parametro1 | parametro2 | parametroN |
      | valor1     | valor2     | valorN     |



