/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.ArrayList;
import logica.LogicaAEF;
import visualizacion.Ventana;

/**
 *
 * @author nicol
 */
public class Juego {
    private String nombre;
    private int monedas;
    private UnJugador unJugador;
    private DosJugadores dosJugadores;
    private Ventana ventana;
    private boolean pudoRestar;
    private ArrayList<Equipo> equipos;
    private LogicaAEF logica;

    public Juego(String nombre,int monedas, UnJugador unJugador, DosJugadores dosJugadores) {
        this.monedas = monedas;
        this.unJugador = unJugador;
        this.dosJugadores = dosJugadores;
        this.pudoRestar = false;
        this.equipos = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public int getMonedas() {
        return monedas;
    }

    public UnJugador getUnJugador() {
        return unJugador;
    }

    public DosJugadores getDosJugadores() {
        return dosJugadores;
    }

    public Ventana getVentana() {
        return ventana;
    }

    public boolean isPudoRestar() {
        return pudoRestar;
    }

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    public LogicaAEF getLogica() {
        return logica;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    public void setVentana(Ventana ventana) {
        this.ventana = ventana;
    }

    public void setPudoRestar(boolean pudoRestar) {
        this.pudoRestar = pudoRestar;
    }

    public void setLogica(LogicaAEF logica) {
        this.logica = logica;
    }
    
    public boolean restarMonedas(int i) {
        if(i <= this.monedas){
            this.monedas = this.monedas - i;
            return true;
        }else{
            return false;
        }
    }

    public Equipo determinarEquipo(String equipo) {
        Equipo e = null;
        for(Equipo eq : this.equipos){
            if(eq.getNombre().equals(equipo)){
                e = eq;
                break;
            }
        }
        return e;
    }

    
    
}
