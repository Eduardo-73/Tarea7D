/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author edu
 */
public class App {

    private int codigo;
    private String nombre;
    private String descripcion;
    private double tamanioKb;
    private int numDescargas;
    private static int contador = 1;

    private static Random rd = new Random();

    public App() {
        this.codigo = contador++;
        this.nombre = "app" + rd.nextInt(1, 9)
                + (char) rd.nextInt(97, 122);
        String[] conjuntoDesc = {"Peliculas", "Discos", "Caset", "Series",
            "Fotos", "Animales", "Ordenadores", "Coches", "TV", "Institutos"};
        this.descripcion = conjuntoDesc[rd.nextInt(conjuntoDesc.length)];
        this.tamanioKb = rd.doubles(1, 100.0,
                1024.0).sum();
        this.numDescargas = rd.ints(1, 0,
                50000).sum();
    }

    public App(int codigo, String nombre, String descripcion, double tamanioKb,
            int numDescargas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamanioKb = tamanioKb;
        this.numDescargas = numDescargas;
    }

    public int getNumDescargas() {
        return numDescargas;
    }

    public void setNumDescargas(int numDescargas) {
        this.numDescargas = numDescargas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTamanioKb() {
        return tamanioKb;
    }

    public void setTamanioKb(double tamanioKb) {
        this.tamanioKb = tamanioKb;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.##");
        sb.append(codigo).append(",");
        sb.append(nombre).append(",");
        sb.append(descripcion).append(",");
        sb.append(df.format(tamanioKb)).append(",");
        sb.append(numDescargas).append("\n");
        return sb.toString();
    }
}
