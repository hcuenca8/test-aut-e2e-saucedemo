# El "#languaje" No es un comentario representa el tipo de lenguaje utilizado en la estructura de Gherkin
#language: es

# @Todos            # Etiqueta para todos los escenarios
# @{Funcionalidad}  # Palabra clave representativa de la funcionalidad

@Todos
@Compra
@PagoCompra
Característica: Pago de compra
  Yo como cliente de Swag Labs
  Necesito completar el pago de mi compra
  Para darla de alta en el sistema y que puedan gestionar su envio

  # @HP            # Tipo de prueba [Happy Path | Altern Path]
  # @Regresion     # Aplica para regresion
  # @Smoke         # Aplica para prueba de humo
  # @C######       # ID CP en la herramienta de gestion de pruebas (TestRail / XRay ...)
  # @Actual        # Escenario que se esta automatizando/trabajando actualmente


  @HP
  @Regresion
  @CP-006 # Confirma pago de compra
  Escenario: Confirmar pago de compra
      # R/ ¿Donde se encuentra el actor? --> ubicación / contexto
      # R/ ¿Que acabó de realizar el actor? --> previamente, en tiempo pasado
    Dado que el "Cliente" se encuentra confirmando el pago de su compra en Swag Labs
      | usuario_acceso | clave_acceso | productos_catalogo                      | nombre_comprador | apellido_comprador | codigo_postal_comprador |
      | standard_user  | secret_sauce | Sauce Labs Onesie;Sauce Labs Bike Light | Hector Fabio     | Cuenca Madrid      | 076001                  |
      # R/ ¿Que esta haciendo el actor? --> en tiempo presente, comportamiento sujeto de prueba
    Cuando confirma su pago
      # R/ ¿Que se espera? --> en tiempo futuro, validación / verificación
      # R/ ¿Cual es la consecuencia de sus actos? --> en tiempo futuro, lo que sucederá
    Entonces debería mostrarse en la web: "Thank you for your order!"
