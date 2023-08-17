package com.saucedemo.test.automation.e2e.utils.trazas;

import com.saucedemo.test.automation.e2e.utils.parametros.ParamsUtil;
import com.saucedemo.test.automation.e2e.utils.GeneralUtil;
import com.saucedemo.test.automation.e2e.utils.javadoc.JavaDocUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

/**
 * Utilitario para la gestion de trazas (logs), que apoyan el proceso de depuracion
 */
public class TrazaUtil
{

    //public static final String FORMATO = "\tId[{0}]\n\t\t{1}";
    public static final String RGX_ENCONTRAR_METODO = "(?<gr>\\.[^.]+\\.[^.]+)$";
    public static final String RGX_INCLUIR_SALTO_INICIO_METODO = "\n\tTraza: ${gr}";

    public static final String FORMATO = "\n\t\t{1}";

    /**
     *	constante q identifica la posicion de interes a extraer
     * 	de la pila de llamadas de java, al momento de trazar un
     * 	log, para recuperar la ruta de clase que propicio el llamado
     * 	para realizar el trazo de log
     */
    public static final int ID_POS_CLASE_STACK_TRACE_CURRENT_THREAD = 4;

    public static final String SALTO_LINEA = "\n";

    public static final String TAB_LINEA = "\t";

    public static final String IDENTACION = "\n\t\t";

    public static final String RGX_TERMINA_SALTO_O_TAB = "(\\n|\\t)+$";

    /**
     * Para mas informacion:
     * @see JavaDocUtil#CONSTRUCTOR
     */
    private TrazaUtil(){
        GeneralUtil.noPermitaInstanciar();
    }

    /**
     * ********************************************************************
     * @method	informacion
     * 		  	permite realizar el trazo de log de informacion (INFO)
     * @param 	pTraza
     * 			Especificacion del contenido del log a trazar
     * *********************************************************************
     */
    public static void informacion (Object pTraza, Object ... pParametros )
    {
        TrazaUtil.trazar(null,Level.INFO, pTraza, pParametros);
    }

    public static void informacion (Logger logTrazador,Object pTraza, Object ... pParametros)
    {
        TrazaUtil.trazar(logTrazador,Level.INFO, pTraza, pParametros);
    }

    /**
     * ********************************************************************
     * @method	error
     * 		  	permite realizar el trazo de log de error (ERROR)
     * @param 	pTraza
     * 			Especificacion del contenido del log a trazar
     * *********************************************************************
     */
    public static void error (Object pTraza, Object ... pParametros)
    {
        TrazaUtil.trazar(null,Level.ERROR, pTraza, pParametros);
    }

    public static void error (Logger logTrazador, Object pTraza, Object ... pParametros)
    {
        TrazaUtil.trazar(logTrazador,Level.ERROR, pTraza, pParametros);
    }

    /**
     * ********************************************************************
     * @method	advertencia
     * 		  	permite realizar el trazo de log de advertencia (WARN)
     * @param 	pTraza
     * 			Especificacion del contenido del log a trazar
     * *********************************************************************
     */
    public static void advertencia (Object pTraza, Object ... pParametros)
    {
        TrazaUtil.trazar(null, Level.WARN, pTraza, pParametros);
    }

    public static void advertencia (Logger logTrazador,Object pTraza, Object ... pParametros)
    {
        TrazaUtil.trazar(logTrazador,Level.WARN, pTraza, pParametros);
    }

    /**
     * ********************************************************************
     * @method	depuracion
     * 		  	permite realizar el trazo de log de depuracion (DEBUG)
     * @param 	pTraza
     * 			Especificacion del contenido del log a trazar
     * *********************************************************************
     */
    public static void depuracion (Object pTraza, Object ... pParametros)
    {
        TrazaUtil.trazar(null,Level.DEBUG, pTraza, pParametros);
    }

    public static void depuracion (Logger logTrazador, Object pTraza, Object ... pParametros)
    {
        TrazaUtil.trazar(logTrazador,Level.DEBUG, pTraza, pParametros);
    }

    /**
     * ********************************************************************
     * @method	seguimiento
     * 		  	permite realizar el trazo de log de seguimiento (TRACE)
     * @param 	pTraza
     * 			Especificacion del contenido del log a trazar
     * *********************************************************************
     */
    public static void seguimiento	(Object pTraza, Object ... pParametros)
    {
        TrazaUtil.trazar(null,Level.TRACE, pTraza, pParametros);
    }

    public static void seguimiento	(Logger logTrazador, Object pTraza, Object ... pParametros)
    {
        TrazaUtil.trazar(logTrazador,Level.TRACE, pTraza, pParametros);
    }

