/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.awt.Image;

/**
 *
 * @author nicol
 */
public class Equipo {
    private String nombre;
    private Image camiseta;

    public Equipo(String nombre, Image camiseta) {
        this.nombre = nombre;
        this.camiseta = camiseta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Image getCamiseta() {
        return camiseta;
    }

    public void setCamiseta(Image camiseta) {
        this.camiseta = camiseta;
    }
    
}
