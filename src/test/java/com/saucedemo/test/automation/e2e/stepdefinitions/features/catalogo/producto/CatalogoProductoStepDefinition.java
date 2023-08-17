package com.saucedemo.test.automation.e2e.stepdefinitions.features.catalogo.producto;

import com.saucedemo.test.automation.e2e.constants.enums.EtiquetadoComo;
import com.saucedemo.test.automation.e2e.models.params.features.catalogo.producto.ProductoCatalogoParams;
import com.saucedemo.test.automation.e2e.models.scena.Libreto;
import com.saucedemo.test.automation.e2e.models.scena.screenplay.Protagonista;
import com.saucedemo.test.automation.e2e.stepdefinitions.features.cuenta.acceso.AccesoStepDefinition;
import com.saucedemo.test.automation.e2e.stepdefinitions.javadoc.StepDefinitionsJavaDoc;
import com.saucedemo.test.automation.e2e.tasks.features.catalogo.producto.AdicionarAlCarrito;
import com.saucedemo.test.automation.e2e.userinterfaces.features.catalogo.producto.ProductoCatalogoUI;
import com.saucedemo.test.automation.e2e.userinterfaces.features.portal.ResumenCarritoCompraUI;
import com.saucedemo.test.automation.e2e.utils.questions.estadoelementos.constants.enums.EstadoElemento;
import com.saucedemo.test.automation.e2e.utils.questions.estadoelementos.questions.ElEstado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;

/**
 * Para mas informacion:
 * @see StepDefinitionsJavaDoc#CLASE
 */
public class CatalogoProductoStepDefinition
{
    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#DADO
     */
    @Dado("^que el \"(.*)\" se encuentra en el catalogo de productos.*")
    public static void dadoQueSeEncuentraEnElCatalogoDeProductos(String actor, Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_ESCENA_PREVIA_PANTALLA_ANTERIOR
         */
        AccesoStepDefinition.dadoQueSeEncuentraEnElControlDeAcceso(actor);
        AccesoStepDefinition.cuandoIntentaAccederConCredenciales(libreto);
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#DADO
     */
    @Dado("^que el \"(.*)\" ha terminado de agregar articulos a su carrito de compras.*")
    public static void dadoQueHaTerminadoDeAgregarArticulosASuCarritoDeCompras(String actor, Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_ESCENA_PREVIA_PANTALLA_ANTERIOR
         */
        CatalogoProductoStepDefinition.dadoQueSeEncuentraEnElCatalogoDeProductos(actor, libreto);
        CatalogoProductoStepDefinition.cuandoAdicionaUnProductoAlCarrito(libreto);
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#CUANDO
     */
    @Cuando("^adiciona productos? al carrito.*")
    public static void cuandoAdicionaUnProductoAlCarrito(Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_TAREAS
         */
        Protagonista.enEscena().attemptsTo(
            AdicionarAlCarrito.deCompra(
                libreto.getParametrosProductosCatalogo()
            )
        );
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#ENTONCES
     */
    @Entonces("^deberia indicarse la opcion para retirar el producto del carrito.*")
    public static void entoncesDeberiaIndicarseLaOpcionParaRetirarElProductoDelCarrito(Libreto libreto)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_PREGUNTAS
         */

        for(ProductoCatalogoParams producto : libreto.getParametrosProductosCatalogo().getLstProductos())
        {
            Protagonista.enEscena().should(
                GivenWhenThen.seeThat(
                    ElEstado.deLosElementos(
                        ProductoCatalogoUI.BTN_ACCIONAR_CARRITO
                            .of(producto.getNombre(),
                                EtiquetadoComo.RETIRAR.enPantalla()
                            )
                    ).sea(EstadoElemento.VISIBLE)
                )
            );
        }
    }

    /**
     * Para mas informacion:
     * @see StepDefinitionsJavaDoc#ENTONCES
     */
    @Entonces("^debería verse un total de \"(.*)\" elementos? en el carrito.*")
    public static void entoncesDeberiaIndicarseLaOpcionParaRetirarElProductoDelCarrito(String cantidad)
    {
        /**
         * @see StepDefinitionsJavaDoc#ENLAZAR_PREGUNTAS
         */
        Protagonista.enEscena().should(
            GivenWhenThen.seeThat(
                ElEstado.deLosElementos(
                    ResumenCarritoCompraUI.BTN_RESUMEN_TOTAL_COMPRA
                        .of(cantidad)
                ).sea(EstadoElemento.VISIBLE)
            )
        );
    }

}