    /**
     * ********************************************************************
     * @method	general
     * 		  	permite realizar el trazo de log segun el nivel indicado
     * @param 	pTraza
     * 			Especificacion del contenido del log a trazar
     * @param	pNivel
     * 			Nivel de la traza de log (DEBUG, ERROR, WARN, INFO, etc)
     * *********************************************************************
     */
    public static void general	(	Level pNivel,
                                       Object pTraza,
                                       Object ... pParametros
    )
    {
        TrazaUtil.trazar(null,pNivel, pTraza, pParametros);
    }


    public static void general	(	Logger logTrazador,
                                       Level pNivel,
                                       Object pTraza,
                                       Object ... pParametros
    )
    {
        TrazaUtil.trazar(logTrazador,pNivel, pTraza, pParametros);
    }

    /**
     * ********************************************************************
     * @method	trazar
     * 		  	metodo encargado de realizar el trazo de log solicitado
     * @param	pNivel
     * 			Nivel de la traza de log (DEBUG, ERROR, WARN, INFO, etc)
     * @param	pTraza
     * 			Especificacion del contenido del log a trazar
     * *********************************************************************
     */
    private static void	trazar	(	Logger logTrazador,
                                          Level pNivel,
                                          Object pTraza,
                                          Object ... pParametros
    )
    {
        String strTraza;
        logTrazador = TrazaUtil.calcularTrazador(logTrazador);

        strTraza = TrazaUtil.formatoTraza(pTraza, pParametros);

        switch(pNivel){
            case DEBUG:
                if(logTrazador.isDebugEnabled()){
                    logTrazador.debug(strTraza);
                }
                break;
            case INFO:
                if(logTrazador.isInfoEnabled()){
                    logTrazador.info(strTraza);
                }
                break;
            case ERROR:
                if(logTrazador.isErrorEnabled()){
                    logTrazador.error(strTraza);
                }
                break;
            case WARN:
                if(logTrazador.isWarnEnabled()){
                    logTrazador.warn(strTraza);
                }
                break;
            default:
                if(logTrazador.isTraceEnabled()){
                    logTrazador.trace(strTraza);
                }
                break;
        }
    }

    /**
     * ********************************************************************
     * @method	formatoTraza
     * 		  	establece el formato con el que se registrara la traza
     * @param 	pTraza
     * @return	Especificacion del contenido del log a trazar
     * *********************************************************************
     */
    private static String formatoTraza	(Object pTraza, Object ... pParametros)
    {
        String strTrazaAjustada;

        if(pTraza==null || pTraza.toString().isEmpty()) {
            strTrazaAjustada = StringUtils.EMPTY;
        }else {

            strTrazaAjustada = ParamsUtil.procesarParametros(pTraza.toString(), pParametros);
            strTrazaAjustada = strTrazaAjustada.replace(SALTO_LINEA,IDENTACION)
                .replaceAll(RGX_TERMINA_SALTO_O_TAB, StringUtils.EMPTY);
        }

        return ParamsUtil.procesarParametros(FORMATO, Thread.currentThread().getId(),strTrazaAjustada);
    }

    /**
     * ********************************************************************
     * @method	calcularTrazador
     * 		  	obtiene el trazador, objeto especializado para realizar las
     * 			trazas de log de aplicacion
     * @return	Logger
     * 			Objeto especializado para el realizado de trazos de log
     * *********************************************************************
     */
    private static Logger calcularTrazador(Logger logTrazador)
    {
        String strTrace = null;

        if(logTrazador != null) {
            for(int i = ID_POS_CLASE_STACK_TRACE_CURRENT_THREAD ; i<Thread.currentThread().getStackTrace().length ; i++ ) {
                StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[i];
                if(stackTraceElement.getClassName().equals(logTrazador.getName())) {
                    strTrace = stackTraceElement.toString();
                    break;
                }
            }
        }

        if(strTrace == null) {

            strTrace = Thread.currentThread().getStackTrace()[ID_POS_CLASE_STACK_TRACE_CURRENT_THREAD].toString();
        }

        return LoggerFactory.getLogger(strTrace.replaceAll(RGX_ENCONTRAR_METODO,RGX_INCLUIR_SALTO_INICIO_METODO));
    }

    public static Logger getTrazador()
    {
        return getTrazador(Thread.currentThread().getStackTrace().length-1);
    }

    public static Logger getTrazador(int idPosClaseStackTraceCurrentThread)
    {
        String strClase;

        strClase = Thread.currentThread().getStackTrace()[idPosClaseStackTraceCurrentThread].getClassName();

        return LoggerFactory.getLogger(strClase);
    }
}
