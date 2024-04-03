/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author edu
 */
public class mainApp {

    public static void main(String[] args) throws JAXBException {
        List<App> lista = new ArrayList();
        for (int i = 0; i < 50; i++) {
            lista.add(new App());
        }
        guardarDatosApp(lista);
        guardar50Archivos(lista);
        guardarArchivosXML(lista);
    }

    private static void crearDirectorio(String ruta) {
        Path directorio = Paths.get(ruta);
        try {
            Files.createDirectory(directorio);
        } catch (FileAlreadyExistsException faee) {
            System.out.println("No se puede crear " + ruta + " porque ya existe");
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + ruta);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + ruta);
            System.out.println("Seguramente la ruta está mal escrita o no existe");
        }
    }

    private static void guardarDatosApp(List<App> lista) {
        String ruta = "./appscsv/aplicacionestxt.csv";
        try (FileWriter escribir = new FileWriter(ruta)) {
            escribir.write("Código,Nombre,Descripción,TamanioKb,NumDescargas\n");
            for (App app : lista) {
                StringBuilder sb = new StringBuilder();
                DecimalFormat df = new DecimalFormat("#,##");
                sb.append(app.getCodigo()).append(",");
                sb.append(app.getNombre()).append(",");
                sb.append(app.getDescripcion()).append(",");
                sb.append(df.format(app.getTamanioKb())).append(",");
                sb.append(app.getNumDescargas()).append("\n");
                escribir.write(sb.toString());
            }
        } catch (IOException ioe) {
            System.out.println("Error");
        }
    }

    private static void guardar50Archivos(List<App> lista) {
        for (App app : lista) {
            String ruta = "./appscsv2/" + app.getNombre();
            try (FileWriter escribir = new FileWriter(ruta)) {
                escribir.write("Código,Nombre,Descripción,TamanioKb,NumDescargas\n");
                StringBuilder sb = new StringBuilder();
                DecimalFormat df = new DecimalFormat("#,##");
                sb.append(app.getCodigo()).append(",");
                sb.append(app.getNombre()).append(",");
                sb.append(app.getDescripcion()).append(",");
                sb.append(df.format(app.getTamanioKb())).append(",");
                sb.append(app.getNumDescargas()).append("\n");
                escribir.write(sb.toString());
            } catch (IOException ioe) {
                System.out.println("Error");
            }
        }
    }

    private static void guardarArchivosXML(List<App> lista) throws JAXBException {
        String ruta = "./appsxml";
        crearDirectorio(ruta);
        CatalogoApp catalogo = new CatalogoApp();
        catalogo.setLista(lista);
        catalogo.setDescripcion("Mi catalogo");
        JAXBContext contexto = JAXBContext.newInstance(CatalogoApp.class);
        // Creo un fichero xml
        Marshaller serializador = contexto.createMarshaller();
        serializador.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        serializador.marshal(catalogo, System.out);
        serializador.marshal(catalogo, new File("./appsxml/aplicacionesxml.xml"));
    }
}
