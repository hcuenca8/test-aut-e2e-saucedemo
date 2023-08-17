package com.saucedemo.test.automation.e2e.questions.general.web.pantalla;

import com.saucedemo.test.automation.e2e.userinterfaces.general.web.pantalla.ContenidoWebUI;
import com.saucedemo.test.automation.e2e.questions.javadoc.QuestionsJavaDoc;
import com.saucedemo.test.automation.e2e.utils.questions.estadoelementos.constants.enums.EstadoElemento;
import com.saucedemo.test.automation.e2e.utils.questions.estadoelementos.questions.ElEstado;
import lombok.Builder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * Para mas informacion:
 * @see QuestionsJavaDoc#CLASE
 */
@Builder
public class SeObservaTexto implements Question<Boolean>
{

    private String textos;

    private boolean exacto;

    private static final String INDICADOR_TEXTO_EXACTO = "\\|";

    private static final String RGX_INDICADOR_TEXTO_EXACTO = "(^\\\\"+INDICADOR_TEXTO_EXACTO+")|(\\\\"+INDICADOR_TEXTO_EXACTO+"$)";

    /**
     * Para mas informacion:
     * @see QuestionsJavaDoc#ANSWERED_BY
     */
    @Override
    public Boolean answeredBy(Actor actor)
    {
        /**
         * Para mas informacion:
         * @see QuestionsJavaDoc#ENLAZAR_VALIDACIONES_VERIFICACIONES
         */

        char chrPrimerCaracter = this.textos.charAt(0);
        String strPrimerCaracter = String.valueOf(chrPrimerCaracter);

        String separador = Character.isLetterOrDigit(chrPrimerCaracter)
            || strPrimerCaracter.equals(this.INDICADOR_TEXTO_EXACTO)
            ? null
            : Pattern.quote(strPrimerCaracter);

        String[] textos = separador==null
            ?   new String[]{this.textos}
            :   this.textos.split(separador)
            ;

        boolean resultado = true;

        for(String validarTexto : textos)
        {
            if( validarTexto!=null &&  !validarTexto.isEmpty()  )
            {
                Target lblTexto;
                boolean fueXIndicadorTextoExacto;
                if( (fueXIndicadorTextoExacto =
                    (   validarTexto.startsWith(this.INDICADOR_TEXTO_EXACTO)
                        && validarTexto.endsWith(this.INDICADOR_TEXTO_EXACTO)
                    )
                ) || this.exacto
                ){
                    if(fueXIndicadorTextoExacto){
                        validarTexto = validarTexto.replaceAll(RGX_INDICADOR_TEXTO_EXACTO,StringUtils.EMPTY);
                    }

                    lblTexto = ContenidoWebUI.LBL_TEXTO_EXACTO;
                }else{
                    lblTexto = ContenidoWebUI.LBL_TEXTO;
                }

                if( !ElEstado.deLosElementos(
                        lblTexto.of(validarTexto)
                    ).sea(EstadoElemento.VISIBLE)
                    .answeredBy(actor)
                ) {
                    resultado = false;
                    break;
                }
            }
        }

        return resultado;
    }

    /**
     * Para mas informacion:
     * @see QuestionsJavaDoc#ENLACE
     */
    public static SeObservaTexto enPantalla(String textos, boolean exacto)
    {
        return SeObservaTexto.builder()
            .textos(textos)
            .exacto(exacto)
            .build();
    }
}

