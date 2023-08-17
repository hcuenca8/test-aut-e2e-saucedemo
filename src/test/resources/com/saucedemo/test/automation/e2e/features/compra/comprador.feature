# El "#languaje" No es un comentario representa el tipo de lenguaje utilizado en la estructura de Gherkin
#language: es

# @Todos            # Etiqueta para todos los escenarios
# @{Funcionalidad}  # Palabra clave representativa de la funcionalidad

@Todos
@Compra
@DatosComprador
Característica: Información de comprador
  Yo como e-commerce en la venta de articulos en linea
  Necesito obtener la informacion de mi cliente/comprador
  Para tener informacion de contacto, registrarlo como cliente y asociarlo a la compra

  # @HP            # Tipo de prueba [Happy Path | Altern Path]
  # @Regresion     # Aplica para regresion
  # @Smoke         # Aplica para prueba de humo
  # @C######       # ID CP en la herramienta de gestion de pruebas (TestRail / XRay ...)
  # @Actual        # Escenario que se esta automatizando/trabajando actualmente


  @HP
  @Regresion
  @CP-005 # Completa informacion de comprador asociado a la compra
  Escenario: Confirmar los datos del cliente, asociados a la compra
      # R/ ¿Donde se encuentra el actor? --> ubicación / contexto
      # R/ ¿Que acabó de realizar el actor? --> previamente, en tiempo pasado
    Dado que el "Cliente" se encuentra completando su informacion personal para su compra en Swag Labs
      | usuario_acceso | clave_acceso | productos_catalogo  |
      | standard_user  | secret_sauce | Sauce Labs Onesie;Sauce Labs Bike Light |
      # R/ ¿Que esta haciendo el actor? --> en tiempo presente, comportamiento sujeto de prueba
    Cuando confirma sus datos datos personales, correctos
      | nombre_comprador | apellido_comprador | codigo_postal_comprador |
      | Hector Fabio     | Cuenca Madrid      | 076001                |
      # R/ ¿Que se espera? --> en tiempo futuro, validación / verificación
      # R/ ¿Cual es la consecuencia de sus actos? --> en tiempo futuro, lo que sucederá
    Entonces debería mostrarse en la web: "Checkout: Overview"





