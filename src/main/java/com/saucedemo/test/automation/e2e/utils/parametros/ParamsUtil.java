package com.saucedemo.test.automation.e2e.utils.parametros;

import com.saucedemo.test.automation.e2e.utils.GeneralUtil;
import com.saucedemo.test.automation.e2e.utils.javadoc.JavaDocUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

/**
 * Utilitario relacionado con el procesamiento de parametros
 */
public class ParamsUtil
{
    public static final String ID_INICIAL = "{";
    public static final String ID_FINAL = "}";
    public static final String RGX_FORMATO = "\\"+ID_INICIAL+"[0-9]+\\"+ID_FINAL;

    public static final Pattern PAT_RGX_FORMATO = Pattern.compile(RGX_FORMATO);

    /**
     * Para mas informacion:
     * @see JavaDocUtil#CONSTRUCTOR
     */
    private ParamsUtil(){
        GeneralUtil.noPermitaInstanciar();
    }

    public static String procesarParametros(String pCadena, Object ... pParametros) {
        
        if(PAT_RGX_FORMATO.matcher(pCadena).find()) {
            if(pParametros!=null && pParametros.length>0) {
                for(int i=0 ; i<pParametros.length ; i++) {
                    Object parametro = pParametros[i];
                    String valorParametro = parametro==null? StringUtils.EMPTY:parametro.toString();

                    pCadena = pCadena.replace(ID_INICIAL+i+ID_FINAL, valorParametro);
                }
            }
            pCadena = pCadena.replaceAll(RGX_FORMATO,StringUtils.EMPTY);
        }

        return pCadena;
    }
}
