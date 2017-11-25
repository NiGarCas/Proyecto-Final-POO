/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import visualizacion.Ventana;

/**
 *
 * @author nicol
 */
public class Juego {
    private int monedas;
    private UnJugador unJugador;
    private DosJugadores dosJugadores;
    private Ventana ventana;

    public Juego(int monedas, UnJugador unJugador, DosJugadores dosJugadores) {
        this.monedas = monedas;
        this.unJugador = unJugador;
        this.dosJugadores = dosJugadores;
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

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }

    public void setVentana(Ventana ventana) {
        this.ventana = ventana;
    }
    
}
