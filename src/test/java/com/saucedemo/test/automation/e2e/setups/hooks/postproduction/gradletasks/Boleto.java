package com.saucedemo.test.automation.e2e.setups.hooks.postproduction.gradletasks;

import java.io.IOException;
import java.nio.file.*;

public class Boleto {

    private static final String RUTA_REPORTE_SITE = System.getProperty("user.dir")+"/target/site";
    private static final String DIR_REPORTE_SERENITY = "/serenity";
    private static final String RUTA_REPORTE_SERENITY_INICIAL = RUTA_REPORTE_SITE+ DIR_REPORTE_SERENITY;
    private static final String DIR_REPORTE_FINAL = "/report";
    private static final String RUTA_REPORTE_SERENITY_FINAL = RUTA_REPORTE_SERENITY_INICIAL+ DIR_REPORTE_FINAL;
    private static final String RUTA_TEMP_REPORTE_SERENITY_FINAL = RUTA_REPORTE_SITE+ DIR_REPORTE_FINAL;
    private static final String INDEX_HTML = "/index.html";
    //private static final String HTML_PUBLISHER_WRAPPER = "/htmlpublisher-wrapper.html";
    private static final String RUTA_RELATIVA_INDEX_HTML = DIR_REPORTE_FINAL+INDEX_HTML;
    private static final String IFRAME_SHORCUT_INDEX_HTML = "<iframe src=\"."+RUTA_RELATIVA_INDEX_HTML+"\" title=\"W3Schools Free Online Web Tutorials\" width=\"100%\" height=\"100%\"></iframe>";

    public static void main(String[] args) throws IOException
    {
        Path indexHtml = Paths.get(RUTA_REPORTE_SERENITY_INICIAL +INDEX_HTML);

        if( Files.exists(indexHtml) )
        {
            Path dirReporteSerenityInicial = Paths.get(RUTA_REPORTE_SERENITY_INICIAL);
            Path dirTempReporteSerenityFinal = Paths.get(RUTA_TEMP_REPORTE_SERENITY_FINAL);
            Files.move(dirReporteSerenityInicial,dirTempReporteSerenityFinal);
            Path dirReporteSerenityFinal = Paths.get(RUTA_REPORTE_SERENITY_FINAL);
            Files.createDirectories(dirReporteSerenityFinal);
            Files.move(dirTempReporteSerenityFinal,dirReporteSerenityFinal,StandardCopyOption.REPLACE_EXISTING);

            /*
            for(File archivo : dirReporteSerenityInicial.toFile().listFiles()){
                if(archivo.isFile()){
                    archivo.delete();
                }
            }
             */

            Files.writeString(indexHtml,IFRAME_SHORCUT_INDEX_HTML, StandardOpenOption.CREATE);
        }
    }
}
