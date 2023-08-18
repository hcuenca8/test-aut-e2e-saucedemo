package com.saucedemo.test.automation.e2e.tasks.features.catalogo.producto;

import com.saucedemo.test.automation.e2e.constants.enums.EtiquetadoComo;
import com.saucedemo.test.automation.e2e.constants.enums.configuracion.Esperas;
import com.saucedemo.test.automation.e2e.interactions.Detener;
import com.saucedemo.test.automation.e2e.models.params.features.catalogo.producto.ProductoCatalogoParams;
import com.saucedemo.test.automation.e2e.models.params.features.catalogo.producto.ProductosCatalogoParams;
import com.saucedemo.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.saucedemo.test.automation.e2e.userinterfaces.features.catalogo.producto.ProductoCatalogoUI;
import com.saucedemo.test.automation.e2e.userinterfaces.features.portal.ResumenCarritoCompraUI;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

/**
 * Para mas informacion:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class AdicionarAlCarrito implements Task
{
    private ProductosCatalogoParams parametros;

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#PERFORM_AS
     */
    @Override
    public <T extends Actor> void performAs(T actor)
    {
        /**
         * Para mas informacion:
         * @see TasksJavaDoc#ENLAZAR_ACCIONES
         */
        for(ProductoCatalogoParams producto : this.parametros.getLstProductos())
        {
            actor.attemptsTo(

                Click.on(ProductoCatalogoUI.BTN_ACCIONAR_CARRITO
                    .of(producto.getNombre(),
                        EtiquetadoComo.ADICIONAR.enPantalla()
                    )
                ),

                Scroll.to(ResumenCarritoCompraUI.LNK_CARRITO),

                Detener.por(Esperas.FINALIZANDO_TAREA.getTiempo()).segundos()
            );
        }

    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static AdicionarAlCarrito deCompra(ProductosCatalogoParams parametros)
    {
       return Tasks.instrumented(
           AdicionarAlCarrito.class,
           parametros
       );
    }
}
