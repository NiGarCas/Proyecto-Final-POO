/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import datos.Equipo;
import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public class Jugador {
    private boolean adivinado;
    private String nombre;
    private ArrayList<Equipo> equipos;
    private char[] letrasDisponibles;
    private int intentos;
    
    private String pais;
    private String posicion;
    private char primeraLetra;
    private String ultimoEquipo;
    private String respuesta;

    public Jugador(boolean adivinado, String nombre, ArrayList<Equipo> equipos, char[] letrasDisponibles, int intentos, String pais, String posicion, char primeraLetra) {
        this.adivinado = adivinado;
        this.nombre = nombre;
        this.equipos = equipos;
        this.letrasDisponibles = letrasDisponibles;
        this.intentos = intentos;
        this.pais = pais;
        this.posicion = posicion;
        this.primeraLetra = primeraLetra;
        int posicionUltimoEq = this.equipos.size() - 1;
        this.ultimoEquipo = this.equipos.get(posicionUltimoEq).getNombre();
        this.respuesta = nombre;
    }
    
    
}
