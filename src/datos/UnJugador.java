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
    private boolean juego_actual;

    public UnJugador(int totalAdivinados) {
        this.niveles = new ArrayList();
        this.totalAdivinados = totalAdivinados;
        this.juego_actual = false;
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

    public void setJuego_actual(boolean juego_actual) {
        this.juego_actual = juego_actual;
    }
    
    public void agregarNivel(Nivel nivel){
        this.niveles.add(nivel);
    }

    public int determinarNivel(String textoBoton) {
        char[] a = textoBoton.toCharArray();
        switch (a[0]){
            case 49:
                return 1;
            case 50:
                return 2;
            case 51:
                return 3;
            case 52:
                return 4;
            case 53:
                return 5;
            case 54:
                return 6;
            case 55:
                return 7;
            case 56:
                return 8;
            case 57:
                return 9;
            default:
                return 0;
        }
    }

    public void anteriorJugador() {
        for(int i = 1;i<30;i++){
            if(this.jugador_Actual.getNombre().equals(this.nivelActual.getJugadores().get(i).getNombre())){
                this.setJugador_Actual(this.nivelActual.getJugadores().get(i-1));
                break;
            }
        }
    }

    public void siguienteJugador() {
        for(int i = 0;i<29;i++){
            if(this.jugador_Actual.getNombre().equals(this.nivelActual.getJugadores().get(i).getNombre())){
                this.setJugador_Actual(this.nivelActual.getJugadores().get(i+1));
                break;
            }
        }
    }
    
}
