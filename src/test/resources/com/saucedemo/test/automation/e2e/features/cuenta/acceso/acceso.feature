# El "#languaje" No es un comentario representa el tipo de lenguaje utilizado en la estructura de Gherkin
#language: es

# @Todos            # Etiqueta para todos los escenarios
# @{Funcionalidad}  # Palabra clave representativa de la funcionalidad

@Todos
@Cuenta
@Acceso
Característica: acceso a Swag Labs
  Yo como usuario
  Necesito autenticarme con mi cuenta en Swag Labs
  Para acceder al catalogo de productos

  # @HP            # Tipo de prueba [Happy Path | Altern Path]
  # @Regresion     # Aplica para regresion
  # @Smoke         # Aplica para prueba de humo
  # @C######       # ID CP en la herramienta de gestion de pruebas (TestRail / XRay ...)
  # @Actual        # Escenario que se esta automatizando/trabajando actualmente


  @HP
  @Regresion
  @CP-001 # Acceder con credenciales correctamente
  Escenario: Acceder con credenciales correctamente
      # R/ ¿Donde se encuentra el actor? --> ubicación / contexto
      # R/ ¿Que acabó de realizar el actor? --> previamente, en tiempo pasado
    Dado que el "Usuario" se encuentra en el control de acceso de Swag Labs
      # R/ ¿Que esta haciendo el actor? --> en tiempo presente, comportamiento sujeto de prueba
    Cuando intenta acceder con credenciales, correctas
      | usuario_acceso | clave_acceso |
      | standard_user  | secret_sauce |
      # R/ ¿Que se espera? --> en tiempo futuro, validación / verificación
      # R/ ¿Cual es la consecuencia de sus actos? --> en tiempo futuro, lo que sucederá
    Entonces debería mostrarse en la web: "Products"










