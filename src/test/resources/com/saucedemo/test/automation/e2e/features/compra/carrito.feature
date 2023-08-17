# El "#languaje" No es un comentario representa el tipo de lenguaje utilizado en la estructura de Gherkin
#language: es

# @Todos            # Etiqueta para todos los escenarios
# @{Funcionalidad}  # Palabra clave representativa de la funcionalidad

@Todos
@Compra
@CarritoCompra
Característica: Carrito de compra
  Yo como usuario de Swag Labs
  Necesito ver todos los articulos que inclui en mi carrito de compras
  Para revisarlos antes de proceder con la compra

  # @HP            # Tipo de prueba [Happy Path | Altern Path]
  # @Regresion     # Aplica para regresion
  # @Smoke         # Aplica para prueba de humo
  # @C######       # ID CP en la herramienta de gestion de pruebas (TestRail / XRay ...)
  # @Actual        # Escenario que se esta automatizando/trabajando actualmente


  @HP
  @Regresion
  @CP-004 # Confirma carrito de compras, con articulos
  Escenario: Confirma los articulos incluidos en el carrito de compras
      # R/ ¿Donde se encuentra el actor? --> ubicación / contexto
      # R/ ¿Que acabó de realizar el actor? --> previamente, en tiempo pasado
    Dado que el "Usuario" se encuentra revisando sus articulos en su carrito de compras de su cuenta en Swag Labs
      | usuario_acceso | clave_acceso | productos_catalogo  |
      | standard_user  | secret_sauce | Sauce Labs Onesie;Sauce Labs Bike Light |
      # R/ ¿Que esta haciendo el actor? --> en tiempo presente, comportamiento sujeto de prueba
    Cuando confirma el pedido de articulos de su carrito de compras
      # R/ ¿Que se espera? --> en tiempo futuro, validación / verificación
      # R/ ¿Cual es la consecuencia de sus actos? --> en tiempo futuro, lo que sucederá
    Entonces debería mostrarse en la web: "Checkout: Your Information"





