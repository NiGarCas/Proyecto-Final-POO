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
    private String camiseta;

    public Equipo(String nombre, String camiseta) {
        this.nombre = nombre;
        this.camiseta = camiseta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCamiseta() {
        return camiseta;
    }
}
