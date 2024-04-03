/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eduar
 */
@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD)
public class CatalogoApp {

    @XmlElementWrapper(name = "catalogo")

    @XmlElement(name = "App")
    private List<App> listaApp;

    private String descripcion;

    public List<App> getListaMuebles() {
        return listaApp;
    }

    public void setLista(List<App> lista) {
        this.listaApp = lista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
