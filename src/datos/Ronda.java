/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

/**
 *
 * @author nicol
 */
public class Ronda {
    private DosJugadores dosj;
    private int numero;
    private Jugador jugador;
    private String ganador;
    

    public Ronda(int numero,DosJugadores dosj) {
        this.dosj = dosj;
        this.numero = numero;
        int a = (int) (Math.random() * 8);
        int b = (int) (Math.random() * 29);
        this.jugador = this.dosj.getJuego().getUnJugador().getNiveles().get(a).getJugadores().get(b);
    }

    public DosJugadores getDosj() {
        return dosj;
    }

    public int getNumero() {
        return numero;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public String getGanador() {
        return ganador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }
    
}
