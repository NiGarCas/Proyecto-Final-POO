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
    
    private Nivel nivel;
    private boolean adivinado;
    private String nombre;
    private ArrayList<Equipo> equipos;
    private Letra[] letrasDisponibles;
    private Letra[] letrasRespuesta;
    private int intentos;
    
    private int pista;
    private String pais;
    private String posicion;
    private char primeraLetra;
    private String ultimoEquipo;

    public Jugador(boolean adivinado, String nombre, int intentos, String pais, String posicion) {
        this.adivinado = adivinado;
        this.nombre = nombre;
        char[] nombreEnChar = this.nombre.toCharArray();
        this.equipos = new ArrayList();
        this.letrasDisponibles = new Letra[15];
        this.letrasRespuesta = new Letra[nombreEnChar.length];
//        this.crearLetrasDisponibles();
        this.intentos = intentos;
        this.pais = pais;
        this.posicion = posicion;
        this.primeraLetra = nombreEnChar[0];
        this.pista = 0;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public boolean isAdivinado() {
        return adivinado;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public Letra[] getLetrasDisponibles() {
        return letrasDisponibles;
    }

    public Letra[] getLetrasRespuesta() {
        return letrasRespuesta;
    }

    public int getIntentos() {
        return intentos;
    }

    public int getPista() {
        return pista;
    }
    
    public String getPais() {
        return pais;
    }

    public String getPosicion() {
        return posicion;
    }

    public char getPrimeraLetra() {
        return primeraLetra;
    }

    public String getUltimoEquipo() {
        return ultimoEquipo;
    }

    public void setAdivinado(boolean adivinado) {
        this.adivinado = adivinado;
    }

    public void setLetrasDisponibles(Letra[] letrasDisponibles) {
        this.letrasDisponibles = letrasDisponibles;
    }

    public void setLetrasRespuesta(Letra[] letrasRespuesta) {
        this.letrasRespuesta = letrasRespuesta;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

    public void setPista(int pista) {
        this.pista = pista;
    }
    
    public void agregarEquipo(Equipo equipo){
        this.equipos.add(equipo);
        this.ultimoEquipo = equipo.getNombre();
    }
}
