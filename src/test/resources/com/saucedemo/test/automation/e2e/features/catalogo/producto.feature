# El "#languaje" No es un comentario representa el tipo de lenguaje utilizado en la estructura de Gherkin
#language: es

# @Todos            # Etiqueta para todos los escenarios
# @{Funcionalidad}  # Palabra clave representativa de la funcionalidad

@Todos
@Catalogo
@ProductoCatalogo
Característica: Productos del catalogo
  Yo como usuario
  Necesito gestionar el catalogo de productos
  Para buscar y seleccionar los productos de mi interes

  # @HP            # Tipo de prueba [Happy Path | Altern Path]
  # @Regresion     # Aplica para regresion
  # @Smoke         # Aplica para prueba de humo
  # @C######       # ID CP en la herramienta de gestion de pruebas (TestRail / XRay ...)
  # @Actual        # Escenario que se esta automatizando/trabajando actualmente


  @HP
  @CP-002 # adicionar producto al carrito de compras
  Escenario: Adicionar un producto al carrito de compras
      # R/ ¿Donde se encuentra el actor? --> ubicación / contexto
      # R/ ¿Que acabó de realizar el actor? --> previamente, en tiempo pasado
    Dado que el "Usuario" se encuentra en el catalogo de productos de su cuenta en Swag Labs
      | usuario_acceso | clave_acceso |
      | standard_user  | secret_sauce |
      # R/ ¿Que esta haciendo el actor? --> en tiempo presente, comportamiento sujeto de prueba
    Cuando adiciona producto al carrito de compras
      | productos_catalogo   |
      | Sauce Labs Backpack |
      # R/ ¿Que se espera? --> en tiempo futuro, validación / verificación
      # R/ ¿Cual es la consecuencia de sus actos? --> en tiempo futuro, lo que sucederá
    Entonces deberia indicarse la opcion para retirar el producto del carrito
      | productos_catalogo  |
      | Sauce Labs Backpack |
    Y debería verse un total de "1" elemento en el carrito


  @HP
  @Regresion
  @CP-003 # adicionar producto al carrito de compras
  Escenario: Adicionar mas de un producto al carrito de compras
      # R/ ¿Donde se encuentra el actor? --> ubicación / contexto
      # R/ ¿Que acabó de realizar el actor? --> previamente, en tiempo pasado
    Dado que el "Usuario" se encuentra en el catalogo de productos de su cuenta en Swag Labs
      | usuario_acceso | clave_acceso |
      | standard_user  | secret_sauce |
      # R/ ¿Que esta haciendo el actor? --> en tiempo presente, comportamiento sujeto de prueba
    Cuando adiciona productos al carrito de compras
      | productos_catalogo  |
      | Sauce Labs Onesie;Sauce Labs Bike Light |
      # R/ ¿Que se espera? --> en tiempo futuro, validación / verificación
      # R/ ¿Cual es la consecuencia de sus actos? --> en tiempo futuro, lo que sucederá
    Entonces deberia indicarse la opcion para retirar el producto del carrito
      | productos_catalogo                    |
      | Sauce Labs Onesie;Sauce Labs Bike Light |
    Y debería verse un total de "2" elementos en el carrito


