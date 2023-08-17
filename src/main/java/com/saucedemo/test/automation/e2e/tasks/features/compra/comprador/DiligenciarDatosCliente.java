package com.saucedemo.test.automation.e2e.tasks.features.compra.comprador;

import com.saucedemo.test.automation.e2e.constants.enums.configuracion.Esperas;
import com.saucedemo.test.automation.e2e.interactions.Detener;
import com.saucedemo.test.automation.e2e.interactions.Esperar;
import com.saucedemo.test.automation.e2e.models.params.features.compra.comprador.CompradorParams;
import com.saucedemo.test.automation.e2e.tasks.javadoc.TasksJavaDoc;
import com.saucedemo.test.automation.e2e.userinterfaces.features.compra.comprador.DatosCompradorUI;
import com.saucedemo.test.automation.e2e.utils.gherkin.tabla.utils.TablaGherkinUtil;
import com.saucedemo.test.automation.e2e.utils.questions.estadoelementos.constants.enums.EstadoElemento;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;

/**
 * Para mas informacion:
 * @see TasksJavaDoc#CLASE
 */
@AllArgsConstructor
public class DiligenciarDatosCliente implements Task
{

    private CompradorParams parametros;

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
        actor.attemptsTo(

            Esperar.hastaQue(DatosCompradorUI.TXT_NOMBRE)
                .este(EstadoElemento.VISIBLE)
                .porNoMasDe(Esperas.GENERAL.getTiempo()).segundos(),

            Check.whether(TablaGherkinUtil.campoNoNull(this.parametros.getNombre()))
                .andIfSo(
                    Enter.theValue(this.parametros.getNombre())
                        .into(DatosCompradorUI.TXT_NOMBRE)
                ),

            Check.whether(TablaGherkinUtil.campoNoNull(this.parametros.getApellido()))
                .andIfSo(
                    Enter.theValue(this.parametros.getApellido())
                        .into(DatosCompradorUI.TXT_APELLIDO)
                ),

            Check.whether(TablaGherkinUtil.campoNoNull(this.parametros.getCodigoPostal()))
                .andIfSo(
                    Enter.theValue(this.parametros.getCodigoPostal())
                        .into(DatosCompradorUI.TXT_CODIGO_POSTAL)
                ),

            Detener.por(Esperas.FINALIZANDO_TAREA.getTiempo()).segundos()
        );
    }

    /**
     * Para mas informacion:
     * @see TasksJavaDoc#ENLACE
     */
    public static DiligenciarDatosCliente deLaCompra(CompradorParams parametros)
    {
       return Tasks.instrumented(
           DiligenciarDatosCliente.class,
           parametros
       );
    }
}
