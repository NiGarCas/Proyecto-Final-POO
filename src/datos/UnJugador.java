/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.util.ArrayList;

/**
 *
 * @author nicol
 */
public class UnJugador {
    private Juego juego;
    private ArrayList<Nivel> niveles;
    private Nivel nivelActual;
    private Jugador jugador_Actual;
    private int totalAdivinados;

    public UnJugador(int totalAdivinados) {
        this.niveles = new ArrayList();
        this.totalAdivinados = totalAdivinados;
    }

    public Juego getJuego() {
        return juego;
    }

    public ArrayList<Nivel> getNiveles() {
        return niveles;
    }

    public Nivel getNivelActual() {
        return nivelActual;
    }

    public Jugador getJugador_Actual() {
        return jugador_Actual;
    }

    public int getTotalAdivinados() {
        return totalAdivinados;
    }

    public void setNivelActual(Nivel nivelActual) {
        this.nivelActual = nivelActual;
    }

    public void setJugador_Actual(Jugador jugador_Actual) {
        this.jugador_Actual = jugador_Actual;
    }

    public void setTotalAdivinados(int totalAdivinados) {
        this.totalAdivinados = totalAdivinados;
    }
    
    public void agregarNivel(int numero, int jugadoresAdivinados, int necesariosParaDesbloquear){
        this.niveles.add(new Nivel(numero,jugadoresAdivinados,necesariosParaDesbloquear));
    }
}
