package com.saucedemo.test.automation.e2e.setups.hooks.postproduction.gradletasks;

import com.saucedemo.test.automation.e2e.utils.gif.ImagenGifUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Spoilers {

    //File.pathSeparator = resolvia ":" y no "/"
    private static final String PATH_SEPARATOR = "/";
    private static final String RUTA_REPORTE_SERENITY = System.getProperty("user.dir")+"/target/site/serenity";
    private static final String RUTA_DIR_SPOILERS = RUTA_REPORTE_SERENITY+"/spoilers/features";
    private static final String RGX_EVIDENCIA = "<img src=\"([^\"]+)\" title=\" ([^0-9]+.+)\" width=";
    private static final String RGX_TITULOS = "\\.html\">(.*)</a></span>";
    private static final String SUFIJO_HTML_DETALLE_EVIDENCIA = "_screenshots.html";
    private static final String FRM_NUM_CASO = "[#]";
    private static final String FRM_NOMBRE_CASO = FRM_NUM_CASO+". ";
    private static final String FRM_DIR_CASO = "caso "+FRM_NUM_CASO+PATH_SEPARATOR;
    private static final String FRM_NUM_EVIDENCIA = ". ";
    private static final String EXT_EVIDENCIA = ".png";
    private static final String EXT_CASO_GIF = ".gif";
    private static final String DADO = "DADO";
    private static final String CUANDO = "CUANDO";
    private static final String ENTONCES = "ENTONCES";
    private static final String THEN = "THEN";
    private static final String COMPLETED = "(completed)";
    private static final String RGX_LIMPIAR_NOMBRE = "("+Pattern.quote(COMPLETED)+")|\\|.*";
    private static final int TIEMPO_MS_ENTRE_IMAGEN_GIF = 500;
    private static final boolean REPRODUCIR_GIF_CONTINUO = true;

    private static void crearSpoilersGIF(HashMap<String,List<File>> hmImagenes)
        throws IOException
    {
        for (Map.Entry<String,List<File>> entry : hmImagenes.entrySet())
        {
            new Thread(() -> {
                //try (FileOutputStream outputStream = new FileOutputStream(entry.getKey()))
                try (ImageOutputStream output = new FileImageOutputStream(new File(entry.getKey())))
                {
                    BufferedImage imagen1 = ImageIO.read(entry.getValue().get(0));
                    //GifEncoder gifEncoder = new GifEncoder(outputStream, imagen1.getWidth(), imagen1.getHeight(), 1);
                    ImagenGifUtil writer = new ImagenGifUtil(
                        output, imagen1.getType(), TIEMPO_MS_ENTRE_IMAGEN_GIF, REPRODUCIR_GIF_CONTINUO
                    );

                    for(File imagen : entry.getValue())
                    {
                        writer.writeToSequence(ImageIO.read(imagen));
                        //ImageOptions options = new ImageOptions();
                        //Set 500ms between each frame
                        //options.setDelay(500, TimeUnit.MILLISECONDS);
                        //Use Floyd Steinberg dithering as it yields the best quality
                        //options.setDitherer(FloydSteinbergDitherer.INSTANCE);

                        //Create GIF encoder with same dimension as of the source images
                        //gifEncoder.addImage(getImagenArray(imagen), options);
                    }
                    writer.close();
                    //gifEncoder.finishEncoding();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }

    public static void identificarSpoilersGIF(String rutaEvidencias, String contenidoHtmlEvidencia)
        throws IOException
    {
        String rutaCasoGif=null;
        int numCaso = 1;
        HashMap<String,List<File>> hmImagenes = new LinkedHashMap<>();

        Matcher m = Pattern.compile(RGX_EVIDENCIA)
            .matcher(contenidoHtmlEvidencia);

        while(  m.find()    )
        {
            String nombreImagen = m.group(1);
            String tituloImagen = m.group(2).trim();

            if( StringUtils.startsWithIgnoreCase(tituloImagen,CUANDO)
                && !tituloImagen.contains(COMPLETED)
            ){
                rutaCasoGif = rutaEvidencias+FRM_NOMBRE_CASO.replace(FRM_NUM_CASO,String.valueOf(numCaso))
                    +   tituloImagen.replaceAll(RGX_LIMPIAR_NOMBRE,StringUtils.EMPTY).trim()
                    +   EXT_CASO_GIF
                ;
                numCaso++;
            }

            if(rutaCasoGif != null)
            {
                List<File> lstImagenes;
                if( (lstImagenes = hmImagenes.get(rutaCasoGif)) == null
                ){
                    lstImagenes = new ArrayList<>();
                    hmImagenes.put(rutaCasoGif,lstImagenes);
                }

                lstImagenes.add(new File(RUTA_REPORTE_SERENITY+PATH_SEPARATOR+nombreImagen));
            }
        }

        Spoilers.crearSpoilersGIF(hmImagenes);
    }

    private static void identificarSpoilersPNG(String rutaEvidencias, String contenidoHtmlEvidencia)
        throws IOException
    {
        HashMap<String,File> hmImagenes = new LinkedHashMap<>();
        List<String> lstNombreImagenes = new ArrayList<>();
        int numCaso = 1;
        int numImagen = 0;
        String rutaDirCaso=StringUtils.EMPTY;
        String nombreDado = StringUtils.EMPTY;
        boolean capturaSpoilersActivada=false;

        Matcher m = Pattern.compile(RGX_EVIDENCIA)
            .matcher(contenidoHtmlEvidencia);

        while(  m.find()    )
        {
            String imagen = m.group(1);
            String nombre = m.group(2).trim();

            if( (   StringUtils.startsWithIgnoreCase(nombre,DADO)
                    || StringUtils.startsWithIgnoreCase(nombre,CUANDO)
                    || StringUtils.startsWithIgnoreCase(nombre,ENTONCES)
                ) && nombre.contains(COMPLETED) || StringUtils.startsWithIgnoreCase(nombre,THEN)
            ){
                //grupo de evidencias a descartar
                //grupos de evidencias "completadas" con referencia a los enunciados padre (DADO,CUANDO,ENTONCES)
                //evidencia asociada con la tarea de verificacion/validacion "then"
                continue;
            }else{
                //grupo de evidencias a tener en cuenta
                if( StringUtils.startsWithIgnoreCase(nombre,DADO)
                ){
                    //evidencia inicial, referente al enunciado padre, DADO
                    //inicializar/preparar para la captura de spoilers
                    nombreDado = nombre;
                    rutaDirCaso = FRM_DIR_CASO.replace(FRM_NUM_CASO,String.valueOf(numCaso));
                    numCaso++;
                    numImagen=1;
                    capturaSpoilersActivada=false;

                }else if( StringUtils.startsWithIgnoreCase(nombre,CUANDO)
                    || capturaSpoilersActivada
                ) {
                    //a partir de la evidencia referente al enunciado padre, CUANDO
                    //captura de spoilers activada
                    capturaSpoilersActivada = true;
                    if( !hmImagenes.containsKey(imagen)
                    ){
                        //Imagen aun no incluido en la lista de Spoiler
                        hmImagenes.put(imagen,new File(RUTA_REPORTE_SERENITY+PATH_SEPARATOR+imagen));
                        //nombre de la imagen de Spoiler
                        nombre = rutaDirCaso+numImagen+FRM_NUM_EVIDENCIA+
                            (   numImagen == 1 && !nombreDado.isEmpty()
                                ? nombreDado
                                : nombre
                            ).replaceAll(RGX_LIMPIAR_NOMBRE,StringUtils.EMPTY).trim()
                        ;
                        lstNombreImagenes.add(nombre);
                        numImagen++;
                    }
                }
            }
        }
        Spoilers.crearSpoilersPNG(rutaEvidencias,new ArrayList<>(hmImagenes.values()),lstNombreImagenes);
    }

    private static void crearSpoilersPNG(String rutaEvidencias, List<File> lstImagenes, List<String> lstNombreImagenes)
        throws IOException
    {
        for( int i = 0; i<lstImagenes.size();i++)
        {
            File imagen = lstImagenes.get(i);
            FileUtils.copyFile(imagen,new File(rutaEvidencias+lstNombreImagenes.get(i)+ EXT_EVIDENCIA));
        }
    }

    private static void gestionarDirectorioSpoiler(File htmlEvidencia)
        throws IOException
    {
        //conservar el tildado en las palabras, de lo contrario "ó" = &oacute
        String contenidoHtmlEvidencia = StringEscapeUtils.unescapeHtml4(
            FileUtils.readFileToString(htmlEvidencia, StandardCharsets.UTF_8)
        );
        //System.err.println(htmlEvidencia.getName()+"\n"+contenidoHtmlEvidencia);
        String rutaEvidencias = RUTA_DIR_SPOILERS;

        Matcher m = Pattern.compile(RGX_TITULOS)
            .matcher(contenidoHtmlEvidencia);

        while(  m.find()    )
        {
            String titulo = m.group(1).trim();
            rutaEvidencias+=PATH_SEPARATOR+titulo;
        }
        File dirEvidencias = new File(rutaEvidencias);
        dirEvidencias.mkdirs();

        if( dirEvidencias.exists()  )
        {
            Spoilers.identificarSpoilersGIF(rutaEvidencias+PATH_SEPARATOR,contenidoHtmlEvidencia);
        }
    }

    private static int[][] getImagenArray(File file) throws IOException {
        //Convert BufferedImage into RGB pixel array
        BufferedImage bufferedImage = ImageIO.read(file);
        int[][] rgbArray = new int[bufferedImage.getHeight()][bufferedImage.getWidth()];
        for (int i = 0; i < bufferedImage.getHeight(); i++) {
            for (int j = 0; j < bufferedImage.getWidth(); j++) {
                rgbArray[i][j] = bufferedImage.getRGB(j, i);
            }
        }
        return rgbArray;
    }

    public static void main(String[] args)
    {
        try {
            System.err.println("!!ALERTA DE SPOILERS¡¡");

            File dirReporteSerenity = new File(RUTA_REPORTE_SERENITY);

            if (dirReporteSerenity.exists()
                && dirReporteSerenity.isDirectory()
            ) {
                File[] htmlEvidencias = Spoilers.filtrarContenidoDirectorio(
                    dirReporteSerenity,
                    SUFIJO_HTML_DETALLE_EVIDENCIA
                );

                Spoilers.borrarContenidoDirectorio(RUTA_DIR_SPOILERS);

                for (File htmlEvidencia : htmlEvidencias) {
                    Spoilers.gestionarDirectorioSpoiler(htmlEvidencia);
                }
            }
        }catch(Exception e){
            System.err.println("!!ALERTA DE SPOILERS¡¡ Fallo");
            e.printStackTrace();
        }
    }

    private static void borrarContenidoDirectorio(String rutaDirectorio)
        throws IOException
    {
        Spoilers.borrarContenidoDirectorio(new File(rutaDirectorio));
    }
    private static void borrarContenidoDirectorio(File directorio)
        throws IOException
    {
        if( directorio.exists()
            && directorio.isDirectory()
        ){
            FileUtils.cleanDirectory(directorio);
        }
    }

    private static File[] filtrarContenidoDirectorio(File directorio, String finalizaEn)
    {
        FilenameFilter aplicarFiltro = (f, name) -> name.endsWith(finalizaEn);
        return directorio.listFiles(aplicarFiltro);
    }
}
